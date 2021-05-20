package in.bloomapptest.validator;

import static org.junit.Assert.*;
import org.junit.Test;
import in.bloomapp.model.Flower;
import in.bloomapp.validator.Validator;

public class FlowerIsExistTest {

	
	@Test
	public void availableFlowerTest1() {
		
		
		Flower available=Validator.flowerIsExist("Natural", "Normal Flowers");
		assertEquals("Natural",available.getCategory());
		assertEquals("Normal Flowers",available.getType());
	}
	
	@Test
	public void availableFlowerTest2() {
		Flower available=Validator.flowerIsExist("Artificial", "Normal Flowers");
		assertEquals("Artificial",available.getCategory());
		assertEquals("Normal Flowers",available.getType());
	}
	@Test
	public void invalidCategoryTest() {
		Flower available=Validator.flowerIsExist("Artif", "Normal flowers");
		assertEquals(null,available);
	}
	
	@Test
	public void invalidFlowerTypeTest() {
		Flower available=Validator.flowerIsExist("Natural", "rose");
		assertEquals(null,available);
	}

}
