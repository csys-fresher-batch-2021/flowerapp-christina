package in.bloomapp.service;

import java.util.ArrayList;
import java.util.List;

import in.bloomapp.model.Flower;

public class FlowerManager {

	public static List<Flower> flowers = new ArrayList<Flower>();

	// Statically available flowers as appended statically

	static {
		Flower f1 = new Flower("Natural", "Normal Flowers", 300);
		Flower f2 = new Flower("Natural", "Floral Boquet", 1000);
		Flower f3 = new Flower("Natural", "Full decoration package", 10000);
		Flower f4 = new Flower("Artificial", "Normal Flowers", 100);
		Flower f5 = new Flower("Artificial", "Floral Boquet", 600);
		Flower f6 = new Flower("Artificial", "Full decoration package", 8000);
		//Flower f7 = new Flower("Artificial", "Floral garland", 1000);
		flowers.add(f1);
		flowers.add(f2);
		flowers.add(f3);
		flowers.add(f4);
		flowers.add(f5);
		flowers.add(f6);
	//	flowers.add(f7);

	}


	/**
	 * Gets the list of flowers 
	 * @return
	 */
	public static List<Flower> getFlowerList() {
		return flowers;
	}

}
