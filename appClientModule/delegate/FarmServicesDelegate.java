package delegate;

import java.util.List;

import persistance.Batiment;
import persistance.Farm;
import locator.ServiceLocator;
import services.farmServices.FarmServicesRemote;

public class FarmServicesDelegate {
	private static final String jndiNameFarm = "ejb:/SheepFarmingManagment/FarmServices!services.farmServices.FarmServicesRemote";

	private static final FarmServicesRemote getProxyFarm(){
		return (FarmServicesRemote) ServiceLocator.getInstance().getProxy(jndiNameFarm);
	}
    public static void createFarm(Farm farm){
    	getProxyFarm().createFarm(farm);
    }
	public static void updateFarm(Farm farm) {
		getProxyFarm().updateFarm(farm);
	}
	public static void deleteFarm(Farm farm) {
		getProxyFarm().deleteFarm(farm);
	}
	public static Farm findFarmById(int idFarm) {
		return getProxyFarm().findFarmById(idFarm);
	}
	public static List<Farm> getFarms() {
	    return getProxyFarm().getFarms();
	}
	public static void batimentToFarm(Farm farm, List<Batiment> batiments) {
		getProxyFarm().batimentToFarm(farm, batiments);
	}

}
