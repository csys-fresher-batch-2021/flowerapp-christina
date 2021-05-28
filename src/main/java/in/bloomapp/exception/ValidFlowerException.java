package in.bloomapp.exception;

public class ValidFlowerException extends Exception {
	private static final long serialVersionUID = 1L;
	/**
	 * this exception is thrown when the flower dose'nt meet the Validator constrains
	 * @param message
	 */
	public ValidFlowerException(String message) {
		super(message);
	}

	/**
	 *  this exception is thrown when the flower dose'nt meet the Validator constrains and can also add a exception 
	 *  message in parameter
	 * @param e
	 * @param message
	 */
	public ValidFlowerException(Exception e,String message) {
		super(message, e);
	}
}
