package in.bloomapptest.service;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import in.bloomapp.model.Flowers;
import in.bloomapp.service.FlowerManager;

public class DisplayTest {

	@Test
	public void displayAllTest() {
		ArrayList<Flowers> display=FlowerManager.getFlowerList();
		assertEquals(display, FlowerManager.flowers);
		assertEquals(6,display.size());
	}
	

}
