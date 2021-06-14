package in.bloomapptest.dao;

import static org.junit.Assert.*;
import org.junit.Test;
import in.bloomapp.dao1.FlowerManagerDAO1;
import in.bloomapp.model.Flower;

public class SaveFlowerTest {

	@Test
	public void testWithNewFLower() {
		Flower newFlower= new Flower();
		newFlower.setCategory("Natural");
		newFlower.setType("Rose pack");
		newFlower.setPrice(100);
		try {
			FlowerManagerDAO1 FlowerManagerDAO1=new FlowerManagerDAO1();
			FlowerManagerDAO1.saveFlower(newFlower);
			
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
			FlowerManagerDAO1 flowerManagerDAO1= new FlowerManagerDAO1();
			flowerManagerDAO1.saveFlower(newFlower);
			
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			assertEquals("Unable to add flower",message);
		}
	}
	

}
