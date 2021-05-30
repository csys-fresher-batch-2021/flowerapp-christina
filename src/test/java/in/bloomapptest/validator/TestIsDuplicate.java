package in.bloomapptest.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import in.bloomapp.validator.Validator;

public class TestIsDuplicate {

	@Test
	public void testDuplicateInput() {
		
		//Test case with already available flower
		
		String category="Artificial";
		String type="Floral Boquet";
	    try {
			Validator.flowerIsDuplicate(type, category);
		} catch (Exception e) {
			e.printStackTrace();
			String message=e.getMessage();
			assertEquals("Flower already available",message);
		}
	}
	
	@Test
	public void testNewFlower() {
		
		//Test case with new flower
		
		String category="artificial";
		String type="Floral garland";
		try {
			Validator.flowerIsDuplicate(type, category);
		} catch (Exception e) {
			e.printStackTrace();
			fail();		}

	}

}
