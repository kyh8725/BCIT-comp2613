/**
 * Project: Lab02
 * File: CustomerReader.java
 * Date: Apr 26, 2017
 * Time: 10:22:15 PM
 */

package a00904649.io;

import a00904649.data.Customer;
import a00904649.data.util.Validator;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CustomerReader {

	public static final String RECORD_DELIMITER = ":";
	public static final String FIELD_DELIMITER = "\\|";

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
	 */
	public static Customer[] read(String data) {
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

		for (String str : customerTemp) {
			String[] info = str.split(FIELD_DELIMITER);
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
				email = "N/A";
			}

			Customer customer = new Customer.Builder(customerID, phone).setFirstName(firstName).setLastName(lastName).setStreet(street).setCity(city)
					.setPostalCode(postalCode).setEmail(email).build();
			customers[i++] = customer;

		}
		return customers;
	}
}