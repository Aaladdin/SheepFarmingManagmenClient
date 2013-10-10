package mainTests;

import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.sun.swing.internal.plaf.basic.resources.basic;

import delegate.AdminServiceDelegate;
import delegate.UserServiceDelegate;


import persistance.Admin;
import persistance.Batiment;
import persistance.Employee;
import persistance.Farm;
import persistance.Sheep;
import services.adminServices.AdminServicesRemote;
import services.batimentServices.BatimentServicesRemote;
import services.employeeServices.EmployeeServicesRemote;
import services.farmServices.FarmServicesRemote;
import services.sheepServices.SheepServicesRemote;


public class TestMain {

	public TestMain() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	
	public static void main(String[] args) throws Exception {
		AdminServicesRemote admin = null ;
		EmployeeServicesRemote employee = null ;
		FarmServicesRemote farm = null ;
		BatimentServicesRemote batiment = null ;
		SheepServicesRemote sheep = null ;
		try {
			Context context = new InitialContext();
			Object a =context.lookup("ejb:/SheepFarmingManagment/AdminServices!services.adminServices.AdminServicesRemote");
			//Object u =context.lookup("ejb:/SheepFarmingManagment/UserServices!services.userServices.UserServicesRemote");
			Object e =context.lookup("ejb:/SheepFarmingManagment/EmployeeServices!services.employeeServices.EmployeeServicesRemote");
			Object s =context.lookup("ejb:/SheepFarmingManagment/SheepServices!services.sheepServices.SheepServicesRemote");
			Object b =context.lookup("ejb:/SheepFarmingManagment/BatimentServices!services.batimentServices.BatimentServicesRemote");
			Object f =context.lookup("ejb:/SheepFarmingManagment/FarmServices!services.farmServices.FarmServicesRemote");

			admin = (AdminServicesRemote) a ;
			employee = (EmployeeServicesRemote) e ;
			farm = (FarmServicesRemote) f ;
			sheep = (SheepServicesRemote) s ;
			batiment = (BatimentServicesRemote) b ;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

/*  //	   Farm f1 = new Farm(0, "FarmaVille", "Nabeul");
       farm.createFarm(f1);
 	  	 Farm f1 = new Farm(); 
	    f1= farm.findFarmById(1);
	//	System.out.println(f1.toString());
		
		BatimentServiceDelegate b1 = new BatimentServiceDelegate("batiment1");
		BatimentServiceDelegate b2 = new BatimentServiceDelegate("batiment2");
		List<BatimentServiceDelegate> batiments = new ArrayList<BatimentServiceDelegate>();
		batiments.add(b1);
		batiments.add(b2);
*/
		//f1.BatimentToFarm(batiments);

		//System.out.println(f1.getBatiments().toString());
	//	farm.createFarm(f1,batiments);

//	Employee emp1 = new Employee("aza", "aa", "aa", "aa", "aa", "aa", "aa", "aa", "aa");
	Admin ad1 = new Admin("ee", "ee", "ee", "ee", "ee", "ee", "ee");
//	Employee emp2 = new  Employee("ala", null, null, null, null, null, null, null, null);
	
//		employee.createEmployee(emp1);
	AdminServiceDelegate.createAdmin(ad1);
//		admin.createAdmin(ad1);
/*	List<Employee> emp = new ArrayList<Employee>();
	emp.add(emp1);
	emp.add(emp2);
	
	BatimentServiceDelegate b = batiment.findBatimentById(1);
	batiment.EmployeeToBatiment(b, emp);
 //   b= batiment.findBatimentById(1);
	b.EmployeeToBatiment(emp);
	batiment.createBatiment(b);*/
	//	BatimentServiceDelegate bb = new BatimentServiceDelegate();
/*	List<Employee> empb = new ArrayList<Employee>();
	empb.add(emp2);
	bb= batiment.findBatimentById(1);
	System.out.println(bb.toString());
	b.EmployeeToBatiment(empb);
	batiment.createBatiment(bb); */
	
		
	/*	
		Sheep sh = new Sheep(0, 04, "arabi", "male", null, null, null, "A-", null, null, 0, 0, null, 0, 0, "happy sheep");
		sh.setBatiment(b1);
		sheep.createSheep(sh);
	*/	

	}

}
