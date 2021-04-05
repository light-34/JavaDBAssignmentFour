package Data;

import java.sql.*;
import java.util.ArrayList;



public class DataIO {
	
	private Connection conn = null;
	
	public DataIO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(DBProps.getDBURL(), DBProps.getConnectionProps());
	}
	
	public void createCustomersTable() throws SQLException {
		String sqlQuery = "Create Table C_Customers (\n"
				+ "C_ID int PRIMARY KEY,\n"
				+ "F_NAME varchar2 (30) NOT NULL,\n"
				+ "L_NANE varchar2 (30) NOT NULL,\n"
				+ "PHONE_NO varchar2 (10),\n"
				+ "EMAIL varchar2 (30) NOT NULL,\n"
				+ "STREET varchar2 (50),\n"
				+ "CITY varchar2 (30),\n"
				+ "PROVINCE varchar2 (20),\n"
				+ "POST_CODE varchar2 (6)\n"
				+ ")";
		
		Statement stm = conn.createStatement();
		stm.execute(sqlQuery);
		stm.close();
	}
	
	public void createProductsTable() throws SQLException {
		String sqlQuery = "Create Table P_Products (\n"	
				+ "STREET int PRIMARY KEY,\n"
				+ "PRODUCT_NAME (30) NOT NULL,\n"
				+ "STREET double (6,2) NOT NULL\n"
				+ ")";
		
		Statement stm = conn.createStatement();
		stm.execute(sqlQuery);
		stm.close();
	}
}
