/**
 * Project: Assignment2
 * File: CustomerReader.java
 * Date: May 13, 2017
 * Time: 3:19:47 PM
 */

package a00904649.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.ApplicationException;
import a00904649.data.Customer;
import a00904649.data.util.Validator;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CustomerReader {
	private static final Logger LOG = LogManager.getLogger();
	public static final String FIELD_DELIMITER = "\\|";
	public static final String FILE_NAME = "customers.dat";

	/**
	 * private constructor to prevent instantiation
	 */
	private CustomerReader() {

	}

	/**
	 * Read the customer input data from customers.dat.
	 * 
	 * @return customerList
	 *         a list of customers
	 * @throws ApplicationException
	 */
	public static List<Customer> readCustomerFile() throws ApplicationException {

		BufferedReader input = null;
		String[] customer = new String[Customer.CUSTOMER_SIZE];
		List<Customer> customerList = new ArrayList<>();
		try {
			input = new BufferedReader(new FileReader(FILE_NAME));
			LOG.debug("Reading customer data from " + FILE_NAME);
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
			LOG.debug("Customers were added to ArrayList");
			input.close();
		} catch (IOException e) {
			throw new ApplicationException(String.format("%s does not exist", FILE_NAME));
		}
		return customerList;
	}

	/**
	 * Parse a Customer data string into a Customer object;
	 * 
	 * @param row
	 *            a String of customer data.
	 * @return customer
	 * @throws ApplicationException
	 *             throws an exception if the input contains invalid data
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
			throw new ApplicationException("Error creating date");
		}
		LOG.debug("Customers with ID " + customer.getId() + " created");
		return customer;
	}
}
