package in.bloomapptest.adminservice;

import static org.junit.Assert.*;

import org.junit.Test;

import in.bloomapp.adminservice.AdminLogin;

public class AdminLoginTest {

	@Test
	public void testWithValidCredentials() {
		boolean valid= AdminLogin.login("admin", "admin123");
		assertTrue(valid);
	}

	@Test
	public void testWithInvalidUsername() {
		boolean valid= AdminLogin.login("christina", "admin123");
		assertFalse(valid);
	}
	
	@Test
	public void testWithInvalidPassword() {
		boolean valid= AdminLogin.login("christina", "admin123");
		assertFalse(valid);
	}
}
