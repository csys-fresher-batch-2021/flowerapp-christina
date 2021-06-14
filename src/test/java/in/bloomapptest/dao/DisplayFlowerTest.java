package in.bloomapptest.dao;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import in.bloomapp.dao1.FlowerManagerDAO1;
import in.bloomapp.model.Flower;
public class DisplayFlowerTest {

	@Test
	public void validTest() {
	
		List<Flower> flowers=null;
		try {
			FlowerManagerDAO1 flowerManagerDAO1=new FlowerManagerDAO1();
			flowers=flowerManagerDAO1.getFlower();
			System.out.println(flowers);
			assertSame(6,flowers.size());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
	}
	
	@Test
	public void notNulltest() {
	
		List<Flower> flowers=null;
		try {
			FlowerManagerDAO1 flowerManagerDAO1=new FlowerManagerDAO1();
			flowers=flowerManagerDAO1.getFlower();
		} catch (Exception e) {
	
			assertNotNull(flowers.size());
			e.printStackTrace();
		}
	}
}

