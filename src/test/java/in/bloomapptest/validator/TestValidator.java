package in.bloomapptest.validator;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import in.bloomapp.validator.Validator;

public class TestValidator {

	@Test
	public void test() {
		
		//Test case with correct input
		String word = "artificial";
		try {
			if (Validator.isCategory(word)) {
				boolean valid = true;
				assertEquals(true, valid);
			}
		} 
		catch (RuntimeException e) {
			fail();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@Test
	public void test1() {
		
		//Test case with invalid category
		
		String word = "artif";
		try {
			Validator.isCategory(word);
		} 
		catch (RuntimeException e) {
			assertEquals("Invalid category",e.getMessage());
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
