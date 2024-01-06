package si.fri.rso.zapeljise.msride.services.beans;

import si.fri.rso.zapeljise.msride.lib.Town;
import si.fri.rso.zapeljise.msride.services.external.TownApiClient;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.logging.Logger;

@RequestScoped
public class TownBean {
    private Logger log = Logger.getLogger(TownBean.class.getName());

    @Inject
    private TownApiClient townApiClient;

    public List<Town> getTowns() {
        return townApiClient.getTowns();
    }
}