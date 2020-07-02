/**
 * Project: Assignment2
 * File: ServiceDao.java
 * Date: Jul 1, 2017
 * Time: 2:11:34 PM
 */

package a00904649.database.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.data.Motorcycle;
import a00904649.database.util.DbConstants;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class ServiceDao extends Dao {

	public static final String TABLE_NAME = DbConstants.SERVICE_TABLE_NAME;
	private static final Logger LOG = LogManager.getLogger();

	private static ServiceDao instance;

	public ServiceDao() throws FileNotFoundException, IOException {
		super(TABLE_NAME);
	}

	public static ServiceDao getInstance() throws FileNotFoundException, IOException, SQLException {
		if (instance == null)
			instance = new ServiceDao();

		return instance;
	}

	@Override
	public void create() throws SQLException {
		String sql = String.format(
				"create table %s(" // 1
						+ "%s VARCHAR(30), " // 2
						+ "%s VARCHAR(30), " // 3
						+ "%s VARCHAR(30), " // 4
						+ "%s VARCHAR(30), " // 5
						+ "%s VARCHAR(30), " // 6
						+ "%s VARCHAR(30), " // 7
						+ "%s VARCHAR(30)) ", // 8
				TABLE_NAME, // 1
				Fields.MOTORCYCLE_ID.getName(), // 2
				Fields.MAKE.getName(), // 3
				Fields.MODEL.getName(), // 4
				Fields.YEAR.getName(), // 5
				Fields.MILEAGE.getName(), // 6
				Fields.SERIAL_NUMBER.getName(), // 7
				Fields.CUSTOMER_ID.getName()); // 8
		LOG.debug(sql);
		super.executeUpdate(sql);
	}

	public void add(Motorcycle motorcycle) throws SQLException {
		String sql = String.format(
				"insert into %s values(" // 1
						+ "%s VARCHAR(30), " // 2
						+ "%s VARCHAR(30), " // 3
						+ "%s VARCHAR(30), " // 4
						+ "%s VARCHAR(30), " // 5
						+ "%s VARCHAR(30), " // 6
						+ "%s VARCHAR(30), " // 7
						+ "%s VARCHAR(30)) ", // 8
				TABLE_NAME, // 1
				Fields.MOTORCYCLE_ID.getName(), // 2
				Fields.MAKE.getName(), // 3
				Fields.MODEL.getName(), // 4
				Fields.YEAR.getName(), // 5
				Fields.MILEAGE.getName(), // 6
				Fields.SERIAL_NUMBER.getName(), // 7
				Fields.CUSTOMER_ID.getName()); // 8
		LOG.debug(sql);
		super.executeUpdate(sql);
	}

	public void update(Motorcycle motorcycle) throws SQLException {
		try {
			String sql = String.format("UPDATE %s set %s='%s', %s='%s', %s='%s', %s='%s', %s='%s', %s='%s' WHERE %s='%s'", TABLE_NAME, // 1
					Fields.MOTORCYCLE_ID.getName(), motorcycle.getId(), // 2
					Fields.MAKE.getName(), motorcycle.getMake(), // 3
					Fields.MODEL.getName(), motorcycle.getModel(), // 4
					Fields.YEAR.getName(), motorcycle.getYear(), // 5
					Fields.MILEAGE.getName(), motorcycle.getMileage(), // 6
					Fields.SERIAL_NUMBER.getName(), motorcycle.getSerialNumber(), // 7
					Fields.CUSTOMER_ID.getName(), motorcycle.getCustomerID()); // 8
			LOG.debug(sql);
			super.executeUpdate(sql);
		} finally {
			// close(statement);
		}
	}

	public void delete(Motorcycle item) throws SQLException {
		Connection connection;
		Statement statement = null;
		try {
			connection = database.getConnection();
			statement = connection.createStatement();
			String sql = String.format("DELETE from %s WHERE %s='%s'", tableName, Fields.MOTORCYCLE_ID.getName(), item.getId());
			LOG.debug(sql);
			super.executeUpdate(sql);
		} finally {
			close(statement);
		}
	}

	public void dropTable() throws Exception {
		super.drop();
	}

	public enum Fields {

		MOTORCYCLE_ID("motorcycle_id", "VARCHAR", 30, 1), //
		MAKE("make", "VARCHAR", 30, 2), //
		MODEL("model", "VARCHAR", 30, 3), //
		YEAR("year", "VARCHAR", 30, 4), //
		MILEAGE("mileage", "VARCHAR", 30, 5), //
		SERIAL_NUMBER("serialnumber", "VARCHAR", 30, 6), //
		CUSTOMER_ID("customerid", "VARCHAR", 30, 7); //

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
