/**
 * Project: Lab05
 * File: CustomerReader.java
 * Date: Apr 26, 2017
 * Time: 10:22:15 PM
 */

package a00904649.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import a00904649.ApplicationException;
import a00904649.data.Customer;
import a00904649.data.util.Validator;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CustomerReader {

	public static final String RECORD_DELIMITER = ":";
	public static final String FIELD_DELIMITER = "\\|";
	public static final String FILE_NAME = "customers.txt";

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
	 *             throws an exception if the input contains invalid data
	 */
	public static List<Customer> read(String data) throws ApplicationException {

		String[] rows = data.split(RECORD_DELIMITER);
		List<Customer> customers = new ArrayList<>();

		for (String row : rows) {
			Customer customer = readCustomerString(row);
			customers.add(customer);
		}
		return customers;
	}

	/**
	 * 
	 * Read the customer input data from a .txt file.
	 * 
	 * @return An array of customers
	 * @throws ApplicationException
	 * @throws IOException
	 */
	public static List<Customer> readFile() throws ApplicationException, IOException {

		BufferedReader input = null;
		String[] customer = new String[Customer.CUSTOMER_SIZE];
		List<Customer> customerList = new ArrayList<>();
		try {
			input = new BufferedReader(new FileReader(FILE_NAME));
			@SuppressWarnings("unused")
			// to store the first line of the unused data.
			String firstLine = input.readLine();

			while (input.ready()) {
				int i = 0;
				customer[i] = input.readLine();
				Customer customers = readCustomerString(customer[i]);
				customerList.add(customers);
				i++;
			}

		} catch (FileNotFoundException e) {
			throw new ApplicationException(String.format("%s does not exist", FILE_NAME));
		}

		input.close();

		return customerList;
	}

	/**
	 * Parse a Customer data string into a Customer object;
	 * 
	 * @param row
	 *            a customer record string
	 * @throws ApplicationException
	 *             throws an exception if the input contains invalid data
	 * @throws IOException
	 */
	private static Customer readCustomerString(String row) throws ApplicationException {

		String[] elements = row.split(FIELD_DELIMITER);
		if (elements.length != Customer.ATTRIBUTE_COUNT) {
			throw new ApplicationException(
					String.format("Expected %d but got %d: %s", Customer.ATTRIBUTE_COUNT, elements.length, Arrays.toString(elements)));
		}

		int index = 0;
		long id = Integer.parseInt(elements[index++]);
		String firstName = elements[index++];
		String lastName = elements[index++];
		String street = elements[index++];
		String city = elements[index++];
		String postalCode = elements[index++];
		String phone = elements[index++];
		String emailAddress = elements[index++];
		if (!Validator.validateEmail(emailAddress)) {
			throw new ApplicationException(String.format("Invalid email: %s", emailAddress));
		}
		LocalDate joinDate = null;
		String yyyymmdd = elements[index++];
		if (!Validator.validateJoinedDate(yyyymmdd)) {
			throw new ApplicationException(String.format("Invalid joined date: %s for customer %d", yyyymmdd, id));
		}
		try {
			joinDate = LocalDate.parse(yyyymmdd, DateTimeFormatter.ofPattern("yyyyMMdd"));
		} catch (DateTimeParseException e) {
			throw new ApplicationException(String.format("Invalid joined date: %s for customer %d", yyyymmdd, id));
		}

		Customer customer = null;

		try {
			customer = new Customer.Builder(id, phone) //
					.setFirstName(firstName) //
					.setLastName(lastName) //
					.setStreet(street) //
					.setCity(city) //
					.setPostalCode(postalCode) //
					.setEmailAddress(emailAddress) //
					.setJoinedDate(joinDate).build();
		} catch (DateTimeException e) {
			throw new ApplicationException(e.getMessage());
		}
		return customer;
	}

}