package delegate;

import java.util.List;

import persistance.Employee;
import locator.ServiceLocator;
import services.employeeServices.EmployeeServicesRemote;

public class EmployeeServiceDelegate {

	private static final String jndiNameEmployee = "ejb:/esprit-ejb/UserService!edu.app.services.UserServiceRemote";
	
	private static EmployeeServicesRemote getProxyEmployee(){
		return (EmployeeServicesRemote)ServiceLocator.getInstance().getProxy(jndiNameEmployee);
	}
	public void createEmployee(Employee employee) {
		getProxyEmployee().createEmployee(employee);
	}
	public void updateEmployee(Employee employee) {
		getProxyEmployee().updateEmployee(employee);	
	}
	public void deleteEmployee(Employee employee) {
		getProxyEmployee().deleteEmployee(employee);	
	}
	public Employee findEmployeeById(int idEmployee) {
		return getProxyEmployee().findEmployeeById(idEmployee);
	}
	public List<Employee> getEmployee() {
		
		return getProxyEmployee().getEmployee();
	}
}
