package mx.com.anzen.genericbank.exceptions;




public class NameNotFoundException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * the default constructor
	 * @param message the messge to set
	 */
	public  NameNotFoundException (String message){
		super(message);
	}
}
