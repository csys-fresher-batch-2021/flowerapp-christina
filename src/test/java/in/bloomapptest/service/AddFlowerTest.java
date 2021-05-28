package in.bloomapptest.service;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import in.bloomapp.exception.ValidFlowerException;
import in.bloomapp.exception.taskImpossibleException;
import in.bloomapp.service.FlowerManager;

public class AddFlowerTest {

	@Test
	public void testWithValidInput() {
		
		//Test case with correct input
		
		try {
			if(FlowerManager.addFlower("Natural","Normal Flower",300)) {
				boolean valid=true;
				assertTrue(valid);
			}
			
		}
		
		catch (RuntimeException |IOException | ValidFlowerException | taskImpossibleException e) {
			
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void testWithCategory() {
		
		//Test case with wrong input
		
		try {
			FlowerManager.addFlower("Natur","Normal Flower",300);
			
		}
		
		catch (RuntimeException | IOException | ValidFlowerException | taskImpossibleException e) {
			e.printStackTrace();
			assertEquals("Invalid category",e.getMessage());
		} 
		
		
	}
	@Test
	public void testInvalidString() {
		
		//Test case with wrong input
		
		try {
			
			FlowerManager.addFlower("Natural","         ",300);
			
		}
		
		catch (RuntimeException | IOException | ValidFlowerException | taskImpossibleException e) {
			e.printStackTrace();
			assertEquals("Invalid input",e.getMessage());
		} 
	}
}
