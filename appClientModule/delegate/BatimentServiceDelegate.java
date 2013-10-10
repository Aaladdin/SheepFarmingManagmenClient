package delegate;

import java.util.List;

import persistance.Batiment;
import persistance.Employee;
import persistance.Sheep;
import locator.ServiceLocator;
import services.batimentServices.BatimentServicesRemote;

public class BatimentServiceDelegate {

	private static final String jndiNameBatiment = "ejb:/SheepFarmingManagment/BatimentServices!services.batimentServices.BatimentServicesRemote";
	
	private static final BatimentServicesRemote getProxyBatiment(){
		return (BatimentServicesRemote) ServiceLocator.getInstance().getProxy(jndiNameBatiment);
	}
	public static void createBatiment(Batiment batiment) {
        getProxyBatiment().createBatiment(batiment);
	}
	public static void updateBatiment(Batiment batiment) {
		getProxyBatiment().updateBatiment(batiment);
	}
	public static void deleteBatiment(Batiment batiment) {
		getProxyBatiment().deleteBatiment(batiment);	
	}
	public static Batiment findBatimentById(int idBatiment) {
        return getProxyBatiment().findBatimentById(idBatiment);
	}
	public static List<Batiment> getBatiment() {
		return getProxyBatiment().getBatiment();
	}
	public static void EmployeeToBatiment(Batiment batiment, List<Employee> employees) {
        getProxyBatiment().EmployeeToBatiment(batiment, employees);
	}
	public void SheepToBatiment(Batiment batiment, List<Sheep> sheeps) {
		getProxyBatiment().SheepToBatiment(batiment, sheeps);
		}
		

}
