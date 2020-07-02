/**
 * Project: Assignment1
 * File: CustomerReport.java
 * Date: May 6, 2017
 * Time: 12:44:48 PM
 */

package a00904649.io;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.ApplicationException;
import a00904649.BcmcOption;
import a00904649.data.Customer;
import a00904649.data.util.Common;
import a00904649.data.util.CompareByJoinedDate;
import a00904649.data.util.CompareByJoinedDateDescending;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CustomerReport {

	private static final Logger LOG = LogManager.getLogger();
	public static final String HORIZONTAL_LINE = "----------------------------------------------------------------------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%3s. %-6s %-12s %-12s %-25s %-12s %-12s %-15s %-25s%s%n";
	public static final String CUSTOMER_FORMAT = "%3d. %06d %-12s %-12s %-25s %-12s %-12s %-15s %-25s%s%n";
	public static final String FILEOUT = "customers_report.txt";

	/**
	 * private constructor to prevent instantiation
	 */
	private CustomerReport() {
	}

	/**
	 * Print the customer report.
	 * Option: -J or by_join_date = sort it by joined date. -d or desc = by joined date in descending order.
	 * 
	 * @param customers
	 *            list of customers
	 */
	public static void writeCustomerReport(List<Customer> customers) {
		if (BcmcOption.isDescendingOption()) {
			Collections.sort(customers, new CompareByJoinedDateDescending());
			LOG.debug("Customer data sorted by joined date descending order");
		} else if (BcmcOption.IsJoinDateOption()) {
			Collections.sort(customers, new CompareByJoinedDate());
			LOG.debug("Customer data sorted by joined date ascending order");
		}
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
		LOG.info("Customer report created and displayed");
	}

	/**
	 * Create customer_report.txt.
	 * Option: -J or by_join_date = sort it by joined date. -d or desc = by joined date in descending order.
	 * 
	 * @param customers
	 *            list of customers
	 * @throws ApplicationException
	 */
	public static void createCustomerReport(List<Customer> customers) throws ApplicationException {
		if (BcmcOption.isDescendingOption()) {
			Collections.sort(customers, new CompareByJoinedDateDescending());
		} else if (BcmcOption.IsJoinDateOption()) {
			Collections.sort(customers, new CompareByJoinedDate());
		}
		try {
			PrintWriter outputfile = new PrintWriter(FILEOUT);

			outputfile.format("Customers Report%n");
			outputfile.format(HORIZONTAL_LINE + "%n");
			outputfile.format(HEADER_FORMAT, "#", "ID", "First name", "Last name", "Street", "City", "Postal Code", "Phone", "Email", "Join Date");
			outputfile.format(HORIZONTAL_LINE + "%n");
			int i = 0;
			for (Customer customer : customers) {
				LocalDate date = customer.getJoinedDate();
				outputfile.format(CUSTOMER_FORMAT, ++i, customer.getId(), customer.getFirstName(), customer.getLastName(), customer.getStreet(),
						customer.getCity(), customer.getPostalCode(), customer.getPhone(), customer.getEmailAddress(),
						Common.DATE_FORMAT.format(date));
			}
			outputfile.close();
		} catch (FileNotFoundException e) {
			throw new ApplicationException(String.format("Error creating %s", FILEOUT));
		}
		LOG.info(FILEOUT + " created");
	}

}
