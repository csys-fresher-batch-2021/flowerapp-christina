package in.bloomapptest.service;

import static org.junit.Assert.*;
import org.junit.Test;
import in.bloomapp.exception.ServiceException;
import in.bloomapp.service.FlowerManager;

public class DeleteFlowerTest {

	@Test
	public void withExistingFlower() {
		//Test case with correct input in natural category		
		boolean delete;
		try {
			delete = FlowerManager.deleteFlower("Natural", "Normal Flowers");
			assertTrue(delete);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void existingFlowerinArtificial() {
		//Test case with correct input in artificial flower type		
		boolean delete;
		try {
			delete = FlowerManager.deleteFlower("Artificial", "Full decoration package");
			assertTrue(delete);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void withInvalidCategory() {
		//Test case with incorrect category		
		boolean delete = false;
		try {
			delete = FlowerManager.deleteFlower("christina", "rose");
		} catch (ServiceException e) {

			e.printStackTrace();
			assertFalse(delete);
		}
	}
	
	@Test
	public void withInvalidType() {
		//Test case with incorrect type
		
		boolean delete = false;
		try {
			delete = FlowerManager.deleteFlower("natural", "rose");
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		assertFalse(delete);
	}
	
	
	@Test
	public void testWithInvalidType2() {
		//Test case with incorrect category
		boolean delete = false;
		try {
			delete = FlowerManager.deleteFlower("Artificial", "rose");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(delete);
	}
	
	@Test
	public void testWithInvalidInput() {
		//Test case with invalid input
		
		boolean delete=false;
		try {
			delete = FlowerManager.deleteFlower("           ", "rose");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertFalse(delete);
	}
}
