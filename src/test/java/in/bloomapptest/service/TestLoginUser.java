package in.bloomapptest.service;

import static org.junit.Assert.*;
import org.junit.Test;
import in.bloomapp.exception.DBException;
import in.bloomapp.userservice.UserManager;

public class TestLoginUser {

	@Test
	public void testRegisteredUser() {
		try {
			boolean success=UserManager.loginUser("christina","Chris@13c");
			assertTrue(success);
		} catch (DBException e) {

			fail();
		}
		
	}
	
	@Test
	public void testUnregisteredUser() {
		try {
			boolean success=UserManager.loginUser("christy","Chris@13c");
			assertFalse(success);
		} catch (DBException e) {

			fail();
		}
		
	}

}
