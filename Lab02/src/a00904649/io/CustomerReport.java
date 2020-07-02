/**
 * Project: Lab02
 * File: CustomerReport.java
 * Date: Apr 26, 2017
 * Time: 5:52:43 PM
 */

package a00904649.io;

import java.time.Duration;
import java.time.Instant;

import a00904649.data.Customer;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CustomerReport {

	public static final String HORIZONTAL_LINE = "----------------------------------------------------------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%3s. %-6s %-12s %-12s %-25s %-12s %-12s %-15s %-20s%n";
	public static final String CUSTOMER_FORMAT = "%3d. %06d %-12s %-12s %-25s %-12s %-12s %-15s %-20s%n";

	/**
	 * private constructor to prevent instantiation
	 */
	private CustomerReport() {
	}

	/**
	 * Write the report.
	 * 
	 * @param customers
	 *            the customers
	 */
	public static void write(Customer[] customers) {
		Instant start = Instant.now();
		System.out.println(start);
		System.out.println("Customer Report");
		System.out.println(HORIZONTAL_LINE);
		System.out.format(HEADER_FORMAT, "#", "ID", "First name", "Last name", "Street", "City", "Postal Code", "Phone", "Email");
		System.out.println(HORIZONTAL_LINE);
		int i = 0;
		for (Customer customer : customers) {
			System.out.format(CUSTOMER_FORMAT, ++i, customer.getCustomerID(), customer.getFirstName(), customer.getLastName(), customer.getStreet(),
					customer.getCity(), customer.getPostalCode(), customer.getPhone(), customer.getEmail());
		}
		Instant end = Instant.now();
		System.out.println(end);
		System.out.println("Duration: " + Duration.between(start, end).toMillis() + " ms");
	}
}
