/**
 * Project: Lab04
 * File: Lab4.java
 * Date: May 3, 2017
 * Time: 9:02:44 PM
 */

package a00904649;

import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import a00904649.data.Customer;
import a00904649.data.util.CompareByJoinedDate;
import a00904649.io.CustomerReader;
import a00904649.io.CustomerReport;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Lab4 {

	private String customerData;
	private static final Instant startTime = Instant.now();

	/**
	 * Entry point for Lab 3
	 * 
	 * @param args
	 *            the customer input data, passed as a quoted string in the first argument.
	 */
	public static void main(String[] args) {
		System.out.println(startTime);
		if (args.length == 0) {
			System.out.println("Input data is missing. Expecting customer data.");
			printEndTimeAndDuration();
			System.exit(-1);
		}

		new Lab4(args[0]).run();

		printEndTimeAndDuration();
	}

	/**
	 * Lab3 constructor.
	 * 
	 * @param customerData
	 *            the customer data
	 */
	public Lab4(String customerData) {
		this.customerData = customerData;
	}

	/**
	 * Load the customers and print them out.
	 */
	private void run() {
		try {
			List<Customer> customers = CustomerReader.read(customerData);
			Collections.sort(customers, new CompareByJoinedDate());
			CustomerReport.write(customers);
		} catch (ApplicationException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void printEndTimeAndDuration() {
		Instant endTime = Instant.now();
		System.out.println(endTime);
		System.out.println(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
	}
}
