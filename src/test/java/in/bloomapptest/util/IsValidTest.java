package in.bloomapptest.util;

import static org.junit.Assert.*;
import in.bloomapp.util.*;
import org.junit.Test;

public class IsValidTest {

	@Test
	public void test1() {

		// Test case with correct and valid input

		String word = "Garland";
		boolean valid = IsValid.isValidString(word);
		assertEquals(true, valid);
	}

	@Test
	public void test2() {

		// Test case with usual space

		String word = "floral garland";
		boolean valid = IsValid.isValidString(word);
		assertEquals(true, valid);

	}

	@Test
	public void test3() {

		// Test case with invalid input

		String word = "          ";
		boolean valid = IsValid.isValidString(word);
		assertEquals(false, valid);

	}

}
