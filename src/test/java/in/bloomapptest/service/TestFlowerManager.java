package in.bloomapptest.service;

import static org.junit.Assert.assertEquals;
import java.util.List;
import org.junit.Test;
import in.bloomapp.dao.FlowerManagerDAO;
import in.bloomapp.exception.DBException;
import in.bloomapp.model.Flower;


public class TestFlowerManager {
	@Test
	public void displayAllTest() {
		FlowerManagerDAO flowerManagerDAO=new FlowerManagerDAO();
		List<Flower> display;
		try {
			display = flowerManagerDAO.getFlower();
			assertEquals( flowerManagerDAO.getFlower(),display);
		} catch (DBException e) {
			e.printStackTrace();
		}				
	}
}
