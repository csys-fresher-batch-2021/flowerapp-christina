package in.bloomapp.service;

import java.util.ArrayList;
import java.util.List;

import in.bloomapp.model.Flower;

public class FlowerManager {
	public static final String NATURAL="Natural";
	public static final String ARTIFICIAL="Artiicial";
	private static List<Flower> flowers = new ArrayList<>();
	
	private FlowerManager() {
		
	}

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
	 * @return
	 */
	public static List<Flower> getFlowerList() {
		
		return getFlowers();
	}


	public static List<Flower> getFlowers() {
		return flowers;
	}
	

}
