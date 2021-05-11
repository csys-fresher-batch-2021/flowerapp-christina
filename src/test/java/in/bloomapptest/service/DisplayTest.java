package in.bloomapptest.service;

import static org.junit.Assert.*;
import java.util.List;
import org.junit.Test;
import in.bloomapp.model.Flower;
import in.bloomapp.service.FlowerManager;

public class DisplayTest {

	@Test
	public void displayAllTest() {
		final List<Flower> display=FlowerManager.getFlowerList();
		assertEquals(display, FlowerManager.flowers);
		assertEquals(6,display.size());
	}
	

}
