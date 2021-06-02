package in.bloomapptest.service;

import static org.junit.Assert.*;
import org.junit.Test;

import in.bloomapp.exception.DBException;
import in.bloomapp.exception.UserServiceException;
import in.bloomapp.userservice.UserManager;

public class TestAddUser {

	@Test
	public void test() {
		try {
			UserManager.addUser("jesintha","Jessy@n8","jessykumar13@gmail.com","9043765632","Keelapanangadi,madurai");
		} catch (UserServiceException | DBException e) {
			fail();
		} 
	}
	
	@Test
	public void test1() {
		try {
			UserManager.addUser("      ","Jessy@8","jessykumar13@gmail.com","9043765632","Keelapanangadi,madurai");
		} catch (UserServiceException | DBException e) {
			String message=e.getMessage();
			assertEquals("Invalid String",message);
		} 
	}
	
	@Test
	public void test2() {
		try {
			UserManager.addUser("christy","Jessy@786","jessykumar13@gmail.com","904375632","Keelapanangadi,madurai");
		} catch (UserServiceException | DBException e) {
			String message=e.getMessage();
			assertEquals("Please enter valid Mobile number",message);
		} 
	}

}
