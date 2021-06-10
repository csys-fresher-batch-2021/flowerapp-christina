package in.bloomapp.model;

import java.time.LocalDate;

/**
 * Main model class with required field
 * @author chri2631
 *
 */
public class Flower {
	private String category;
	private String type;
	private int price;
	private int quantity;
	private String buyer;
	private LocalDate date;
	
	
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
	 *  Getter method for the field flower quantity
	 * @return
	 */
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	public String getBuyer() {
		return buyer;
	}
	/**
	 *  Getter method for the field registered date
	 * @return
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * Constructor classs for the main model class
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
	
	public Flower(String category, String type, int price,int quantity) {
		this.category = category;
		this.type = type;
		this.price = price;
		this.setQuantity(quantity);	
	}
	
	
	public Flower(String category, String type, int price,int quantity, String buyer) {
		this.category = category;
		this.type = type;
		this.price = price;
		this.setQuantity(quantity);	
		this.buyer=buyer;
	}
	
	
	public Flower(String category, String type, int price,LocalDate date,int quantity) {
		this.category = category;
		this.type = type;
		this.price = price;
		this.date= date;
		this.setQuantity(quantity);	
	}
	@SuppressWarnings("unused")
	private Flower() {
		
	}
	@Override
	public String toString() {
		return "Flower [category=" + category + ", type=" + type + ", price=" + price +"]";
	}

	
	
	
}
