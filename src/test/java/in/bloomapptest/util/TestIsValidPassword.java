package in.bloomapptest.util;

import static org.junit.Assert.*;
import org.junit.Test;

import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.util.IsValid;

public class TestIsValidPassword {

	@Test
	public void testWithValidPassword1() {
		try {
			IsValid.isValidPassword("Chris@13s");
			
		}
		catch(InvalidInputException e) {
			fail();
		}
	}
	@Test
	public void testWithValidPassword2() {
		try {
			IsValid.isValidPassword("Chris@13");
			
		}
		catch(InvalidInputException e) {
			fail();
			}
	}
	
	@Test
	public void testWithoutSplCharecters() {
		try {
			IsValid.isValidPassword("Chris13");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}

	@Test
	public void testWithLettersOnly() {
		try {
			IsValid.isValidPassword("christina");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void testWithLettersOnly2() {
		try {
			IsValid.isValidPassword("Christina");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void testWithoutNumberAndUpperCase() {
		try {
			IsValid.isValidPassword("christina@");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void testWithoutNumber() {
		try {
			IsValid.isValidPassword("Christina@");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	
	@Test
	public void testWithoutSplCharecterAndUpperCase() {
		try {
			IsValid.isValidPassword("christina12");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void testOnlyWithNumber() {
		try {
			IsValid.isValidPassword("23654576");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void testOnlyWithSplCharecter() {
		try {
			IsValid.isValidPassword("#$%^&*");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
}
