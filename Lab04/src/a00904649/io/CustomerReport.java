/**
 * Project: Lab04
 * File: CustomerReport.java
 * Date: Apr 26, 2017
 * Time: 5:52:43 PM
 */

package a00904649.io;

import java.time.LocalDate;
import java.util.List;

import a00904649.data.Customer;
import a00904649.data.util.Common;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CustomerReport {

	public static final String HORIZONTAL_LINE = "----------------------------------------------------------------------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%3s. %-6s %-12s %-12s %-25s %-12s %-12s %-15s %-25s%s%n";
	public static final String CUSTOMER_FORMAT = "%3d. %06d %-12s %-12s %-25s %-12s %-12s %-15s %-25s%s%n";

	/**
	 * private constructor to prevent instantiation
	 */
	private CustomerReport() {
	}

	/**
	 * Print the report.
	 * 
	 * @param customers
	 *            the customer array.
	 */
	public static void write(List<Customer> customers) {
		System.out.println("Customers Report");
		System.out.println(HORIZONTAL_LINE);
		System.out.format(HEADER_FORMAT, "#", "ID", "First name", "Last name", "Street", "City", "Postal Code", "Phone", "Email", "Join Date");
		System.out.println(HORIZONTAL_LINE);

		int i = 0;
		for (Customer customer : customers) {
			LocalDate date = customer.getJoinedDate();
			System.out.format(CUSTOMER_FORMAT, ++i, customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getStreet(),
					customer.getCity(), customer.getPostalCode(), customer.getPhone(), customer.getEmailAddress(), Common.DATE_FORMAT.format(date));
		}
	}
}
