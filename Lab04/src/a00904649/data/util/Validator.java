/**
 * Project: Lab04
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
	private static final String YYYYMMDD_PATTERN = "(20\\d{2})(\\d{2})(\\d{2})"; // valid for years 2000-2099

	private Validator() {
	}

	/**
	 * Validate an email string.
	 * 
	 * @param email
	 *            the email string.
	 * @return true if the email address is valid, false otherwise.
	 */
	public static boolean validateEmail(final String email) {
		return email.matches(EMAIL_PATTERN);
	}

	/**
	 * Validate a dateString in the format of yyyymmdd. Note this method only checks that the year is in the range from 2000 to 2099 and the month and
	 * day are digits. It does not do proper date validation.
	 * 
	 * @param yyyymmdd
	 *            the date string
	 * @return true if the date is somewhat valid, false otherwise.
	 */
	public static boolean validateJoinedDate(String yyyymmdd) {
		return yyyymmdd.matches(YYYYMMDD_PATTERN);
	}
}
