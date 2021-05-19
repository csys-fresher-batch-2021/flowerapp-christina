package in.bloomapp.validator;
import java.io.IOException;
import java.util.List;

import in.bloomapp.dao.FlowerManagerDAO;
import in.bloomapp.model.Flower;


public class Validator {
	 private Validator(){
		//Default constructor
	 }
	/**
	 * Checks if the given category name is valid and correct.
	 * @param category
	 * @return
	 * @throws IOException
	 */
	public static boolean isCategory(String category) throws IOException {
		boolean validity=false;
		if(category.equalsIgnoreCase(FlowerManagerDAO.NATURAL)|| category.equalsIgnoreCase(FlowerManagerDAO.ARTIFICIAL)) {
		
			validity=true;
		
		}
		else {
			
			throw new IOException ("Invalid category");
			
		}
		return validity;
	}
	
	/**
	 * returns true if the flower is already available
	 * @param type
	 * @param category
	 * @return
	 */
	public static boolean flowerIsDuplicate(String type, String category) {
		boolean exists = false;
		//returns true if the flower is already available
		final List<Flower> flowers = FlowerManagerDAO.getFlowers();
		for (Flower checkFlower : flowers) {
			if (checkFlower.getCategory().equalsIgnoreCase(category) && checkFlower.getType().equalsIgnoreCase(type)) {
				exists=true;
			}
			
		}
		return exists;	
	}
	
	/**
	 * Checks weather the given flower is available in the list or not
	 * @param category
	 * @param type
	 * @return
	 */
	public static boolean FlowerIsExist(String category,String type) {

		final List<Flower> flowers = FlowerManagerDAO.getFlowers();
		for(Flower item : flowers) {
		
			if (item.getType().equalsIgnoreCase(type) && item.getCategory().equalsIgnoreCase(category)) {
				//searchFlower=item;
				return true;
			}
		
		}
		return false;
	}

}
