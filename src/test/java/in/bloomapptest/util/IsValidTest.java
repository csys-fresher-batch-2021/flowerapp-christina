package in.bloomapptest.util;

import static org.junit.Assert.*;
import in.bloomapp.util.*;
import org.junit.Test;

public class IsValidTest {

	@Test
	public void test1() {
		
		//Test case with correct and valid input 
		
		String word = "Garland";
		try {
			if (IsValid.isValidString(word)) {
				boolean valid = true;
				assertEquals(true, valid);
			}
		} 
		catch (RuntimeException e) {
			fail();
		}

	}

	@Test
	public void test2() {
		
		//Test case with usual space
		
		String word = "floral garland";
		try {
			IsValid.isValidString(word);
			boolean valid = true;
			assertEquals(true, valid);

		} 
		catch (RuntimeException e) {
			fail();
		}
	}

	@Test
	public void test3() {
		
		//Test case with invalid input 
		
		String word = "          ";
		try {
			IsValid.isValidString(word);

		} 
		catch (RuntimeException e) {
			assertEquals("Invalid input", e.getMessage());
		}
	}

	@Test
	public void test4() {
		
		//test case with invalid input
		
		String word = "    s ";
		try {
			IsValid.isValidString(word);

		} 
		catch (RuntimeException e) {
			assertEquals("Invalid input", e.getMessage());
		}
	}

	@Test
	public void test5() {
		
		//Test case with invalid input
		
		String word = "$#flower";
		try {
			IsValid.isValidString(word);

		} 
		catch (RuntimeException e) {
			assertEquals("Invalid input", e.getMessage());
		}
	}
}
