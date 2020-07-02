/**
 * Project: Lab03
 * File: CustomerReader.java
 * Date: Apr 26, 2017
 * Time: 10:22:15 PM
 */

package a00904649.io;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Calendar;

import a00904649.ApplicationException;
import a00904649.data.Customer;
import a00904649.data.Date;
import a00904649.data.util.Validator;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CustomerReader {

	public static final String RECORD_DELIMITER = ":";
	public static final String FIELD_DELIMITER = "\\|";
	public static final int EXPECTED_INFO = 9;
	public static final int CURRENT_YEAR = Calendar.getInstance().get(Calendar.YEAR);
	public static final int YEAR_INDEX = 4;
	public static final int MONTH_INDEX = 6;
	public static final int MONTH = 12;
	public static final int DAY = 31;
	public static final int MIN_YEAR = 1900;
	public static final int DATE_LENGTH = 8;

	/**
	 * private constructor to prevent instantiation
	 */
	private CustomerReader() {
	}

	/**
	 * Read the customer input data.
	 * 
	 * @param data
	 *            The input data.
	 * @return An array of customers.
	 * @throws ApplicationException
	 */
	@SuppressWarnings("deprecation")
	public static Customer[] read(String data) throws ApplicationException {
		String[] customerTemp = data.split(RECORD_DELIMITER);
		Customer[] customers = new Customer[customerTemp.length];
		int i = 0;
		int customerID;
		String firstName;
		String lastName;
		String street;
		String city;
		String postalCode;
		String phone;
		String email;
		String joinDate;

		for (String str : customerTemp) {
			String[] info = str.split(FIELD_DELIMITER);
			if (info.length != EXPECTED_INFO) {
				throw new ApplicationException("Expected 9 elements but got " + info.length + ": " + Arrays.toString(info));
			}
			int index = 0;
			customerID = Integer.parseInt(info[index++]);
			firstName = info[index++];
			lastName = info[index++];
			street = info[index++];
			city = info[index++];
			postalCode = info[index++];
			phone = info[index++];
			email = info[index++];

			if (!Validator.validateEmail(email)) {
				throw new ApplicationException(email + " is an invalid email address");
			}

			joinDate = info[index++];
			if (joinDate.length() < DATE_LENGTH) {
				throw new ApplicationException("Invalid value for Date (valid yyyymmdd): " + joinDate);
			}
			int year = Integer.parseInt(joinDate.substring(0, YEAR_INDEX));
			if (year < MIN_YEAR || year > CURRENT_YEAR) {
				throw new ApplicationException("Invalid value for year (valid 1900-Current Year): " + year);
			}
			int month = Integer.parseInt(joinDate.substring(YEAR_INDEX, MONTH_INDEX));
			if (month <= 0 || month > MONTH) {
				throw new ApplicationException("Invalid value for MonthOfYear (valid 1-12): " + month);
			}
			int dayOfMonth = Integer.parseInt(joinDate.substring(MONTH_INDEX));
			if (dayOfMonth < 0 || dayOfMonth > DAY) {
				throw new ApplicationException("Invalid value for DayOfMonth (valid values 1 - 28/31): " + dayOfMonth);
			}
			// Date class was used to demonstrate use of @Deprecated and @SuppressWarning
			Date date = new Date(year, month, dayOfMonth);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
			joinDate = LocalDate.of(date.getYear(), date.getMonth(), date.getDate()).format(formatter);

			Customer customer = new Customer.Builder(customerID, phone).setFirstName(firstName).setLastName(lastName).setStreet(street).setCity(city)
					.setPostalCode(postalCode).setEmail(email).setJoinDate(joinDate).build();

			customers[i++] = customer;
		}
		return customers;
	}
}