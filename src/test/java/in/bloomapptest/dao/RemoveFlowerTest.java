package in.bloomapptest.dao;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import in.bloomapp.dao.FlowerManagerDAO;
import in.bloomapp.exception.DBException;
import in.bloomapp.model.Flower;

public class RemoveFlowerTest {
	
	@Before
	public void addFlowerMock() {
		Flower newFlower= new Flower();	
		newFlower.setCategory("Natural");
		newFlower.setType("Rose pack");
		newFlower.setPrice(100);		
		try {
			FlowerManagerDAO flowerManagerDAO=new FlowerManagerDAO();
			flowerManagerDAO.saveFlower(newFlower);		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void validInput() {
		Flower oldFlower=new Flower();
		oldFlower.setCategory("Natural");
		oldFlower.setType("Rose pack");
		oldFlower.setPrice(100);		
		try {
			FlowerManagerDAO flowerManagerDAO=new FlowerManagerDAO();
			flowerManagerDAO.removeFlower(oldFlower);		
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void invalidInput() {
		Flower oldFlower=new Flower();
		oldFlower.setCategory("Natur");
		oldFlower.setType("Rose pack");
		oldFlower.setPrice(100);
		try {
			FlowerManagerDAO flowerManagerDAO=new FlowerManagerDAO();
			flowerManagerDAO.removeFlower(oldFlower);		
		} catch (DBException e) {
			e.printStackTrace();
			String message=e.getMessage();
			assertEquals("Unable to delete flower",message);
		}
	}
}
