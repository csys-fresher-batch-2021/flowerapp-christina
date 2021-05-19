package in.bloomapp.service;

import java.io.IOException;
import java.util.List;

import in.bloomapp.dao.FlowerManagerDAO;
import in.bloomapp.model.Flower;
import in.bloomapp.util.*;
import in.bloomapp.validator.Validator;

public class FlowerManager {
	
	private FlowerManager() {
		//Default constructor
	}

	/**
	 * checks for the input category and appends the flower type in that category
	 * 
	 * @param newFlower
	 * @return
	 * @throws IOException
	 */
	public static boolean addFlower(String category, String type, int price) throws IOException {

		// checks for blank spaces
		try {
			if (IsValid.isValidString(type) && Validator.isCategory(category) && IsValid.isCharAllowed(type)&&  !Validator.flowerIsDuplicate(type, category)) {
				Flower newFlower = new Flower(category, type, price);
				FlowerManagerDAO.add(newFlower);
				return true;
			}
		} 
		catch (RuntimeException e) {
			e.printStackTrace();
			throw new RuntimeException("Invalid input");
			
		}
		return false;
	}
	
	/**
	 * Deletes the flower by its category and type
	 * @param category
	 * @param type
	 * @return
	 */
	public static boolean deleteFlower(String category,String type) {

		// Checks for the category ,if deleted gives the success message and returns
		// true
		
		final List<Flower> flowers = FlowerManagerDAO.getFlowers();
		for(Flower item : flowers) {
		
			if (Validator.flowerIsExist(category, type)) {
				FlowerManagerDAO.delete(item);
				return true;
			}
			
		}

			System.out.println("Invalid details");
			return false;

		}
}


