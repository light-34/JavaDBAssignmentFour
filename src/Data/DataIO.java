package Data;

import java.sql.*;
import java.util.ArrayList;

import Business.Customers;
import Business.Products;



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
				+ "LIST_PRICE double (6,2) NOT NULL\n"
				+ ")";
		
		Statement stm = conn.createStatement();
		stm.execute(sqlQuery);
		stm.close();
	}
	
	public void insertCustomer(Customers customer) throws SQLException { // insert into table 
		// first build statement 
		String strSQL = "Insert into p_programs values ('" + customer.getCustID() + "','" 
														  + customer.getfName() + "'," 
														  + customer.getlName() + "',"
														  + customer.getPhoneNo() + "," 
														  + customer.getEmail() + ","
														  + customer.getStreet() + ","
														  + customer.getCity() + ","
														  + customer.getProvince() + ","
														  + customer.getPostalCode() + ")";
		Statement stm = conn.createStatement();
		stm.executeUpdate(strSQL);
		stm.close();
		}
	
	public void insertProduct(Products product) throws SQLException { // insert into table 
		// first build statement 
		String strSQL = "Insert into p_programs values ('" + product.getProdID() + "','" 														  
														  + product.getProductName() + ","
														  + product.getListPrice() + ")";
		Statement stm = conn.createStatement();
		stm.executeUpdate(strSQL);
		stm.close();
		}
	
	public ArrayList<Customers> getCustomers() throws SQLException {
		ArrayList<Customers> customers = new ArrayList<Customers>();
		
		String sqlQuery = "Select * from C_CUSTOMERS"; // table we created 
		
		Statement stm = conn.createStatement();
		
		ResultSet rst = stm.executeQuery(sqlQuery);
		
		while (rst.next())
		{
			Customers customer = new Customers();
			customer.setCustID(rst.getInt(1));
			customer.setfName(rst.getString(2));
			customer.setlName(rst.getString(3));
			customer.setPhoneNo(rst.getString(4));
			customer.setEmail(rst.getString(5));
			customer.setStreet(rst.getString(6));
			customer.setCity(rst.getString(7));
			customer.setProvince(rst.getString(8));
			customer.setPostalCode(rst.getString(9));
		}
		rst.close();
		stm.close();
		return customers;		
	}
	
	public ArrayList<Customers> getProducts() throws SQLException {
		ArrayList<Customers> customers = new ArrayList<Customers>();
		
		String sqlQuery = "Select * from P_PRODUCTS"; // table we created 
		
		Statement stm = conn.createStatement();
		
		ResultSet rst = stm.executeQuery(sqlQuery);
		
		while (rst.next())
		{
			Products product = new Products();
			product.setProdID(rst.getInt(1));
			product.setProductName(rst.getString(2));
			product.setListPrice(rst.getDouble(3));			
		}
		rst.close();
		stm.close();
		return customers;		
	}
	
	public void updateCustomer(Customers customer) throws SQLException { // insert into table 
		// first build statement 
		String strSQL = "Update C_CUSTOMERS set F_NAME = '" 
						+ customer.getfName() + "'"  
						+ ", L_NAME = "+ customer.getlName()   
						+ ", PHONE_NO = " + customer.getPhoneNo() 
						+ ", EMAIL = " + customer.getEmail()
						+ ", STREET = " + customer.getStreet()
						+ ", CITY = " + customer.getCity()
						+ ", PROVINCE = " + customer.getProvince()
						+ ", POST_CODE = " + customer.getPostalCode()
						+ "where C_ID = '" 
						+ customer.getCustID() + "'";	
		
		Statement stm = conn.createStatement();
		stm.executeUpdate(strSQL);
		stm.close();
		}
	
	public void updateProduct(Products product) throws SQLException { // insert into table 
		// first build statement 
		String strSQL = "Update P_PRODUCTS set PRODUCT_NAME = '" 
						+ product.getProductName() + "'"  
						+ ", LIST_PRICE = "+ product.getListPrice()   						
						+ "where P_ID = '" 
						+ product.getProdID() + "'";	
		
		Statement stm = conn.createStatement();
		stm.executeUpdate(strSQL);
		stm.close();
		}
}
