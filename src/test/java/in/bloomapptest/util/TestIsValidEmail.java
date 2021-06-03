package in.bloomapptest.util;

import static org.junit.Assert.*;

import org.junit.Test;

import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.util.IsValid;

public class TestIsValidEmail {

	@Test
	public void test() {
		try {
			IsValid.isValidEmail("christykumar13@gmail.com");
		} catch (InvalidInputException e) {
			fail();
		}
	}

	@Test
	public void test1() {
		try {
			IsValid.isValidEmail("christykumar13@sethu.ac.in");
		} catch (InvalidInputException e) {
			fail();
		}
	}

	@Test
	public void test3() {
		try {
			IsValid.isValidEmail("christykumar13gmail.com");
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void test4() {
		try {
			IsValid.isValidEmail("christykumar13gmail.com");
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void test5() {
		try {
			IsValid.isValidEmail("christykumar13@gmailcom");
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void test6() {
		try {
			IsValid.isValidEmail("christykumar13gmailcom");
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void test7() {
		try {
			IsValid.isValidEmail("christykumar13@gmailcom");
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
}
