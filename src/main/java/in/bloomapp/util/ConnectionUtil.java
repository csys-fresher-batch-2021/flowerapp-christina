package in.bloomapp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.bloomapp.exception.DBException;

public class ConnectionUtil {
	

	private ConnectionUtil() {
		
	}

	private static final String DRIVER_CLASS_NAME = System.getenv("spring.datasource.driver-class-name");
	private static final String DB_URL= System.getenv("spring.datasource.url");
	private static final String DB_USERNAME =System.getenv("spring.datasource.username");
	private static final String DB_PASSWORD = System.getenv("spring.datasource.password");
	
/**
 * Gets the database driver connection by its url
 * @return
 * @throws DBException 
 */
public static Connection getConnection() throws DBException {

	
	Connection connection = null;
	try {
		// Step 1: Load the database driver into memory ( ClassNotFoundException )
		Class.forName(DRIVER_CLASS_NAME);

		// Step 2: Get the Database Connection (SQLException)
		connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
	} 
	catch (ClassNotFoundException | SQLException e) {
		throw new DBException("Unable to get the database connection");
	}

	return connection;

}

/**
 * Closes the data base driver connection
 * @param rs
 * @param pst
 * @param con
 * @throws SQLException 
 * @throws Exception
 */
public static void close(ResultSet rs,PreparedStatement pst, Connection con) throws SQLException{
	// Null Check - to avoid Null Pointer Exception
	if (rs != null) {
		rs.close();
	}
	if (pst != null) {
		pst.close();
	}
	if (con != null) {
		con.close();
	}
}
}