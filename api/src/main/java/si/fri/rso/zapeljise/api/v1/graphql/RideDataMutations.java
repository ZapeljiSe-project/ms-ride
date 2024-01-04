package si.fri.rso.zapeljise.api.v1.graphql;

import com.kumuluz.ee.graphql.annotations.GraphQLClass;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLMutation;
import si.fri.rso.zapeljise.msride.lib.RideData;
import si.fri.rso.zapeljise.msride.services.beans.RideDataBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@GraphQLClass
@ApplicationScoped
public class RideDataMutations {
    @Inject
    private RideDataBean rideDataBean;

    @GraphQLMutation
    public RideData addRideData(@GraphQLArgument(name = "rideData") RideData rideData) {
        rideDataBean.createRideData(rideData);
        return rideData;
    }

    @GraphQLMutation
    public DeleteResponse deleteRideData(@GraphQLArgument(name = "id") Integer id) {
        return new DeleteResponse(rideDataBean.deleteRideData(id));
    }
}