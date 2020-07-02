/**
 * Project: Assignment1
 * File: Bcmc.java
 * Date: May 4, 2017
 * Time: 8:10:35 PM
 */

package a00904649;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;

import org.apache.commons.cli.ParseException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a00904649.data.Customer;
import a00904649.data.Inventory;
import a00904649.data.Motorcycle;
import a00904649.io.CustomerReader;
import a00904649.io.CustomerReport;
import a00904649.io.InventoryReader;
import a00904649.io.InventoryReport;
import a00904649.io.ServiceReader;
import a00904649.io.ServiceReport;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Bcmc {
	private static final Instant startTime = Instant.now();
	public static final String LOG4J_CONFIG_FILENAME = "Log4j2.xml";
	static {
		configureLogging();
	}
	private static final Logger LOG = LogManager.getLogger(Bcmc.class);

	private Bcmc() {
		LOG.info("Bcmc created");
	}

	public static void main(String[] args) throws ApplicationException, ParseException {
		LOG.info(startTime);
		Bcmc bcmc = new Bcmc();
		BcmcOption.process(args);
		BcmcOption.optionHelp();
		bcmc.runCustomerOption();
		bcmc.runInventoryOption();
		bcmc.runServiceOption();
		printEndTimeAndDuration();
	}

	private void runCustomerOption() {
		List<Customer> customers;
		if (BcmcOption.isCustomersOption()) {
			try {
				customers = CustomerReader.readCustomerFile();
				CustomerReport.writeCustomerReport(customers);
				CustomerReport.createCustomerReport(customers);
			} catch (ApplicationException e) {
				LOG.error(e.getMessage());
			}
		}
	}

	private void runServiceOption() {
		List<Motorcycle> motorcycle;
		List<Customer> customer;
		if (BcmcOption.isServiceOption()) {
			try {
				motorcycle = ServiceReader.readMotorCyclesFile();
				customer = CustomerReader.readCustomerFile();
				ServiceReport.writeService(motorcycle, customer);
				ServiceReport.createInventoryReport(motorcycle, customer);
			} catch (ApplicationException e) {
				LOG.error(e.getMessage());
			}
		}
	}

	private void runInventoryOption() {
		List<Inventory> inven;
		if (BcmcOption.isInventoryOption()) {
			try {
				if (BcmcOption.IsTotalOption()) {
					inven = InventoryReader.readInventoryFile();
					InventoryReport.writeInventoryTotal(inven);
					InventoryReport.createInventoryReportTotal(inven);
				} else {
					inven = InventoryReader.readInventoryFile();
					InventoryReport.writeInventory(inven);
					InventoryReport.createInventoryReport(inven);
				}
			} catch (ApplicationException e) {
				LOG.error(e.getMessage());
			}
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
