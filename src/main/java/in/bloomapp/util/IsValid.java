package in.bloomapp.util;


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
	if (!checkString.trim().equals("")) {
		

		validity=true;
		
	}
	else {
		
		validity=false;
		
	}
	return validity;
	}
	
	/**
	 * Checks if the the string contains only valid characters
	 * @param checkString
	 * @return
	 */
	public static boolean isCharAllowed(String checkString) {
		boolean isValid = false;
		int i = 0;
		while ((i <= checkString.length() - 1) && (checkString.length() >= 3)) {
			if ((checkString.charAt(i) >= 'A' && checkString.charAt(i) <= 'Z')
					|| (checkString.charAt(i) >= 'a' && checkString.charAt(i) <= 'z') || checkString.charAt(i) == ' ') {
				isValid = true;
			}
			i++;
		}
		return isValid;
	}

}
