package in.bloomapp.model;

/**
 * Main model class with required field
 * @author chri2631
 *
 */
public class Flower {
	private String category;
	private String type;
	private int price;
	
	/**
	 *  Getter method for the field flower category
	 * @return
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Getter method for the field flower type 
	 * @return
	 */
	public String getType() {
		return type;
	}

	/**
	 *  Getter method for the field flower price
	 * @return
	 */
	public int getPrice() {
		return price;
	}
	
	

	/**
	 * Construct class for the main model class
	 * @param category
	 * @param type
	 * @param price
	 */

	public Flower(String category, String type, int price) {
		super();
		this.category = category;
		this.type = type;
		this.price = price;
	}

	@SuppressWarnings("unused")
	private Flower() {
		
	}
	@Override
	public String toString() {
		return "Flower [category=" + category + ", type=" + type + ", price=" + price + "]";
	}
	
}
