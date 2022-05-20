package JDBC_connector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC_c {

	public static Connection con;
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.jdbc.Driver");
		System.out.println();
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/selenium","root","root");
	}

}
