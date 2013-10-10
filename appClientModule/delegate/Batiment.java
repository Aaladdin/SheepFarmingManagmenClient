package delegate;

import locator.ServiceLocator;
import services.batimentServices.BatimentServicesRemote;

public class Batiment {

	private static final String jndiNameBatiment = "ejb:/SheepFarmingManagment/BatimentServices!services.batimentServices.BatimentServicesRemote";
	
	private static final BatimentServicesRemote getProxyBatiment(){
		return (BatimentServicesRemote) ServiceLocator.getInstance().getProxy(jndiNameBatiment);
	}
}
