package in.bloomapptest.validator;

import static org.junit.Assert.*;
import org.junit.Test;
import in.bloomapp.exception.DBException;
import in.bloomapp.validator.UserValidator;

public class TestUserIsExist {

	@Test
	public void testWIthRegisteredUser() {
		String userName="christina"; 
		String password="Chris@13c";
		try {
		 UserValidator.userIsExist(userName,password);
	}
		catch(DBException e) {
			
			fail();
		}
	}
	@Test
	public void testWithUnregisteredUser() {
		String userName="christi"; 
		String password="Chris3c";
		try {
		 UserValidator.userIsExist(userName,password);
	}
		catch(DBException e) {
			
			assertFalse(false);
		}
	}
	
}
