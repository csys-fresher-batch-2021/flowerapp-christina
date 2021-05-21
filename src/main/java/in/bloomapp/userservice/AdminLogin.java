package in.bloomapp.userservice;

public class AdminLogin {
	
	/**
	 * Checks weather the user name and password is valid
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean login(String username, String password) {
		if(username.equalsIgnoreCase("admin")&& password.equals("admin123")){
			return true;
		}
		else {
			return false;
		}
		
	}

}
