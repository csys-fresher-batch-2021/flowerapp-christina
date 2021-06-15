package in.bloomapptest.util;

import static org.junit.Assert.*;
import org.junit.Test;

import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.util.IsValid;

public class TestIsValidMobileNo {

	@Test
	public void testValidMobileNo() {
		try {
			IsValid.isValidMobileNo(8072843568l);
		} catch (InvalidInputException e) {
			fail();
		}
	}

	@Test
	public void testValidMobileNo1() {
		try {
			IsValid.isValidMobileNo(9072843568l);
		} catch (InvalidInputException e) {
			fail();
		}
	}
	@Test
	public void testValidMobileNo2() {
		try {
			IsValid.isValidMobileNo(7072843568l);
		} catch (InvalidInputException e) {
			fail();
		}
	}
	
	@Test
	public void testValidMobileNo3() {
		try {
			IsValid.isValidMobileNo(6072843568l);
		} catch (InvalidInputException e) {
			fail();
		}
	}
	
	@Test
	public void testInvalidMobileNo() {
		try {
			IsValid.isValidMobileNo(5072843568l);
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid Mobile number",message);
		}
	}
	
	@Test
	public void testInvalidMobileNo2() {
		try {
			IsValid.isValidMobileNo(907284l);
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid Mobile number",message);
		}
	}
	
	@Test
	public void testInvalidMobileNo3() {
		try {
			IsValid.isValidMobileNo(907284678l);
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid Mobile number",message);
		}
	}
	
	@Test
	public void testInvalidMobileNo4() {
		try {
			IsValid.isValidMobileNo(-907284678l);
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid Mobile number",message);
		}
	}
	
	@Test
	public void testInvalidMobileNo5() {
		try {
			IsValid.isValidMobileNo(0000000000l);
		} catch (InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid Mobile number",message);
		}
	}
}
