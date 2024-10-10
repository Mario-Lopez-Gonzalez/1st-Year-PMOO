package packproduct;

/**
 * Class to detect errors when trying to work with negative integers
 * 
 * @author Mario
 *
 */
public class NegativeNumberException extends Exception {

	/**
	 * Empty constructor for the NegativeNumberException class
	 */
	public NegativeNumberException() {
		this("");
	}

	/**
	 * Constructor for the NegativeNumberException class
	 * 
	 * @param msg message to be shown
	 */
	public NegativeNumberException(String msg) {
		super(msg);
	}

}
