/**
 * Project: Assignment2
 * File: ApplicationException.java
 * Date: May 13, 2017
 * Time: 3:20:45 PM
 */

package a00904649;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
@SuppressWarnings("serial")
public class ApplicationException extends Exception {
	public ApplicationException() {
		super();
	}

	public ApplicationException(String message) {
		super(message);
	}

	public ApplicationException(Throwable cause) {
		super(cause);
	}

	public ApplicationException(String message, Throwable cause) {
		super(message, cause);
	}

	protected ApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
