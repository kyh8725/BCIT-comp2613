/**
 * Project: Lab03
 * File: Lab3.java
 * Date: Apr 28, 2017
 * Time: 10:16:19 PM
 */

package a00904649;

import java.time.Duration;
import java.time.Instant;

import a00904649.data.Customer;
import a00904649.io.CustomerReader;
import a00904649.io.CustomerReport;

/**
 * A Commandline program which reads customer data, creates Customer objects, adds them to an array, and prints a simple Customer report.
 * 
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Lab3 {

	private String customerData;
	private Customer[] customers;

	public Lab3(String customerData) {
		this.customerData = customerData;
	}

	private void run() {
		Instant start = Instant.now();
		System.out.println(start);
		try {
			customers = CustomerReader.read(customerData);
			CustomerReport.write(customers);

		} catch (ApplicationException e) {
			System.out.println(e.getMessage());

		} finally {
			Instant end = Instant.now();
			System.out.println(end);
			System.out.println("Duration: " + Duration.between(start, end).toMillis() + " ms");
		}
	}

	/**
	 * Entry point for Lab3
	 * 
	 * @param args
	 *            an input string containing all the customer details.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Input data is missing. Expecting customer data.");
			System.exit(-1);
		}

		new Lab3(args[0]).run();
	}
}
