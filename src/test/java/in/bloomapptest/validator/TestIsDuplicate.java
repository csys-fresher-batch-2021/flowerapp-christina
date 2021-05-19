package in.bloomapptest.validator;

import static org.junit.Assert.*;

import org.junit.Test;

import in.bloomapp.validator.Validator;

public class TestIsDuplicate {

	@Test
	public void test() {
		
		//Test case with already available flower
		
		String category="artificial";
		String type="Floral Boquet";
		boolean exists=Validator.flowerIsDuplicate(type, category);
		assertEquals(true,exists);
	}
	
	@Test
	public void test1() {
		
		//Test case with new flower
		
		String category="artificila";
		String type="Floral garland";
		boolean exists=Validator.flowerIsDuplicate(type, category);
		assertEquals(false,exists);
	}

}
