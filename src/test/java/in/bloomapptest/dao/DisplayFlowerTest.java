package in.bloomapptest.dao;

import static org.junit.Assert.*;

import java.util.List;
import org.junit.Test;
import in.bloomapp.dao.FlowerManagerDAO;
import in.bloomapp.model.Flower;
public class DisplayFlowerTest {

	@Test
	public void validTest() {
	
		List<Flower> flowers=null;
		try {
			FlowerManagerDAO flowerManagerDAO=new FlowerManagerDAO();
			flowers=flowerManagerDAO.getFlower();
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
			FlowerManagerDAO flowerManagerDAO=new FlowerManagerDAO();
			flowers=flowerManagerDAO.getFlower();
		} catch (Exception e) {
	
			assertNotNull(flowers.size());
			e.printStackTrace();
		}
	}
}

