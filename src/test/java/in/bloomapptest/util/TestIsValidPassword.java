package in.bloomapptest.util;

import static org.junit.Assert.*;
import org.junit.Test;

import in.bloomapp.exception.InvalidInputException;
import in.bloomapp.util.BasicValidator;

public class TestIsValidPassword {

	@Test
	public void testWithValidPassword1() {
		try {
			BasicValidator.isValidPassword("Chris@13s");
			
		}
		catch(InvalidInputException e) {
			fail();
		}
	}
	@Test
	public void testWithValidPassword2() {
		try {
			BasicValidator.isValidPassword("Chris@13");
			
		}
		catch(InvalidInputException e) {
			fail();
			}
	}
	
	@Test
	public void testWithoutSplCharecters() {
		try {
			BasicValidator.isValidPassword("Chris13");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}

	@Test
	public void testWithLettersOnly() {
		try {
			BasicValidator.isValidPassword("christina");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void testWithLettersOnly2() {
		try {
			BasicValidator.isValidPassword("Christina");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void testWithoutNumberAndUpperCase() {
		try {
			BasicValidator.isValidPassword("christina@");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void testWithoutNumber() {
		try {
			BasicValidator.isValidPassword("Christina@");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	
	@Test
	public void testWithoutSplCharecterAndUpperCase() {
		try {
			BasicValidator.isValidPassword("christina12");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void testOnlyWithNumber() {
		try {
			BasicValidator.isValidPassword("23654576");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
	
	@Test
	public void testOnlyWithSplCharecter() {
		try {
			BasicValidator.isValidPassword("#$%^&*");
			
		}
		catch(InvalidInputException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid email",message);
		}
	}
}
