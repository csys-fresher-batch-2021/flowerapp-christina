package in.bloomapp.util;

import java.util.regex.Pattern;

public class IsValid {
	/**
	 * Checks weather the string is a valid string or not
	 * @param checkString
	 * @return
	 */
	public static boolean isValidString(String checkString) {
	boolean validity=false;
	if (checkString.trim().length() <= 1 && Pattern.matches("[a-zA-Z0-9]", checkString)) {
		
		throw new RuntimeException("Invalid input");
		
	}
	else {
		
		validity=true;
		
	}
	return validity;
	}

}
