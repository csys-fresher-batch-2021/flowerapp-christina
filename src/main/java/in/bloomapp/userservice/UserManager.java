package in.bloomapp.userservice;

import in.bloomapp.dao1.UserManagerDAO;
import in.bloomapp.exception.DBException;
import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.exception.UserServiceException;
import in.bloomapp.model.User;
import in.bloomapp.util.IsValid;
import in.bloomapp.validator.UserValidator;

public class UserManager {

	private UserManager() {
		
	}
	/**
	 * Validates all constrains adds the user to the Dao
	 * @param userName
	 * @param password
	 * @param email
	 * @param mobileNo
	 * @param address
	 * @return
	 * @throws UserServiceException
	 * @throws DBException
	 * @throws InvalidInputException 
	 * @throws ValidatorException 
	 */
	public static boolean addUser(String userName,String password,String email,String mobileNo,String address) throws DBException, InvalidInputException, UserValidator {

		boolean status = false;
		// checks for blank spaces
			IsValid.isValidString(userName);
			IsValid.isCharAllowed(userName);
			IsValid.isValidPassword(password);
			IsValid.isValidMobileNo(mobileNo);
			IsValid.isValidEmail(email);
			IsValid.isValidString(address);
			long mobileNo1 = Long.parseLong(mobileNo);
			UserValidator.isAlreadyRegistered(mobileNo1);
			User newUser = new User(userName,password,email,mobileNo1,address);
			UserManagerDAO.save(newUser);
			status = true;
			return status;

	}
	public static void deleteUser() {
		//to do
	}
	
	public static void updateUser() {
		//to do1
	}
	public static void listUser() {
		//to do
	}
	
	/**
	 * checks for the user is already registered or not and tells the login status
	 * @param userName
	 * @param password
	 * @return
	 * @throws DBException
	 */
	public static boolean loginUser(String userName,String password) throws DBException{
		boolean success=false;
	
			if(UserValidator.userIsExist(userName,password)) {
			success=true;
			}
			
				return success;
		
	}
}

