package in.bloomapptest.dao;

import static org.junit.Assert.*;
import org.junit.Test;
import in.bloomapp.dao.FlowerManagerDAO;
import in.bloomapp.model.Flower;

public class SaveFlowerTest {

	@Test
	public void testWithNewFLower() {
		Flower newFlower= new Flower();
		newFlower.setCategory("Natural");
		newFlower.setType("Rose pack");
		newFlower.setPrice(100);
		try {
			FlowerManagerDAO FlowerManagerDAO=new FlowerManagerDAO();
			FlowerManagerDAO.saveFlower(newFlower);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void withAlreadyAvailableFlower() {
		Flower newFlower= new Flower();
		newFlower.setCategory("Natural");
		newFlower.setType("Rose pack");
		newFlower.setPrice(100);
		try {
			FlowerManagerDAO flowerManagerDAO= new FlowerManagerDAO();
			flowerManagerDAO.saveFlower(newFlower);
			
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			assertEquals("Unable to add flower",message);
		}
	}
	

}
