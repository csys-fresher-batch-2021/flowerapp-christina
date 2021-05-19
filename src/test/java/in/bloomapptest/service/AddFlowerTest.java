package in.bloomapptest.service;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import in.bloomapp.service.FlowerManager;

public class AddFlowerTest {

	@Test
	public void test() {
		
		//Test case with correct input
		
		try {
			if(FlowerManager.addFlower("Natural","Normal Flower",300)) {
				boolean valid=true;
				assertTrue(valid);
			}
			
		}
		
		catch (IOException e) {
			
			e.printStackTrace();
			fail();
		}
	}

	@Test
	public void test1() {
		
		//Test case with wrong input
		
		try {
			FlowerManager.addFlower("Natur","Normal Flower",300);
			
		}
		
		catch (RuntimeException e) {
			e.printStackTrace();
			assertEquals("Invalid input",e.getMessage());
		} 
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}