/**
 * Project: Lab07
 * File: Lab7.java
 * Date: May 27, 2017
 * Time: 12:43:42 PM
 */

package a00904649;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a00904649.data.Customer;
import a00904649.database.Database;
import a00904649.database.dao.CustomerDao;
import a00904649.database.util.DbConstants;
import a00904649.io.CustomerReader;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Lab7 {

	private static final Instant startTime = Instant.now();
	public static final String LOG4J_CONFIG_FILENAME = "Log4j2.xml";

	static {
		configureLogging();
	}
	private static final Logger LOG = LogManager.getLogger(Lab7.class);
	private static CustomerDao customerDao;
	private static Database db;

	/**
	 * Entry point for Lab 7
	 * 
	 * @param args
	 *            the customer input data passed as customers.txt file and saves the report as customers_report.txt file
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		LOG.info(startTime);
		Lab7Option.process(args);
		run();
		printEndTimeAndDuration();
	}

	public static void run() {
		try {
			loadCustomers();
			CustomerDaoTester customerDaoTester = new CustomerDaoTester(customerDao);
			customerDaoTester.test();
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

	private static void loadCustomers() throws ApplicationException, SQLException, FileNotFoundException, IOException {
		Properties dbProperties = new Properties();
		dbProperties.load(new FileInputStream(DbConstants.DB_PROPERTIES_FILENAME));
		db = new Database(dbProperties);
		customerDao = new CustomerDao(db);

		if (!Database.tableExists(CustomerDao.TABLE_NAME) || Database.dbTableDropRequested()) {
			if (Database.tableExists(CustomerDao.TABLE_NAME) && Database.dbTableDropRequested()) {
				customerDao.drop();
			}

			customerDao.create();

			LOG.debug("Inserting the customers");
			List<Customer> customers = CustomerReader.readCustomerFile();
			for (Customer customer : customers) {
				customerDao.add(customer);
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