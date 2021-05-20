package in.bloomapp.dao;

import java.util.ArrayList;
import java.util.List;

import in.bloomapp.model.Flower;

public class FlowerManagerDAO {
	
	private FlowerManagerDAO(){
		//Default constructor
	}

	public static final String NATURAL = "Natural";
	public static final String ARTIFICIAL = "Artificial";
	private static List<Flower> flowers = new ArrayList<>();


	// Statically available flowers as appended statically

	static {
		Flower f1 = new Flower(NATURAL, "Normal Flowers", 300);
		Flower f2 = new Flower(NATURAL, "Floral Boquet", 1000);
		Flower f3 = new Flower(NATURAL, "Full decoration package", 10000);
		Flower f4 = new Flower(ARTIFICIAL, "Normal Flowers", 100);
		Flower f5 = new Flower(ARTIFICIAL, "Floral Boquet", 600);
		Flower f6 = new Flower(ARTIFICIAL, "Full decoration package", 8000);

		getFlowers().add(f1);
		getFlowers().add(f2);
		getFlowers().add(f3);
		getFlowers().add(f4);
		getFlowers().add(f5);
		getFlowers().add(f6);

	}
	
	
	/**
	 * Gets the list of flowers
	 * 
	 * @return
	 */
	public static List<Flower> getFlowers() {
		return flowers;
	}
	
	/**
	 * Add flowers to the list
	 * @param newFlower
	 */
	public static void add(Flower newFlower) {
		getFlowers().add(newFlower);
	}
	
	/**
	 * Delete mentioned flowers from the list
	 * @param oldFlower
	 */
	public static void delete(Flower oldFlower) {
		getFlowers().remove(oldFlower);
	}
}
