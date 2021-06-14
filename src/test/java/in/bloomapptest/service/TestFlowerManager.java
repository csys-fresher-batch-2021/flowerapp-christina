package in.bloomapptest.service;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import in.bloomapp.dao1.FlowerManagerDAO1;
import in.bloomapp.exception.DBException;
import in.bloomapp.model.Flower;


public class TestFlowerManager {

	@Test
	public void displayAllTest() {
		FlowerManagerDAO1 flowerManagerDAO=new FlowerManagerDAO1();
		List<Flower> display;
		try {
			display = flowerManagerDAO.getFlower();
			assertEquals( flowerManagerDAO.getFlower(),display);
		} catch (DBException e) {
			e.printStackTrace();
		}				
	}
	
}
