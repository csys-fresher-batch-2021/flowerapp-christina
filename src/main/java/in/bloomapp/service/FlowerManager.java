package in.bloomapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import in.bloomapp.model.Flower;
import in.bloomapp.util.*;
import in.bloomapp.validator.Validator;

public class FlowerManager {
	public static final String NATURAL = "Natural";
	public static final String ARTIFICIAL = "Artificial";
	private static List<Flower> flowers = new ArrayList<>();

	private FlowerManager() {
		//Default constructor

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
	 * 
	 * @return
	 */
	public static List<Flower> getFlowers() {
		return flowers;
	}

	/**
	 * checks for the input category and appends the flower type in that category
	 * 
	 * @param newFlower
	 * @return
	 * @throws IOException
	 */
	public static boolean addFlower(String category, String type, int price) throws IOException {

		// checks for blank spaces
		try {
			if (IsValid.isValidString(type) && Validator.isCategory(category)) {
				Flower newFlower = new Flower(category, type, price);
				getFlowers().add(newFlower);
				return true;
			}
		} 
		catch (RuntimeException e) {
			e.getMessage();
			e.printStackTrace();
		}
		return false;
	}
}
