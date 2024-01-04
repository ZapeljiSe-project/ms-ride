package si.fri.rso.zapeljise.api.v1;

import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import si.fri.rso.zapeljise.api.v1.resources.RideDataResource;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(info = @Info(title = "API for rides", version = "v1",
        contact = @Contact(email = "gh6987@student.uni-lj.si"),
        license = @License(name = "dev"), description = "API for managing rides."),
        servers = @Server(url = "http://localhost:8080/"))
@ApplicationPath("/v1")
public class RideApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        // Add your JAX-RS resource classes
        classes.add(RideDataResource.class);
        // Add the CorsFilter class
        classes.add(CorsFilter.class);
        return classes;
    }
}