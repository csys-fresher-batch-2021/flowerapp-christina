package in.bloomapp.util;

import java.util.regex.Pattern;

public class IsValid {
	
	private IsValid(){
		//Default constructor
	}
	/**
	 * Checks weather the string is a valid string or not
	 * @param checkString
	 * @return
	 */
	public static boolean isValidString(String checkString) {
	boolean validity=false;
	if (!checkString.trim().equals("") || Pattern.matches("[a-zA-Z0-9]", checkString)) {
		

		validity=true;
		
	}
	else {
		
		validity=false;
		
	}
	return validity;
	}

}
