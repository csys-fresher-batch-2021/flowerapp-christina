package in.bloomapp.validator;

import java.util.List;
import in.bloomapp.dao1.UserManagerDAO;
import in.bloomapp.exception.DBException;
import in.bloomapp.model.User;
import sun.security.validator.ValidatorException;

public class UserValidator {
	
	private UserValidator() {
		
	}
	/**
	 * Checks if the given user is already available in the data
	 * @param userName
	 * @param password
	 * @return
	 * @throws DBException
	 */
	public static boolean userIsExist(String userName,String password) throws DBException {
		boolean status=false;
		final List<User> users = UserManagerDAO.get();
		for(User user : users) {
		
			if (user.getName().equalsIgnoreCase(userName) && user.getPassword().equals(password)) {
				status=true;
			}
		}
		return status;
	}
	
	public static void isAlreadyRegistered(Long mobileNo) throws DBException, ValidatorException {
		final List<User> users = UserManagerDAO.get();
		for(User user : users) {
		
			if (mobileNo==user.getMobileNo()) {
				throw new ValidatorException("Mobile number already registered");
			}
		}
	}

}
