package in.bloomapptest.service;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import in.bloomapp.model.Flower;
import in.bloomapp.service.FlowerManager;

public class TestFlowerManager {

	@Test
	public void displayAllTest() {
		final List<Flower> display=FlowerManager.getFlowers();
		assertEquals( FlowerManager.getFlowers(),display);
		assertEquals(6,display.size());
	}
	

}
