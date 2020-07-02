/**
 * Project: Lab09
 * File: Lab9.java
 * Date: Jun 10, 2017
 * Time: 11:48:13 AM
 */

package a00904649;

import java.awt.EventQueue;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Configurator;

import a00904649.data.Customer;
import a00904649.database.Database;
import a00904649.database.dao.CustomerDao;
import a00904649.database.util.DbConstants;
import a00904649.io.CustomerReader;
import a00904649.ui.MainFrame;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Lab9 {

	public static final String LOG4J_CONFIG_FILENAME = "Log4j2.xml";

	static {
		configureLogging();
	}
	private static final Logger LOG = LogManager.getLogger(Lab9.class);
	public static CustomerDao customerDao;
	private static Database db;

	/**
	 * Entry point for Lab 9
	 * 
	 * @param args
	 *            the customer input data passed as customers.txt file and saves the report as customers_report.txt file
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		Lab9Option.process(args);
		loadCustomers();
		createUI();
	}

	public static void createUI() {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
						if ("Nimbus".equals(info.getName())) {
							UIManager.setLookAndFeel(info.getClassName());
							break;
						}
					}
				} catch (Exception e) {
					e.getMessage();
				}

				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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

	public static Customer getRandomCustomer() {
		Customer customer = null;
		try {
			int i = new Random().nextInt(customerDao.getIds().size()) + 1;
			customer = customerDao.getCustomer(i);
		} catch (Exception e) {
			e.getMessage();
		}
		return customer;
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
