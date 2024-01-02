package si.fri.rso.zapeljise.msride.services.beans;

import com.kumuluz.ee.rest.beans.QueryParameters;
import com.kumuluz.ee.rest.utils.JPAUtils;
import org.eclipse.microprofile.metrics.annotation.Timed;
import si.fri.rso.zapeljise.msride.lib.RideData;
import si.fri.rso.zapeljise.msride.models.converters.RideDataConverter;
import si.fri.rso.zapeljise.msride.models.entities.RideDataEntity;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@RequestScoped
public class RideDataBean {
    private Logger log = Logger.getLogger(RideDataBean.class.getName());

    @Inject
    private EntityManager em;

    public List<RideData> getRideData() {
        TypedQuery<RideDataEntity> query = em.createNamedQuery(
                "RideDataEntity.getAll", RideDataEntity.class);
        List<RideDataEntity> resultList = query.getResultList();
        return resultList.stream().map(RideDataConverter::toDto).collect(Collectors.toList());
    }

    @Timed
    public List<RideData> getRideDataFilter(UriInfo uriInfo) {
        QueryParameters queryParameters = QueryParameters.query(uriInfo.getRequestUri().getQuery()).defaultOffset(0)
                .build();
        return JPAUtils.queryEntities(em, RideDataEntity.class, queryParameters).stream()
                .map(RideDataConverter::toDto).collect(Collectors.toList());
    }

    public RideData getRideData(Integer id) {
        RideDataEntity rideDataEntity = em.find(RideDataEntity.class, id);

        if (rideDataEntity == null) {
            throw new NotFoundException();
        }

        RideData rideData = RideDataConverter.toDto(rideDataEntity);
        return rideData;
    }

    public RideData createRideData(RideData rideData) {
        RideDataEntity rideDataEntity = RideDataConverter.toEntity(rideData);

        try {
            beginTx();
            em.persist(rideDataEntity);
            commitTx();
        }
        catch (Exception e) {
            rollbackTx();
        }

        if (rideDataEntity.getId() == null) {
            throw new RuntimeException("Entity was not persisted.");
        }

        return RideDataConverter.toDto(rideDataEntity);
    }

    public RideData putRideData(Integer id, RideData rideData) {
        RideDataEntity c = em.find(RideDataEntity.class, id);

        if (c == null) {
            return null;
        }

        RideDataEntity updatedRideDataEntity = RideDataConverter.toEntity(rideData);

        try {
            beginTx();
            updatedRideDataEntity.setId(c.getId());
            updatedRideDataEntity = em.merge(updatedRideDataEntity);
            commitTx();
        }
        catch (Exception e) {
            rollbackTx();
        }

        return RideDataConverter.toDto(updatedRideDataEntity);
    }

    public boolean deleteRideData(Integer id) {
        RideDataEntity rideData = em.find(RideDataEntity.class, id);

        if (rideData != null) {
            try {
                beginTx();
                em.remove(rideData);
                commitTx();
            }
            catch (Exception e) {
                rollbackTx();
            }
        }
        else {
            return false;
        }

        return true;
    }

    private void beginTx() {
        if (!em.getTransaction().isActive()) {
            em.getTransaction().begin();
        }
    }

    private void commitTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().commit();
        }
    }

    private void rollbackTx() {
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    }
}