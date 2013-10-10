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
	@Override
	public void updateAdmin(Admin admin) {
		ad.merge(admin);
		
	}

	@Override
	public void deleteAdmin(Admin admin) {
		ad.remove(ad.merge(admin));
		
	}

	@Override
	public Admin findAdminById(int idAdmin) {
		
		return ad.find(Admin.class, idAdmin);
	}

	@Override
	public List<Admin> getAdmin() {
		
		return ad.createQuery("From Admin",Admin.class).getResultList();
	}
}
