package delegate;

import locator.ServiceLocator;
import services.sheepServices.SheepServicesRemote;

public class SheepServicesDelegate {
	private static final String jndiNameSheep = "ejb:/SheepFarmingManagment/SheepServices!services.sheepServices.SheepServicesRemote";
	
	private static final SheepServicesRemote getProxySheep(){
		return (SheepServicesRemote) ServiceLocator.getInstance().getProxy(jndiNameSheep);
	}

}
