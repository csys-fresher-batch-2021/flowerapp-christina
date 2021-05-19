package in.bloomapptest.service;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;

import in.bloomapp.dao.FlowerManagerDAO;
import in.bloomapp.model.Flower;


public class TestFlowerManager {

	@Test
	public void displayAllTest() {
		final List<Flower> display=FlowerManagerDAO.getFlowers();
		assertEquals( FlowerManagerDAO.getFlowers(),display);
		
	}
	

}
