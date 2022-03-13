package cybersoft.javabackend.crm.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getConnection() {
		final String database = "jdbc:mysql://localhost:3307/servlet_crm";
		final String username = "root";
		final String password = "123";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				return DriverManager.getConnection(database,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
