package delegate;

import java.util.List;

import persistance.Employee;
import locator.ServiceLocator;
import services.employeeServices.EmployeeServicesRemote;

public class EmployeeServiceDelegate {

	private static final String jndiNameEmployee = "ejb:/SheepFarmingManagment/EmployeeServices!services.employeeServices.EmployeeServicesRemote";
	
	private static EmployeeServicesRemote getProxyEmployee(){
		return (EmployeeServicesRemote)ServiceLocator.getInstance().getProxy(jndiNameEmployee);
	}
	public static void createEmployee(Employee employee) {
		getProxyEmployee().createEmployee(employee);
	}
	public static void updateEmployee(Employee employee) {
		getProxyEmployee().updateEmployee(employee);	
	}
	public static void deleteEmployee(Employee employee) {
		getProxyEmployee().deleteEmployee(employee);	
	}
	public static Employee findEmployeeById(int idEmployee) {
		return getProxyEmployee().findEmployeeById(idEmployee);
	}
	public static List<Employee> getEmployee() {
		
		return getProxyEmployee().getEmployee();
	}
}
