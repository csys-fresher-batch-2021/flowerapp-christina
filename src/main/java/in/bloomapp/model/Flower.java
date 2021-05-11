package in.bloomapp.model;

public class Flower {
	private String category;
	private String type;
	private int price;
	public String getCategory() {
		return category;
	}

	public String getType() {
		return type;
	}

	public int getPrice() {
		return price;
	}
	
	


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
