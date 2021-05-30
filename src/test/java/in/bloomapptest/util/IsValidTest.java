package in.bloomapptest.util;

import static org.junit.Assert.*;

import in.bloomapp.exception.InvalidStringEXception;
import in.bloomapp.util.*;
import org.junit.Test;

public class IsValidTest {

	@Test
	public void testValidInput() {

		// Test case with correct and valid input

		String word = "Garland";
		boolean valid;
		try {
			valid = IsValid.isValidString(word);
			assertEquals(true, valid);
		} catch (InvalidStringEXception e) {
			e.printStackTrace();
			fail();
		}
	
	}

	@Test
	public void testWithUsualSpace() {

		// Test case with usual space

		String word = "floral garland";
		boolean valid;
		try {
			valid = IsValid.isValidString(word);
			assertEquals(true, valid);
		} catch (InvalidStringEXception e) {
			e.printStackTrace();
			fail();
		}
		

	}

	@Test
	public void testInvalidInput() {

		// Test case with invalid input

		String word = "          ";
		try {
			IsValid.isValidString(word);
		} catch (InvalidStringEXception e) {
			e.printStackTrace();
			String message=e.getMessage();
			assertEquals("Invalid String",message);
		}

	}

}
