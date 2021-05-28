package in.bloomapp.service;

import java.io.IOException;
import java.util.List;
import in.bloomapp.dao1.FlowerManagerDAO1;
import in.bloomapp.exception.InvalidStringEXception;
import in.bloomapp.exception.ValidFlowerException;
import in.bloomapp.exception.taskImpossibleException;
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
	 * @throws IOException
	 * @throws ValidFlowerException 
	 * @throws taskImpossibleException 
	 */
	public static boolean addFlower(String category, String type, int price) throws IOException, ValidFlowerException, taskImpossibleException {

		boolean status=false;
		// checks for blank spaces
		try {
			IsValid.isValidString(type);
			Validator.isCategory(category);
			Validator.flowerIsDuplicate(type, category);
			IsValid.isCharAllowed(type);
				Flower newFlower = new Flower(category, type, price);
				FlowerManagerDAO1.saveFlower(newFlower);
				status=true;
			return status;
		}
		catch (InvalidStringEXception e) {
			e.printStackTrace();
			throw new taskImpossibleException(e,e.getMessage());
		}
		catch(ValidFlowerException e) {
			e.printStackTrace();
			throw new taskImpossibleException(e.getMessage());
		} 
		catch (Exception e) {
			e.printStackTrace();
			throw new taskImpossibleException(e.getMessage());
			
		}
	
	}

	/**
	 * Deletes the flower by its category and type
	 * 
	 * @param category
	 * @param type
	 * @return
	 * @throws ValidFlowerException 
	 * @throws taskImpossibleException 
	 */
	public static boolean deleteFlower(String category, String type) throws taskImpossibleException {

		// Checks for the category ,if deleted gives the success message and returns
		// true

		try {
		Flower oldFlower = Validator.flowerIsExist(category, type);
			FlowerManagerDAO1.removeFlower(oldFlower);
			return true;
		}
		catch(ValidFlowerException e) {
			throw new taskImpossibleException("Can't delete");
		}

		catch(Exception e) {
			
			e.printStackTrace();
			return false;
		}

	}

	public static List<Flower> getFLowerList() {

		List<Flower> Flowers;
		try {
			Flowers = FlowerManagerDAO1.getFlower();
			return Flowers;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}
}
