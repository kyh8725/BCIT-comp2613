/**
 * Project: Lab03
 * File: ApplicationException.java
 * Date: Apr 28, 2017
 * Time: 10:20:08 PM
 */

package a00904649;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */

@SuppressWarnings("serial")
public class ApplicationException extends Exception {

	public ApplicationException() {
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
