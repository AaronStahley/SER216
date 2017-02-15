package hw_02;
/**
 * 
 * @author aaron stahley
 * @version 1.0 jan 26, 2017.
 *
 */
public class BinaryNumberFormatException extends NumberFormatException{
	
	/**
	 * Displays custom error message if exception is thrown
	 * 
	 * @param collection
	 * 
	 */
	public BinaryNumberFormatException(String collection){
		super("The character " + collection + " is an invalid binary digit");
	}

}
