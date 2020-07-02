/**
 * Project: Assignment1
 * File: ServiceReport.java
 * Date: May 13, 2017
 * Time: 3:27:35 PM
 */

package a00904649.io;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.ApplicationException;
import a00904649.data.Customer;
import a00904649.data.Motorcycle;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class ServiceReport {
	private static final Logger LOG = LogManager.getLogger();
	public static final String HORIZONTAL_LINE = "-------------------------------------------------------------------------------";
	public static final String HEADER_FORMAT = "%-12s %-12s %-20s %-15s %-7s %5s%n";
	public static final String INVENTORY_FORMAT = "%-12s %-12s %-20s %-15s %-7s %7s%n";
	public static final int PRICE = 100;
	public static final String FILEOUT = "service_report.txt";

	/**
	 * private constructor to prevent instantiation
	 */
	private ServiceReport() {
	}

	/**
	 * Print the report.
	 * 
	 * @param service
	 *            a list of Motorcycle
	 * @param customer
	 *            a list of Customer
	 * 
	 */
	public static void writeService(List<Motorcycle> service, List<Customer> customer) {
		System.out.println("Service Report");
		System.out.println(HORIZONTAL_LINE);
		System.out.format(HEADER_FORMAT, "First Name", "Last Name", "Make", "Model", "Year", "Mileage");
		System.out.println(HORIZONTAL_LINE);

		for (Customer customers : customer) {
			for (Motorcycle motorcycle : service) {
				if (customers.getId() == motorcycle.getCustomerID()) {
					System.out.format(INVENTORY_FORMAT, customers.getFirstName(), customers.getLastName(), motorcycle.getMake(),
							motorcycle.getModel(), motorcycle.getYear(), motorcycle.getMileage());
				}
			}
		}
		LOG.info("Service report created and displayed");
	}

	/**
	 * create service_report.txt.
	 * 
	 * @param inven
	 * @throws ApplicationException
	 */
	public static void createInventoryReport(List<Motorcycle> motorcycles, List<Customer> customer) throws ApplicationException {
		try {
			PrintWriter outputfile = new PrintWriter(FILEOUT);
			outputfile.format("Service Report%n");
			outputfile.format(HORIZONTAL_LINE + "%n");
			outputfile.format(HEADER_FORMAT, "First Name", "Last Name", "Make", "Model", "Year", "Mileage");
			outputfile.format(HORIZONTAL_LINE + "%n");

			for (Customer customers : customer) {
				for (Motorcycle motorcycle : motorcycles) {
					if (customers.getId() == motorcycle.getCustomerID()) {
						outputfile.format(INVENTORY_FORMAT, customers.getFirstName(), customers.getLastName(), motorcycle.getMake(),
								motorcycle.getModel(), motorcycle.getYear(), motorcycle.getMileage());
					}
				}
			}
			outputfile.close();
		} catch (IOException e) {
			throw new ApplicationException(String.format("Error creating %s", FILEOUT));
		}
		LOG.info(FILEOUT + " created");
	}
}
