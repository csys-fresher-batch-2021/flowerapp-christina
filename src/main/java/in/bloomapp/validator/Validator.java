package in.bloomapp.validator;
import java.io.IOException;
import java.util.List;


import in.bloomapp.model.Flower;
import in.bloomapp.service.FlowerManager;

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
		if(category.equalsIgnoreCase(FlowerManager.NATURAL)|| category.equalsIgnoreCase(FlowerManager.ARTIFICIAL)) {
		
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
		final List<Flower> flowers = FlowerManager.getFlowers();
		for (Flower checkFlower : flowers) {
			if (checkFlower.getCategory().equalsIgnoreCase(category) && checkFlower.getType().equalsIgnoreCase(type)) {
				exists=true;
			}
			

		}
		return exists;
		
	}
	

}
