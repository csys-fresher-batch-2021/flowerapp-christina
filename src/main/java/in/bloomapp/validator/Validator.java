package in.bloomapp.validator;
import java.io.IOException;

import in.bloomapp.service.FlowerManager;

public class Validator {
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
	

}
