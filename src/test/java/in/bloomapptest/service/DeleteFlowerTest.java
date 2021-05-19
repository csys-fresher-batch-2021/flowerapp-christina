package in.bloomapptest.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.bloomapp.service.FlowerManager;

public class DeleteFlowerTest {

	@Test
	public void test() {
		//Test case with correct input
		
		boolean delete=FlowerManager.deleteFlower("Natural", "Normal Flowers");
		assertTrue(delete);
	}
	
	@Test
	public void test1() {
		//Test case with incorrect flower type
		
		boolean delete=FlowerManager.deleteFlower("Natural", "rose");
		assertFalse(delete);
	}
	
	@Test
	public void test2() {
		//Test case with incorrect category
		
		boolean delete=FlowerManager.deleteFlower("christina", "rose");
		assertFalse(delete);
	}

}
