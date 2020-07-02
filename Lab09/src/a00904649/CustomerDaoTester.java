/**
 * Project: Lab07
 * File: CustomerDaoTester.java
 * Date: May 27, 2017
 * Time: 8:48:03 PM
 */

package a00904649;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.data.Customer;
import a00904649.database.dao.CustomerDao;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CustomerDaoTester {
	private static final Logger LOG = LogManager.getLogger();
	private CustomerDao customerDao;

	public CustomerDaoTester(CustomerDao customerDao) {
		this.customerDao = customerDao;
	}

	public void test() throws Exception {
		try {
			List<Long> ids = customerDao.getIds();
			LOG.info("Loaded 5 customer IDs from the database");
			LOG.info("Customer IDs: " + Arrays.toString(ids.toArray()));
			for (Long id : ids) {
				LOG.info(id);
				Customer customer = customerDao.getCustomer(id);
				LOG.info(customer);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
	}

}
