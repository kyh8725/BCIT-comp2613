/**
 * Project: Lab02
 * File: Validator.java
 * Date: Apr 22, 2017
 * Time: 4:05:21 PM
 */

package a00904649.data.util;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Validator {

	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Validator constructor
	 */
	private Validator() {
	}

	/**
	 * Checks if String email is a valid email address
	 * 
	 * @param email
	 *            - String of email to be validated
	 * @return true if email is a valid email address false otherwise.
	 */
	public static boolean validateEmail(final String email) {
		return email.matches(EMAIL_PATTERN);
	}
}
