package delegate;

import locator.ServiceLocator;
import services.employeeServices.EmployeeServicesRemote;

public class EmployeeServiceDelegate {

	private static final String jndiNameEmployee = "ejb:/esprit-ejb/UserService!edu.app.services.UserServiceRemote";
	
	private static EmployeeServicesRemote getProxyEmployee(){
		return (EmployeeServicesRemote)ServiceLocator.getInstance().getProxy(jndiNameEmployee);
	}
}
