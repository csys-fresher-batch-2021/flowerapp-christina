package in.bloomapp.util;

import in.bloomapp.exception.InvalidStringEXception;

public class IsValid {
	
	private IsValid(){
		//Default constructor
	}
	/**
	 * Checks weather the string is a valid string or not
	 * @param checkString
	 * @return
	 * @throws InvalidStringEXception 
	 */
	public static boolean isValidString(String checkString) throws InvalidStringEXception {
	boolean validity=false;
	if (checkString.trim().equals("")) {
		throw new InvalidStringEXception("Invalid String");
	}
	else {
		
		validity=true;
		return validity;
	}
	
	}
	
	
	/**
	 * Checks if the the string contains only valid characters
	 * @param checkString
	 * @return
	 * @throws InvalidStringEXception 
	 */
	public static boolean isCharAllowed(String checkString) throws InvalidStringEXception {
		boolean isValid = false;
		int i = 0;
		while ((i <= checkString.length() - 1) && (checkString.length() >= 3)) {
			if ((checkString.charAt(i) >= 'A' && checkString.charAt(i) <= 'Z')
					|| (checkString.charAt(i) >= 'a' && checkString.charAt(i) <= 'z') ||
					(checkString.charAt(i) >= '0' && checkString.charAt(i) <= '9')
					||checkString.charAt(i) == ' ') {
				isValid = true;	
				
			}
			else {
				 throw new InvalidStringEXception("Invalid string");
			}
			i++;
		}
		return isValid;
	}
}
