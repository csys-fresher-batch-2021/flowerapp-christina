package in.bloomapp.userservice;

import in.bloomapp.dao1.UserManagerDAO;
import in.bloomapp.exception.DBException;
import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.exception.UserServiceException;
import in.bloomapp.exception.UserValidationException;
import in.bloomapp.model.User;
import in.bloomapp.util.IsValid;
import in.bloomapp.validator.UserValidator;

public class UserManager {

	private UserManager() {
	}

	/**
	 * Validates all constrains adds the user to the Dao
	 * 
	 * @param userName
	 * @param password
	 * @param email
	 * @param mobileNo
	 * @param address
	 * @return
	 * @throws UserServiceException
	 * @throws DBException
	 * @throws InvalidInputException
	 * @throws UserValidationException
	 * @throws ValidatorException
	 */
	public static boolean addUser(User user)
			throws DBException, InvalidInputException, UserValidationException {

		UserManagerDAO userManagerDAO = new UserManagerDAO();
		boolean status = false;
		// checks for blank spaces
		IsValid.isValidString(user.getName());
		IsValid.isCharAllowed(user.getName());
		IsValid.isValidPassword(user.getPassword());
		IsValid.isValidMobileNo(user.getMobileNo());
		IsValid.isValidEmail(user.getEmail());
		IsValid.isValidString(user.getAddress());
		UserValidator.isAlreadyRegistered(user.getMobileNo());
		userManagerDAO.save(user);
		status = true;
		return status;

	}

	public static void deleteUser() {
		// to do
	}

	public static void updateUser() {
		// to do1
	}

	public static void listUser() {
		// to do
	}

	/**
	 * checks for the user is already registered or not and tells the login status
	 * 
	 * @param userName
	 * @param password
	 * @return
	 * @throws DBException
	 */
	public static boolean loginUser(String userName, String password) throws DBException {

		boolean success = false;
		if (UserValidator.userIsExist(userName, password)) {
			success = true;
		}

		return success;

	}
}
