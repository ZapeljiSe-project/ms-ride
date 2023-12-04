package si.fri.rso.zapeljise.api.v1;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(info = @Info(title = "API for rides", version = "v1",
        contact = @Contact(email = "gh6987@student.uni-lj.si"),
        license = @License(name = "dev"), description = "API for managing rides."),
        servers = @Server(url = "http://localhost:8080/"))
@ApplicationPath("/v1")
public class RideApplication extends Application {

}