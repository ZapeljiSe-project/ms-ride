package si.fri.rso.zapeljise.api.v1.resources;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import si.fri.rso.zapeljise.msride.lib.RideData;
import si.fri.rso.zapeljise.msride.services.beans.RideDataBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;
import java.util.logging.Logger;

@ApplicationScoped
@Path("/rides")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RideDataResource {
    private Logger log = Logger.getLogger(RideDataResource.class.getName());

    @Inject
    private RideDataBean rideDataBean;

    @Context
    protected UriInfo uriInfo;

    @Operation(description = "Get data of all rides.", summary = "Get all rides.")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "List of data of all rides.",
                    content = @Content(schema = @Schema(implementation = RideData.class, type = SchemaType.ARRAY)),
                    headers = {@Header(name = "X-Total-Count", description = "Number of objects in list.")}
            )})
    @GET
    public Response getRideData() {
        List<RideData> rideData = rideDataBean.getRideDataFilter(uriInfo);
        return Response.status(Response.Status.OK).entity(rideData).build();
    }

    @Operation(description = "Get data for a single ride.", summary = "Get data for a ride.")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "Ride data.",
                    content = @Content(
                            schema = @Schema(implementation = RideData.class))
            )})
    @GET
    @Path("/{rideDataId}")
    public Response getRideData(@Parameter(description = "Ride data ID.", required = true)
                                     @PathParam("rideDataId") Integer rideDataId) {
        RideData rideData = rideDataBean.getRideData(rideDataId);

        if (rideData == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK).entity(rideData).build();
    }

    @Operation(description = "Add ride data.", summary = "Add ride.")
    @APIResponses({
            @APIResponse(responseCode = "201",
                    description = "Ride data successfully added."
            ),
            @APIResponse(responseCode = "405", description = "Validation error.")
    })
    @POST
    public Response createRideData(@RequestBody(
            description = "DTO object with ride data.",
            required = true, content = @Content(
            schema = @Schema(implementation = RideData.class))) RideData rideData) {
        if ((rideData.getFromTown() == null || rideData.getToTown() == null || rideData.getDate() == null ||
                rideData.getTimeMinutes() == null || rideData.getTimeHours() == null || rideData.getPhone() == null)) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        else {
            rideData = rideDataBean.createRideData(rideData);
        }

        return Response.status(Response.Status.CONFLICT).entity(rideData).build();
    }

    @Operation(description = "Update data for a ride.", summary = "Update ride.")
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "Ride data successfully updated."
            )
    })
    @PUT
    @Path("{rideDataId}")
    public Response putRideData(@Parameter(description = "Ride ID.", required = true)
                                     @PathParam("rideDataId") Integer rideDataId,
                                     @RequestBody(
                                             description = "DTO object with ride data.",
                                             required = true, content = @Content(
                                             schema = @Schema(implementation = RideData.class)))
                                             RideData rideData){
        rideData = rideDataBean.putRideData(rideDataId, rideData);

        if (rideData == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.NOT_MODIFIED).build();

    }

    @Operation(description = "Delete data for a ride.", summary = "Delete ride.")
    @APIResponses({
            @APIResponse(
                    responseCode = "200",
                    description = "Ride successfully deleted."
            ),
            @APIResponse(
                    responseCode = "404",
                    description = "Not found."
            )
    })
    @DELETE
    @Path("{rideDataId}")
    public Response deleteRideData(@Parameter(description = "Ride ID.", required = true)
                                        @PathParam("rideDataId") Integer rideDataId){
        boolean deleted = rideDataBean.deleteRideData(rideDataId);

        if (deleted) {
            return Response.status(Response.Status.NO_CONTENT).build();
        }
        else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}