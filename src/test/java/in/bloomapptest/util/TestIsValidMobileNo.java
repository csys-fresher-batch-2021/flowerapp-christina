package in.bloomapptest.util;

import static org.junit.Assert.*;
import org.junit.Test;

import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.util.BasicValidator;

public class TestIsValidMobileNo {

	@Test
	public void testValidMobileNo() {
		try {
			BasicValidator.isValidMobileNo(8072843568l);
		} catch (InvalidInputException e) {
			fail();
		}
	}

	@Test
	public void testValidMobileNo1() {
		try {
			BasicValidator.isValidMobileNo(9072843568l);
		} catch (InvalidInputException e) {
			fail();
		}
	}
	@Test
	public void testValidMobileNo2() {
		try {
			BasicValidator.isValidMobileNo(7072843568l);
		} catch (InvalidInputException e) {
			fail();
		}
	}
	
	@Test
	public void testValidMobileNo3() {
		try {
			BasicValidator.isValidMobileNo(6072843568l);
		} catch (InvalidInputException e) {
			fail();
		}
	}
	
	@Test
	public void testInvalidMobileNo() {
		try {
			BasicValidator.isValidMobileNo(5072843568l);
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid Mobile number",message);
		}
	}
	
	@Test
	public void testInvalidMobileNo2() {
		try {
			BasicValidator.isValidMobileNo(907284l);
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid Mobile number",message);
		}
	}
	
	@Test
	public void testInvalidMobileNo3() {
		try {
			BasicValidator.isValidMobileNo(907284678l);
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid Mobile number",message);
		}
	}
	
	@Test
	public void testInvalidMobileNo4() {
		try {
			BasicValidator.isValidMobileNo(-907284678l);
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid Mobile number",message);
		}
	}
	
	@Test
	public void testInvalidMobileNo5() {
		try {
			BasicValidator.isValidMobileNo(0000000000l);
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid Mobile number",message);
		}
	}
}
