package si.fri.rso.zapeljise.api.v1;

import com.kumuluz.ee.cors.annotations.CrossOrigin;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.servers.Server;
import si.fri.rso.zapeljise.api.v1.resources.DemoResource;
import si.fri.rso.zapeljise.api.v1.resources.RideDataResource;
import si.fri.rso.zapeljise.api.v1.resources.TownResource;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@OpenAPIDefinition(info = @Info(title = "API for rides", version = "v1",
        contact = @Contact(email = "gh6987@student.uni-lj.si"),
        license = @License(name = "dev"), description = "API for managing rides."),
        servers = @Server(url = "http://52.255.222.173/ms-ride"))
@ApplicationPath("/v1")
@CrossOrigin(allowOrigin="*", supportedMethods = "GET, POST, PUT, HEAD, OPTIONS, DELETE")
public class RideApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> classes = new HashSet<>();
        // Add your JAX-RS resource classes
        classes.add(RideDataResource.class);
        classes.add(DemoResource.class);
        classes.add(TownResource.class);
        // Add the CorsFilter class
        classes.add(CorsFilter.class);
        return classes;
    }
}