package delegate;

import java.util.List;

import locator.ServiceLocator;
import persistance.User;
import services.userServices.UserServicesRemote;


public class UserServiceDelegate{

	private static final String jndiNameUser = "ejb:/SheepFarmingManagment/UserServices!services.userServices.UserServicesRemote";
	
	private static UserServicesRemote getProxyUser(){
		return (UserServicesRemote)ServiceLocator.getInstance().getProxy(jndiNameUser);
	}
	public static void createUser(User user) {
		getProxyUser().createUser(user);	
	}
	public static User authenticate(String login, String password) {
		return getProxyUser().authenticate(login, password);
	}

	public static void updateUser(User user){
		getProxyUser().updateUser(user);
	}
	public static void deleteUser(User user){
		getProxyUser().deleteUser(user);
	}
	public static User findUserById(int id){
		return getProxyUser().findUserById(id);
	}
	public static List<User> findAllUsers(){
		return getProxyUser().getUsers();
	}

	
}
