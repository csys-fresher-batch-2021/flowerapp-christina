package in.bloomapptest.util;

import static org.junit.Assert.*;
import org.junit.Test;

import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.util.IsValid;


public class IsCharAllowedTest {

	@Test
	public void testWithValidInput() {
		boolean isValid = false;
		try {
			isValid = IsValid.isCharAllowed("Flower");
			assertTrue(isValid);
		} catch (InvalidInputException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			fail();
		}
		
	}
	
	@Test
	public void testWithNumbers() {
		boolean isValid = false;
		try {
			isValid = IsValid.isCharAllowed("zlower09");
			assertTrue(isValid);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testWithNumbersAndSpaces() {
		boolean isValid = false;
		try {
			isValid = IsValid.isCharAllowed("Rose 09");
			assertTrue(isValid);
		} catch (InvalidInputException e) {
			e.printStackTrace();
			fail();
		}
	
	}

	@Test
	public void testWithInvalidInput() {
		try {
			IsValid.isCharAllowed("##@$%^");
		} catch (InvalidInputException e) {
			e.printStackTrace();
			String message=e.getMessage();
			assertEquals("Invalid string",message);
		}
	}
}
