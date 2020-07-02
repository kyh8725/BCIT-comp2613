/**
 * Project: Lab07
 * File: Database.java
 * Date: May 27, 2017
 * Time: 5:41:38 PM
 */

package a00904649.database;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.database.util.DbConstants;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public class Database {

	private static Logger LOG = LogManager.getLogger();
	private static Connection connection;
	private static Properties properties;
	private static boolean dbTableDropRequested;

	public Database(Properties properties) throws FileNotFoundException, IOException {
		LOG.debug("Loading database properties from db.properties");
		Database.properties = properties;
	}

	public static Connection getConnection() throws SQLException {
		if (connection != null) {
			return connection;
		}

		try {
			connect();
		} catch (ClassNotFoundException e) {
			throw new SQLException(e);
		}

		return connection;
	}

	private static void connect() throws ClassNotFoundException, SQLException {
		Class.forName(properties.getProperty(DbConstants.DB_DRIVER_KEY));
		LOG.debug("Driver loaded");
		connection = DriverManager.getConnection(properties.getProperty(DbConstants.DB_URL_KEY), properties.getProperty(DbConstants.DB_USER_KEY),
				properties.getProperty(DbConstants.DB_PASSWORD_KEY));
		LOG.debug("Database connected");
	}

	public void shutdown() {
		if (connection != null) {
			try {
				connection.close();
				connection = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Determine if the database table exists.
	 * 
	 * @param tableName
	 * @return true is the table exists, false otherwise
	 * @throws SQLException
	 */
	public static boolean tableExists(String targetTableName) throws SQLException {
		DatabaseMetaData databaseMetaData = getConnection().getMetaData();
		ResultSet resultSet = null;
		String tableName = null;

		try {
			resultSet = databaseMetaData.getTables(connection.getCatalog(), "%", "%", null);
			while (resultSet.next()) {
				tableName = resultSet.getString("TABLE_NAME");
				if (tableName.equalsIgnoreCase(targetTableName)) {
					LOG.debug("Found the target table named: " + targetTableName);
					return true;
				}
			}
		} finally {
			resultSet.close();
		}

		return false;
	}

	public static void requestDbTableDrop() {
		dbTableDropRequested = true;
	}

	public static boolean dbTableDropRequested() {
		return dbTableDropRequested;
	}
}
