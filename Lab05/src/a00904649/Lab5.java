/**
 * Project: Lab05
 * File: Lab5.java
 * Date: May 11, 2017
 * Time: 7:05:00 PM
 */

package a00904649;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.Collections;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a00904649.data.Customer;
import a00904649.data.util.CompareByJoinedDate;
import a00904649.io.CustomerReader;
import a00904649.io.CustomerReport;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Lab5 {

	private String customerData;
	private static final Instant startTime = Instant.now();
	public static final String LOG4J_CONFIG_FILENAME = "Log4j2.xml";
	static {
		configureLogging();
	}
	private static final Logger LOG = LogManager.getLogger(Lab5.class);

	/**
	 * Entry point for Lab 5
	 * 
	 * @param args
	 *            the customer input data passed as customers.txt file and saves the report as customers_report.txt file
	 */
	public static void main(String[] args) {
		LOG.info(startTime);
		if (args.length != 0) {
			new Lab5(args[0]).runData();
		} else {
			new Lab5().runFile();
		}
		printEndTimeAndDuration();
	}

	public Lab5() {
	}

	public Lab5(String customerData) {
		this.customerData = customerData;
	}

	private void runFile() {
		try {
			List<Customer> customers = CustomerReader.readFile();
			Collections.sort(customers, new CompareByJoinedDate());
			CustomerReport.write(customers);
			CustomerReport.createReport(customers);
		} catch (ApplicationException | IOException e) {
			LOG.error(e.getMessage());
		}
	}

	private void runData() {
		try {
			List<Customer> customers = CustomerReader.read(customerData);
			Collections.sort(customers, new CompareByJoinedDate());
			CustomerReport.write(customers);
			CustomerReport.createReport(customers);
		} catch (ApplicationException | IOException e) {
			LOG.error(e.getMessage());
		}
	}

	public static void printEndTimeAndDuration() {
		Instant endTime = Instant.now();
		LOG.info(endTime);
		LOG.info(String.format("Duration: %d ms", Duration.between(startTime, endTime).toMillis()));
	}

	private static void configureLogging() {
		ConfigurationSource source;
		try {
			source = new ConfigurationSource(new FileInputStream(LOG4J_CONFIG_FILENAME));
			Configurator.initialize(null, source);
		} catch (IOException e) {
			System.out.println(String.format("Can't find the log4j logging configuration file %s.", LOG4J_CONFIG_FILENAME));
		}
	}

}
