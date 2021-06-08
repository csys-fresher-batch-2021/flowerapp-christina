package in.bloomapp.validator;

import java.util.List;
import in.bloomapp.model.Flower;
import in.bloomapp.service.CartManager;

public class CartValidation {
	private CartValidation(){
		
	}
	
	

	/**
	 * Checks if the product is already available in the cart
	 * @param flower
	 * @return
	 */
	public static boolean isAddedToCart(Flower flower) {
		boolean isAdded=false;
		List<Flower> order=CartManager.getOrder();
		for (Flower item:order) {
			
			if( (flower.getCategory().equals(item.getCategory()))&& (flower.getType().equals(item.getType()))) {
				isAdded=true;
			}
		}
		return isAdded;
	}
}
