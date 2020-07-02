/**
 * Project: Assignment 2
 * File: CustomerDao.java
 * Date: May 27, 2017
 * Time: 8:51:02 PM
 */

package a00904649.database.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.data.Customer;
import a00904649.database.util.DbConstants;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class CustomerDao extends Dao {

	public static final String TABLE_NAME = DbConstants.CUSTOMER_TABLE_NAME;
	private static final Logger LOG = LogManager.getLogger();

	private static CustomerDao instance;

	public CustomerDao() throws SQLException, FileNotFoundException, IOException {
		super(TABLE_NAME);
	}

	public static CustomerDao getInstance() throws FileNotFoundException, IOException, SQLException {
		if (instance == null)
			instance = new CustomerDao();

		return instance;
	}

	/**
	 * create customer table with fields id,firstName, lastName, street,city,postalCode,
	 * phone, emailAddress,joinedDate. primary key = customer id.
	 * 
	 * @throws SQLException
	 */
	@Override
	public void create() throws SQLException {
		String sql = String.format(
				"create table %s(" // 1
						+ "%s VARCHAR(10), " // 2
						+ "%s VARCHAR(20), " // 3
						+ "%s VARCHAR(20), " // 4
						+ "%s VARCHAR(30), " // 5
						+ "%s VARCHAR(30), " // 6
						+ "%s VARCHAR(10), " // 7
						+ "%s VARCHAR(20), " // 8
						+ "%s VARCHAR(30), " // 9
						+ "%s DATE, " // 10
						+ "primary key (%s) )", // 11
				tableName, // 1
				Fields.CUSTOMER_ID.getName(), // 2
				Fields.FIRST_NAME.getName(), // 3
				Fields.LAST_NAME.getName(), // 4
				Fields.STREET.getName(), // 5
				Fields.CITY.getName(), // 6
				Fields.POSTAL_CODE.getName(), // 7
				Fields.PHONE.getName(), // 8
				Fields.EMAIL_ADDRESS.getName(), // 9
				Fields.JOINED_DATE.getName(), // 10
				Fields.CUSTOMER_ID.getName()); // 11
		LOG.debug(sql);
		super.executeUpdate(sql);
	}

	/**
	 * add customers to the table
	 * 
	 * @param customer
	 *            Customer Object
	 * @throws SQLException
	 */
	public void add(Customer customer) throws SQLException {
		try {
			String sql = String.format(
					"insert into %s values(" // 1 tableName
							+ "'%s', " // 2 customerId
							+ "'%s', " // 3 FirstName
							+ "'%s', " // 4 LastName
							+ "'%s', " // 5 street
							+ "'%s', " // 6 city
							+ "'%s', " // 7 postalCode
							+ "'%s', " // 8 phone
							+ "'%s', " // 9 emailAddress
							+ "'%s')", // 10 joinedDate
					tableName, // 1
					customer.getId(), // 2
					customer.getFirstName(), // 3
					customer.getLastName(), // 4
					customer.getStreet(), // 5
					customer.getCity(), // 6
					customer.getPostalCode(), // 7
					customer.getPhone(), // 8
					customer.getEmailAddress(), // 9
					customer.getJoinedDate()); // 10
			LOG.debug(sql);
			super.executeUpdate(sql);
		} finally {
			// close(statement);
		}
	}

	public Customer getCustomer(String customerId) throws SQLException, Exception {
		Customer customer = null;
		try {
			String sql = String.format("SELECT * FROM %s WHERE %s = '%s'", tableName, Fields.CUSTOMER_ID.getName(), customerId);
			LOG.debug(sql);
			ResultSet resultSet = super.executeSelect(sql);

			// get the Student
			// throw an exception if we get more than one result
			int count = 0;
			while (resultSet.next()) {
				count++;
				if (count > 1) {
					throw new Exception(String.format("Expected one result, got %d", count));
				}
				customer = new Customer.Builder(Integer.parseInt(resultSet.getString(Fields.CUSTOMER_ID.getName())),
						resultSet.getString(Fields.PHONE.getName())) //
								.setFirstName(resultSet.getString(Fields.FIRST_NAME.getName())) //
								.setLastName(resultSet.getString(Fields.LAST_NAME.getName())) //
								.setStreet(resultSet.getString(Fields.STREET.getName())) //
								.setCity(resultSet.getString(Fields.CITY.getName())) //
								.setPostalCode(resultSet.getString(Fields.POSTAL_CODE.getName())) //
								.setEmailAddress(resultSet.getString(Fields.EMAIL_ADDRESS.getName()))
								.setJoinedDate(resultSet.getDate(Fields.JOINED_DATE.getName()))//
								.build();
			}
		} finally {
		}

		return customer;
	}

	public void update(Customer customer) throws SQLException {
		try {

			String sql = String.format("UPDATE %s set %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s' WHERE %s='%s'",
					tableName, //
					Fields.CUSTOMER_ID.getName(), customer.getId(), //
					Fields.FIRST_NAME.getName(), customer.getFirstName(), //
					Fields.LAST_NAME.getName(), customer.getLastName(), //
					Fields.STREET.getName(), customer.getStreet(), //
					Fields.CITY.getName(), customer.getCity(), //
					Fields.POSTAL_CODE.getName(), customer.getPostalCode(), //
					Fields.PHONE.getName(), customer.getPhone(), //
					Fields.EMAIL_ADDRESS.getName(), customer.getEmailAddress(), //
					Fields.JOINED_DATE.getName(), customer.getJoinedDate(), //
					Fields.CUSTOMER_ID.getName(), customer.getId()); //
			LOG.debug(sql);
			super.executeUpdate(sql);
		} finally {
			// close(statement);
		}
	}

	public void delete(Customer customer) throws SQLException {

		try {
			String sql = String.format("DELETE from %s WHERE %s = '%d'", tableName, Fields.CUSTOMER_ID.getName(), customer.getId());
			LOG.debug(sql);
			super.executeUpdate(sql);
		} finally {
			// close(statement);
		}
	}

	/**
	 * iterate through the customer table and returns all the customers' id in the database
	 * 
	 * @return customersIds list of customers' id in the database
	 * @throws SQLException
	 */
	public List<Long> getIds() throws SQLException {
		List<Long> customersIds = new ArrayList<>();
		try {
			String sql = String.format("SELECT id from %s", tableName);
			ResultSet resultSet = super.executeSelect(sql);
			while (resultSet.next()) {
				customersIds.add(resultSet.getLong(Fields.CUSTOMER_ID.getName()));
			}
		} finally {

		}
		return customersIds;
	}

	public void dropTable() throws Exception {
		super.drop();
	}

	public enum Fields {

		CUSTOMER_ID("id", "VARCHAR", 10, 1), //
		FIRST_NAME("fisrtName", "VARCHAR", 20, 2), //
		LAST_NAME("lastName", "VARCHAR", 20, 3), //
		STREET("street", "VARCHAR", 30, 4), //
		CITY("city", "VARCHAR", 30, 5), //
		POSTAL_CODE("postalCode", "VARCHAR", 10, 6), //
		PHONE("phone", "VARCHAR", 10, 7), //
		EMAIL_ADDRESS("emailAddress", "VARCHAR", 30, 8), //
		JOINED_DATE("joinedDate", "DATE", -1, 9);//

		private final String name;
		private final String type;
		private final int length;
		private final int column;

		Fields(String name, String type, int length, int column) {
			this.name = name;
			this.type = type;
			this.length = length;
			this.column = column;
		}

		public String getType() {
			return type;
		}

		public String getName() {
			return name;
		}

		public int getLength() {
			return length;
		}

		public int getColumn() {
			return column;
		}
	}

}
