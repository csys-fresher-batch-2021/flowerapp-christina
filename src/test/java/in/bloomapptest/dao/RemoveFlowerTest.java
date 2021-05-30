package in.bloomapptest.dao;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import in.bloomapp.dao1.FlowerManagerDAO1;
import in.bloomapp.model.Flower;

public class RemoveFlowerTest {
	
	@Before
	public void addFlowerMock() {
		Flower newFlower= new Flower("Natural","Rose pack", 100);
		try {
			FlowerManagerDAO1.saveFlower(newFlower);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validInput() {
		Flower oldFlower=new Flower("Natural","Rose pack", 100);
		try {
			FlowerManagerDAO1.removeFlower(oldFlower);
			
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void invalidInput() {
		Flower oldFlower=new Flower("Natur","Rose pack", 100);
		try {
			FlowerManagerDAO1.removeFlower(oldFlower);
			
		} catch (SQLException e) {
			e.printStackTrace();
			String message=e.getMessage();
			assertEquals("Unable to delete flower",message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
