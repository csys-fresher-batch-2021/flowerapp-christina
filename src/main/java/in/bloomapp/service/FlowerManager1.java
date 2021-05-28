package in.bloomapp.service;

import java.util.List;

import com.google.gson.Gson;
import in.bloomapp.dao1.FlowerManagerDAO1;
import in.bloomapp.model.Flower;

/**
 * Duplicate service class for json purpose
 * @author chri2631
 *
 */
public class FlowerManager1 {
	public static void main(String[] args) {

		List<Flower> flowersList = getFlowers();

		Gson gson = new Gson();
		gson.toJson(flowersList);

	}
	
	/**
	 * Just a duplicate method to get all flowers in database (For JSON purpose)
	 * @return
	 */
	public static List<Flower> getFlowers(){
		List<Flower> flowers = null;
		try {
			flowers = FlowerManagerDAO1.getFlower();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flowers;
		
	}
	

}
