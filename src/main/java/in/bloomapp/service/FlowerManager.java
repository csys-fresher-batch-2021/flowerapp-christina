package in.bloomapp.service;

import java.sql.SQLException;
import java.util.List;
import in.bloomapp.dao1.FlowerManagerDAO1;
import in.bloomapp.exception.DBException;
import in.bloomapp.exception.InvalidStringEXception;
import in.bloomapp.exception.TaskImpossibleException;
import in.bloomapp.exception.ValidFlowerException;
import in.bloomapp.model.Flower;
import in.bloomapp.util.*;
import in.bloomapp.validator.Validator;

public class FlowerManager {

	private FlowerManager() {
		// Default constructor
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
			throws ValidFlowerException, TaskImpossibleException, DBException {

		boolean status = false;
		// checks for blank spaces
		try {
			IsValid.isValidString(type);
			Validator.isCategory(category);
			Validator.flowerIsDuplicate(type, category);
			IsValid.isCharAllowed(type);
			Flower newFlower = new Flower(category, type, price);
			FlowerManagerDAO1.saveFlower(newFlower);
			status = true;
			return status;
		} catch (InvalidStringEXception e) {
			throw new TaskImpossibleException(e, e.getMessage());
		} catch (ValidFlowerException e) {
			throw new TaskImpossibleException(e.getMessage());
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
	public static boolean deleteFlower(String category, String type) throws TaskImpossibleException{

		// Checks for the category ,if deleted gives the success message and returns
		// true

		try {
			Flower oldFlower = Validator.flowerIsExist(category, type);
			FlowerManagerDAO1.removeFlower(oldFlower);
			return true;
		} catch (ValidFlowerException e) {
			throw new TaskImpossibleException("Can't delete");
		}

		catch (DBException|SQLException e) {
			return false;
		}

	}

	public static List<Flower> getFLowerList() {

		List<Flower> flowers=null;
		try {
			flowers = FlowerManagerDAO1.getFlower();
			return flowers;
		} catch (DBException | SQLException e) {
			return flowers;
		}

	}
}
