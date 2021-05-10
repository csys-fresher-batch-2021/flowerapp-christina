package in.bloomapp.model;

public class Flowers {
	public String category;
	public String type;
	public int price;


	public Flowers(String category, String type, int price) {
		super();
		this.category = category;
		this.type = type;
		this.price = price;
	}

	@Override
	public String toString() {
		return "Flower [category=" + category + ", type=" + type + ", price=" + price + "]";
	}
}
