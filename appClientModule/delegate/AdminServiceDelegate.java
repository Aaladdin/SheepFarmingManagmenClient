package delegate;

import java.util.List;

import locator.ServiceLocator;
import persistance.Admin;
import services.adminServices.AdminServicesRemote;

public class AdminServiceDelegate {

	private static final String jndiNameAdmin = "ejb:/SheepFarmingManagment/AdminServices!services.adminServices.AdminServicesRemote";
	
	private static AdminServicesRemote getProxyAdmin(){
		return (AdminServicesRemote)ServiceLocator.getInstance().getProxy(jndiNameAdmin);
	}
	public static void createAdmin(Admin admin) {
		getProxyAdmin().createAdmin(admin);	
	}
	public static void updateAdmin(Admin admin) {
		getProxyAdmin().updateAdmin(admin);
		
	}
	public static void deleteAdmin(Admin admin) {
		getProxyAdmin().deleteAdmin(admin);	
	}
	public static Admin findAdminById(int idAdmin) {
		
		return getProxyAdmin().findAdminById(idAdmin);
	}
	public static List<Admin> getAdmin() {
		
		return getProxyAdmin().getAdmin();
	}
}
