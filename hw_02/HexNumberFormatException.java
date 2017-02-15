package hw_02;
/**
 * 
 * @author aaron stahley
 * @version 1.0 jan 26, 2017.
 *
 */
public class HexNumberFormatException extends NumberFormatException{

	/**
	 * Displays custom error message if exception is thrown
	 * 
	 * @param collection
	 * 
	 */
	public HexNumberFormatException(String collection){
		super("The character " + collection + " is an invalid hexadecimal value");
	}
	
}
