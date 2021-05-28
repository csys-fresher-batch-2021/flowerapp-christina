package in.bloomapptest.validator;

import static org.junit.Assert.*;
import org.junit.Test;
import in.bloomapp.model.Flower;
import in.bloomapp.validator.Validator;

public class FlowerIsExistTest {

	
	@Test
	public void availableFlowerTest1() {
		Flower available=null;
		try {
			available = Validator.flowerIsExist("Natural", "Floral Boquets");
			assertEquals("Natural",available.getCategory());
			assertEquals("Floral Boquets",available.getType());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}

	}
	
	@Test
	public void availableFlowerTest2() {
		Flower available;
		try {
			available = Validator.flowerIsExist("Artificial", "Normal Flower");
			assertEquals("Artificial",available.getCategory());
			assertEquals("Normal Flower",available.getType());
		} catch (Exception e) {
			e.printStackTrace();
			fail();
		}
		
	}
	@Test
	public void invalidCategoryTest() {
		try {
			Validator.flowerIsExist("Artif", "Normal flowers");
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			assertNull(null);
			assertEquals("Flower not available",message);
		}
		
	}
	
	@Test
	public void invalidFlowerTypeTest() {
		Flower available = null;
		try {
			available = Validator.flowerIsExist("Natural", "rose");
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			assertEquals(null,available);
			assertEquals("Flower not available",message);
		}
		
	}

}
