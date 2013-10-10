package delegate;

import locator.ServiceLocator;
import services.farmServices.FarmServicesRemote;

public class FarmServicesDelegate {
	private static final String jndiNameFarm = "ejb:/SheepFarmingManagment/FarmServices!services.farmServices.FarmServicesRemote";

	private static final FarmServicesRemote getProxyFarm(){
		return (FarmServicesRemote) ServiceLocator.getInstance().getProxy(jndiNameFarm);
	}

}
