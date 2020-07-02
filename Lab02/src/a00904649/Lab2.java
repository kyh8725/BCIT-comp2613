/**
 * Project: Lab02
 * File: Lab2.java
 * Date: Apr 22, 2017
 * Time: 4:04:31 PM
 */

package a00904649;

import a00904649.data.Customer;
import a00904649.io.CustomerReader;
import a00904649.io.CustomerReport;

/**
 * A Commandline program which reads customer data, creates Customer objects, adds them to an array, and prints a simple Customer report.
 * 
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Lab2 {

	private String customerData;
	private Customer[] customers;

	public Lab2(String customerData) {
		this.customerData = customerData;
	}

	private void run() {
		customers = CustomerReader.read(customerData);
		CustomerReport.write(customers);
	}

	/**
	 * Entry point for Lab2
	 * 
	 * @param args
	 *            an input string containing all the customer details.
	 */
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("Input data is missing. Expecting customer data.");
			System.exit(-1);
		}

		new Lab2(args[0]).run();
	}
}
