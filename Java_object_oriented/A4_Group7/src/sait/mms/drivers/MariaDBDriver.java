package sait.mms.drivers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import sait.mms.contracts.DatabaseDriver;

/**
 * this class is for connect MariaDBDriver
 * @author  Chih-hung Wang, Nicolas Rojas, Tama Parsons, Michael Sajna
 * @version August 08, 2021
 *
 * 
 */

public class MariaDBDriver implements DatabaseDriver{
	private static final String SERVER = "localhost";
	private static final int PORT = 3306;
	private static final String DATABASE = "cprg251";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "password";
	
	/**
	 * This method is to connect database
	 * @throws SQLException
	 */
	Connection connection; 
	public void connect() throws SQLException {
		String dsn = getDsn();
		connection = DriverManager.getConnection(dsn);
	}

	/**
	 * @return the dsn
	 */
	private String getDsn() {
		String dsn = String.format("jdbc:mariadb://%s:%d/%s?user=%s&password=%s", SERVER, PORT, DATABASE,
				USERNAME, PASSWORD);
		return dsn;
	}
	/**
	 * This method is to disconnect database
	 * @throws SQLException
	 */

	public void disconnect() throws SQLException {
		if(connection != null && !connection.isClosed())
			connection.close();		
	}
	
	/**
	 * This method is to get data
	 * @return Resultset results
	 * @param query
	 * @throws SQLException
	 */

	public ResultSet get(String query) throws SQLException {
		Statement  stmt = connection.createStatement();
		ResultSet results = stmt.executeQuery(query);
		return results;
	}

	/**
	 * This method is to update data
	 * @return rows
	 * @param query
	 * @throws SQLException
	 */
	public int update(String query) throws SQLException {
		Statement  stmt = connection.createStatement();
		int rows = stmt.executeUpdate(query);
		return rows;
	}
}
