package in.bloomapptest.util;

import static org.junit.Assert.*;
import org.junit.Test;

import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.util.BasicValidator;


public class IsCharAllowedTest {

	@Test
	public void testWithValidInput() {
		boolean isValid = false;
		try {
			isValid = BasicValidator.isCharAllowed("Flower");
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
			isValid = BasicValidator.isCharAllowed("zlower09");
			assertTrue(isValid);
		} catch (InvalidInputException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testWithNumbersAndSpaces() {
		boolean isValid = false;
		try {
			isValid = BasicValidator.isCharAllowed("Rose 09");
			assertTrue(isValid);
		} catch (InvalidInputException e) {
			e.printStackTrace();
			fail();
		}
	
	}

	@Test
	public void testWithInvalidInput() {
		try {
			BasicValidator.isCharAllowed("##@$%^");
		} catch (InvalidInputException e) {
			e.printStackTrace();
			String message=e.getMessage();
			assertEquals("Invalid string",message);
		}
	}
}
