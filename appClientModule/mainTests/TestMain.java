package mainTests;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


import persistance.Admin;
import persistance.Employee;
import services.adminServices.AdminServicesRemote;
import services.employeeServices.EmployeeServicesRemote;


public class TestMain {

	public TestMain() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		AdminServicesRemote admin = null ;
		EmployeeServicesRemote employee = null ;
		try {
			Context context = new InitialContext();
			Object a =context.lookup("ejb:/SheepFarmingManagment/AdminServices!services.adminServices.AdminServicesRemote");
			//Object u =context.lookup("ejb:/SheepFarmingManagment/UserServices!services.userServices.UserServicesRemote");
			Object e =context.lookup("ejb:/SheepFarmingManagment/EmployeeServices!services.employeeServices.EmployeeServicesRemote");
			admin = (AdminServicesRemote) a ;
			employee = (EmployeeServicesRemote) e ;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		createAdmin(admin);
		createEmployee(employee);

	}

	public static void createAdmin(AdminServicesRemote admin) {
		//User usr = new User(0, "Alaeddine", "Messadi", "root", "root", "alaeddine.messadi@esprit.tn", 0, "Tazarka");
		Admin ad = new Admin("Alaeddine", "Messadi", "root", "root", "alaeddine.messadi@esprit.tn","00998877", "Tazarka");
		admin.createAdmin(ad);
	}
	public static void createEmployee(EmployeeServicesRemote employee) { 
		//User usr = new User(0, "Alaeddine", "Messadi", "root", "root", "alaeddine.messadi@esprit.tn", 0, "Tazarka");
		Employee emp = new Employee("Omar", "BenRhuma", "farmer", "farmer", "omar.benrhouma@esprit.tn","33224433", "Tunis","Farmer","66554433",null);
		employee.createEmployee(emp);

	}
}
