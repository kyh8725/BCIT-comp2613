/**
 * Project: Lab07
 * File: Dao.java
 * Date: May 27, 2017
 * Time: 8:49:26 PM
 */

package a00904649.database.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import a00904649.database.Database;

/**
 * @author Yoonho(Daniel) Kim A00904649
 *
 */
public abstract class Dao {

	protected final Database database;
	protected final String tableName;

	private static final Logger LOG = LogManager.getLogger();

	protected Dao(Database database, String tableName) {
		this.database = database;
		this.tableName = tableName;
	}

	public abstract void create() throws SQLException;

	protected void create(String sql) throws SQLException {
		Statement statement = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			LOG.debug(sql);
			statement.executeUpdate(sql);
		} finally {
			close(statement);
		}
	}

	protected void add(String sql) throws SQLException {
		Statement statement = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			LOG.debug(sql);
			statement.executeUpdate(sql);
		} finally {
			close(statement);
		}
	}

	public void drop() throws SQLException {
		Statement statement = null;
		try {
			Connection connection = Database.getConnection();
			statement = connection.createStatement();
			String sql = "drop table " + tableName;
			LOG.debug(sql);
			statement.executeUpdate(sql);
		} finally {
			close(statement);
		}
	}

	protected void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
