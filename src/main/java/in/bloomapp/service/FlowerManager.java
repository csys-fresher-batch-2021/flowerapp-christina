package in.bloomapp.service;

import java.sql.SQLException;
import java.util.List;
import in.bloomapp.dao1.FlowerManagerDAO1;
import in.bloomapp.exception.DBException;
import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.exception.ServiceException;
import in.bloomapp.exception.ValidFlowerException;
import in.bloomapp.model.Flower;
import in.bloomapp.util.IsValid;
import in.bloomapp.validator.Validator;

public class FlowerManager {

	private FlowerManager() {
		
	}
	/**
	 * checks for the input category and appends the flower type in that category
	 * 
	 * @param newFlower
	 * @return
	 * @throws ValidFlowerException
	 * @throws DBException
	 * @throws SQLException
	 * @throws taskImpossibleException
	 */
	public static boolean addFlower(String category, String type, int price)
			throws ValidFlowerException, ServiceException, DBException {

		FlowerManagerDAO1 flowerManagerDAO1=new FlowerManagerDAO1();
		boolean status = false;
		// checks for blank spaces
		try {
			IsValid.isValidString(type);
			Validator.isCategory(category);
			Validator.flowerIsDuplicate(type, category);
			IsValid.isCharAllowed(type);
			Flower newFlower = new Flower();
			newFlower.setCategory(category);
			newFlower.setType(type);
			newFlower.setPrice(price);
			flowerManagerDAO1.saveFlower(newFlower);
			status = true;
			return status;
		} catch (InvalidInputException e) {
			throw new ServiceException(e, e.getMessage());
		} catch (ValidFlowerException e) {
			throw new ServiceException(e.getMessage());
		} catch (DBException|SQLException e) {
			throw new DBException(e.getMessage());

		}

	}

	/**
	 * Deletes the flower by its category and type
	 * 
	 * @param category
	 * @param type
	 * @return
	 * @throws SQLException 
	 * @throws ValidFlowerException
	 * @throws taskImpossibleException
	 */
	public static boolean deleteFlower(String category, String type) throws ServiceException{

		// Checks for the category ,if deleted gives the success message and returns
		// true

		FlowerManagerDAO1 flowerManagerDAO1=new FlowerManagerDAO1();
		try {
			Flower oldFlower = Validator.flowerIsExist(category, type);
			flowerManagerDAO1.removeFlower(oldFlower);
			return true;
		} catch (ValidFlowerException e) {
			throw new ServiceException("Can't delete");
		}

		catch (DBException|SQLException e) {
			return false;
		}

	}

	/**
	 * gets the list of flowers from database
	 * @return
	 */
	public static List<Flower> getFLowerList() {

		FlowerManagerDAO1 flowerManagerDAO1=new FlowerManagerDAO1();
		List<Flower> flowers=null;
		try {
			flowers = flowerManagerDAO1.getFlower();
			return flowers;
		} catch (DBException e) {
			return flowers;
		}

	}
}
