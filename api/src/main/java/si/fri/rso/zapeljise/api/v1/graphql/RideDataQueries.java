package si.fri.rso.zapeljise.api.v1.graphql;

import com.kumuluz.ee.graphql.annotations.GraphQLClass;
import com.kumuluz.ee.graphql.classes.Filter;
import com.kumuluz.ee.graphql.classes.Pagination;
import com.kumuluz.ee.graphql.classes.PaginationWrapper;
import com.kumuluz.ee.graphql.classes.Sort;
import com.kumuluz.ee.graphql.utils.GraphQLUtils;
import io.leangen.graphql.annotations.GraphQLArgument;
import io.leangen.graphql.annotations.GraphQLQuery;
import si.fri.rso.zapeljise.msride.lib.RideData;
import si.fri.rso.zapeljise.msride.services.beans.RideDataBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@GraphQLClass
@ApplicationScoped
public class RideDataQueries {
    @Inject
    private RideDataBean rideDataBean;

    @GraphQLQuery
    public PaginationWrapper<RideData> allRideData(@GraphQLArgument(name = "pagination") Pagination pagination,
                                                             @GraphQLArgument(name = "sort") Sort sort,
                                                             @GraphQLArgument(name = "filter") Filter filter) {
        return GraphQLUtils.process(rideDataBean.getRideData(), pagination, sort, filter);
    }

    @GraphQLQuery
    public RideData getRideData(@GraphQLArgument(name = "id") Integer id) {
        return rideDataBean.getRideData(id);
    }
}