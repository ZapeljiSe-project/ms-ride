package si.fri.rso.zapeljise.msride.services.external;

import com.kumuluz.ee.configuration.utils.ConfigurationUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import si.fri.rso.zapeljise.msride.lib.Town;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
public class TownApiClient {
    private static final Logger log = Logger.getLogger(TownApiClient.class.getName());

    private Client httpClient;

    private String baseUrl;

    @PostConstruct
    private void init() {
        httpClient = ClientBuilder.newClient();
        baseUrl = ConfigurationUtil.getInstance().get("town-api.url").get();
    }

    public List<Town> getTowns() {
        Response response = httpClient
                .target(baseUrl)
                .request(MediaType.APPLICATION_JSON)
                .get();

        String body = response.readEntity(String.class);

        List<Town> towns = new ArrayList<>();

        JSONArray jsonArray = new JSONArray(body);
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);

            Town town = new Town();
            town.setName(jsonObject.getString("kraj"));

            towns.add(town);
        }

        towns.sort(Comparator.comparing(t -> t.getName().charAt(0)));

        return towns;
    }
}