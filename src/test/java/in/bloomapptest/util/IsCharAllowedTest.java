package in.bloomapptest.util;

import static org.junit.Assert.*;
import org.junit.Test;
import in.bloomapp.util.IsValid;


public class IsCharAllowedTest {

	@Test
	public void testWithValidInput() {
		boolean isValid=IsValid.isCharAllowed("Flower");
		assertTrue(isValid);
	}
	
	@Test
	public void testWithNumbers() {
		boolean isValid=IsValid.isCharAllowed("zlower09");
		assertTrue(isValid);
	}
	
	@Test
	public void testWithNumbersAndSpaces() {
		boolean isValid=IsValid.isCharAllowed("flower 09");
		assertTrue(isValid);
	}

	@Test
	public void testWithInvalidInput() {
		boolean isValid=IsValid.isCharAllowed("##@$%^");
		assertFalse(isValid);
	}
}
