package techolution;

/**
 * This class identifies exception where events incorrectly defined.
 * @author Godfree Dzebu
 * @version 1.0
 */
public class InvalidEventDefinitionException extends Exception {
 
	/**
	 * return version UID for the exception.
	 */
	private static final long serialVersionUID = 6519362213567845471L;
	

	/**
	 * The constructor for the InvalidEventDefinitionException exception object.
	 * @param sException String to identify the exception
	 */
	public InvalidEventDefinitionException(String sException) {
		super(sException);
	}
}
