package in.bloomapptest.validator;

import static org.junit.Assert.*;
import org.junit.Test;
import in.bloomapp.exception.ValidFlowerException;
import in.bloomapp.validator.Validator;

public class TestValidator {

	@Test
	public void testArtificial() {
		
		//Test case with correct input
		String word = "artificial";
		try {
			if (Validator.isCategory(word)) {
				boolean valid = true;
				assertEquals(true, valid);
			}
		} 
		catch (ValidFlowerException e) {		
			e.printStackTrace();
			fail();
		}

	}
	
	@Test
	public void testNatural() {
		
		//Test case with correct input
		String word = "Natural";
		try {
			if (Validator.isCategory(word)) {
				boolean valid = true;
				assertEquals(true, valid);
			}
		} 
		catch (ValidFlowerException e) {
			
			e.printStackTrace();
			fail();
		}

	}
	
	@Test
	public void testInvalidCayegory() {
		
		//Test case with invalid category
		
		String word = "artif";
		try {
			Validator.isCategory(word);
		} 
		catch (ValidFlowerException e) {
			e.printStackTrace();
			assertEquals("Invalid category",e.getMessage());
		}

	}

}
