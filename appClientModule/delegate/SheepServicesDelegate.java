package delegate;

import java.util.List;

import persistance.Sheep;
import locator.ServiceLocator;
import services.sheepServices.SheepServicesRemote;

public class SheepServicesDelegate {
	private static final String jndiNameSheep = "ejb:/SheepFarmingManagment/SheepServices!services.sheepServices.SheepServicesRemote";
	
	private static final SheepServicesRemote getProxySheep(){
		return (SheepServicesRemote) ServiceLocator.getInstance().getProxy(jndiNameSheep);
	}
	public static void createSheep(Sheep sheep) {
		getProxySheep().createSheep(sheep);	
	}
	public static void updateSheep(Sheep sheep) {
		getProxySheep().updateSheep(sheep);
	}
	public static void deleteSheep(Sheep sheep) {
		getProxySheep().deleteSheep(sheep);
	}
	public static Sheep findSheepById(int idSheep) {
		return getProxySheep().findSheepById(idSheep);
	}
	public static List<Sheep> getSheeps() {
		return getProxySheep().getSheeps();
	}

}
