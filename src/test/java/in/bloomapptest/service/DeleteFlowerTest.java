package in.bloomapptest.service;

import static org.junit.Assert.*;

import org.junit.Test;

import in.bloomapp.service.FlowerManager;

public class DeleteFlowerTest {

	@Test
	public void test() {
		//Test case with correct input in natural category
		
		boolean delete=FlowerManager.deleteFlower("Natural", "Normal Flowers");
		assertTrue(delete);
	}
	
	@Test
	public void test1() {
		//Test case with correct input in artificial flower type
		
		boolean delete=FlowerManager.deleteFlower("Artificial", "Full decoration package");
		assertTrue(delete);
	}
	
	@Test
	public void test2() {
		//Test case with incorrect category
		
		boolean delete=FlowerManager.deleteFlower("christina", "rose");
		assertFalse(delete);
	}
	
	@Test
	public void test3() {
		//Test case with incorrect category
		
		boolean delete=FlowerManager.deleteFlower("natural", "rose");
		assertFalse(delete);
	}
	
	
	@Test
	public void test4() {
		//Test case with incorrect category
		
		boolean delete=FlowerManager.deleteFlower("Artificial", "rose");
		assertFalse(delete);
	}
	
	@Test
	public void test5() {
		//Test case with invalid input
		
		boolean delete=FlowerManager.deleteFlower("           ", "rose");
		assertFalse(delete);
	}

}
