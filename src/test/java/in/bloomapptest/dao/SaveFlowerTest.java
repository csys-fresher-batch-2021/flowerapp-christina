package in.bloomapptest.dao;

import static org.junit.Assert.*;
import org.junit.Test;
import in.bloomapp.dao1.FlowerManagerDAO1;
import in.bloomapp.model.Flower;

public class SaveFlowerTest {

	@Test
	public void testWithNewFLower() {
		Flower newFlower= new Flower("Natural","Rose pack", 100);
		try {
			FlowerManagerDAO1.saveFlower(newFlower);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void withAlreadyAvailableFlower() {
		Flower newFlower= new Flower("Natural","Rose pack", 100);
		try {
			FlowerManagerDAO1.saveFlower(newFlower);
			
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			assertEquals("Unable to add flower",message);
		}
	}
	

}
