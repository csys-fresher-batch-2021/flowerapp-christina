package in.bloomapp.service;

import java.util.ArrayList;

import in.bloomapp.model.Flowers;

public class FlowerManager {

	public static ArrayList<Flowers> flowers = new ArrayList<Flowers>();

	// Statically available flowers as appended statically

	static {
		Flowers f1 = new Flowers("Natural", "NORMAL FLOWERS", 300);
		Flowers f2 = new Flowers("Natural", "FLORAL BOQUET", 1000);
		Flowers f3 = new Flowers("Natural", "FULL DECORATION PACKAGE", 10000);
		Flowers f4 = new Flowers("Artificial", "NORMAL FLOWERS", 100);
		Flowers f5 = new Flowers("Artificial", "FLORAL BOQUET", 600);
		Flowers f6 = new Flowers("Artificial", "FULL DECORATION PACKAGE", 8000);
		flowers.add(f1);
		flowers.add(f2);
		flowers.add(f3);
		flowers.add(f4);
		flowers.add(f5);
		flowers.add(f6);

	}


	/**
	 * Gets the list of flowers 
	 * @return
	 */
	public static ArrayList<Flowers> getFlowerList() {
		return flowers;
	}

}
