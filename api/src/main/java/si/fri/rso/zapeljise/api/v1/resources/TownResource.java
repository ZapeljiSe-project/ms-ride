package si.fri.rso.zapeljise.api.v1.resources;

import com.kumuluz.ee.logs.cdi.Log;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.headers.Header;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import si.fri.rso.zapeljise.msride.lib.Town;
import si.fri.rso.zapeljise.msride.services.beans.TownBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log
@ApplicationScoped
@Path("/town")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Town")
public class TownResource {
    private Logger log = Logger.getLogger(TownResource.class.getName());

    @Inject
    private TownBean townDataBean;

    @Operation(description = "Get all Slovenian towns.", summary = "Get all towns.")
    @APIResponses({
            @APIResponse(responseCode = "200",
                    description = "List of all available towns.",
                    content = @Content(schema = @Schema(implementation = Town.class, type = SchemaType.ARRAY)),
                    headers = {@Header(name = "X-Total-Count", description = "Number of objects in list.")}
            )})
    @GET
    public Response getTowns() {
        log.log(Level.INFO, "Entering GET towns method...");

        List<Town> towns = townDataBean.getTowns();

        log.log(Level.INFO, "Exit GET towns method.");

        return Response.status(Response.Status.OK).entity(towns).build();
    }
}