package in.bloomapp.service;

import java.util.ArrayList;
import java.util.List;
import in.bloomapp.model.Flower;
import in.bloomapp.validator.CartValidation;

public class CartManager {
	
	private CartManager() {
		
	}

	private static final List<Flower> order = new ArrayList<>();
	
	/**
	 * Adds the item to the cart
	 * @param item
	 * @param username
	 * @return
	 */
	public static boolean addToCart(Flower item) {

		
		if (CartValidation.isAdded(item)) {
			for (Flower subject : order) {

				if ((subject.getCategory().equals(item.getCategory())) && (subject.getType().equals(item.getType()))) {
					subject.setQuantity(subject.getQuantity() + 1);
				}
			}
		} else {
			order.add(item);
		}
		return true;
	}
	
	/**
	 * Gets the temporary cart list
	 * @return
	 */
	public static List<Flower> getOrder() {

		return order;

	}
}