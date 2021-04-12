package Data;

import java.sql.*;
import java.util.ArrayList;

import Business.Customers;
import Business.Products;

public class DataIO {

	private Connection conn = null;
	public static int pos = 0;
	
	// This Constructor is used to connect the DB
	public DataIO() throws ClassNotFoundException, SQLException {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		conn = DriverManager.getConnection(DBProps.getDBURL(), DBProps.getConnectionProps());
	}

	// This method is designed to create Customers Table
	public void createCustomersTable() throws SQLException {
		String sqlQuery = "Create Table C_Customers (" + "CustomerID Number(4) PRIMARY KEY,"
				+ "FNAME varchar2 (30) NOT NULL," + "LNAME varchar2 (30) NOT NULL," + "PHONE varchar2 (10),"
				+ "EMAIL varchar2 (30) NOT NULL," + "STREET varchar2 (50)," + "CITY varchar2 (30),"
				+ "PROVINCE varchar2 (20)," + "POST_CODE varchar2 (6)" + ")";

		Statement stm = conn.createStatement();
		stm.execute(sqlQuery);
		stm.close();
	}

	// This method is designed to create Products Table
	public void createProductsTable() throws SQLException {
		String sqlQuery = "Create Table p_products (" + "ProductID Number(3) PRIMARY KEY,"
				+ "PRODUCT_NAME Varchar2 (30) NOT NULL," + "LIST_PRICE Number (6,2) NOT NULL" + ")";

		Statement stm = conn.createStatement();
		stm.execute(sqlQuery);
		stm.close();
	}

	// This method is used to INSERT data into the customers table
	public void insertCustomer(Customers customer) throws SQLException {

		System.out.println("Insert Customer Table works");

		String strSQL = "Insert into c_customers (fname, lname, phone, email, street, city, province, post_code) "
				+ "values ('" + customer.getfName() + "', '" + customer.getlName() + "','" + customer.getPhoneNo()
				+ "','" + customer.getEmail() + "','" + customer.getStreet() + "','" + customer.getCity() + "','"
				+ customer.getProvince() + "','" + customer.getPostalCode() + "')";
		Statement stm = conn.createStatement();
		stm.executeUpdate(strSQL);

		System.out.println("Insert Customer Table Data Inserted");

		stm.close();
	}

	// This method is used to INSERT data into the products table
	public void insertProduct(Products product) throws SQLException {

		System.out.println("Insert Products Table works");

		String strSQL = "Insert into p_products (product_name, list_price) values ('" + product.getProductName() + "',"
				+ product.getListPrice() + ")";
		Statement stm = conn.createStatement();
		stm.executeUpdate(strSQL);

		System.out.println("Insert Products Table Data Inserted");

		stm.close();
	}

	// This method is designed to add all rows in Customers Table into an ArrayList
	public ArrayList<Customers> getCustomers() throws SQLException {
		ArrayList<Customers> custList = new ArrayList<Customers>();

		String sqlQuery = "Select * from C_CUSTOMERS";

		Statement stm = conn.createStatement();

		ResultSet rst = stm.executeQuery(sqlQuery);

		while (rst.next()) {
			Customers cust1 = new Customers(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
					rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9));
			custList.add(cust1);
		}

		rst.close();
		stm.close();
		return custList;
	}

	// This method is designed to add all rows in Products Table into an ArrayList
	public ArrayList<Products> getProducts() throws SQLException {
		ArrayList<Products> prodList = new ArrayList<Products>();

		String sqlQuery = "Select * from P_PRODUCTS";

		Statement stm = conn.createStatement();

		ResultSet rst = stm.executeQuery(sqlQuery);

		while (rst.next()) {
			Products product = new Products(rst.getInt(1), rst.getString(2), rst.getDouble(3));
			prodList.add(product);

		}
		rst.close();
		stm.close();
		return prodList;
	}

	// This method is designed to update rows in Customers Table
	public void updateCustomer(Customers customer) throws SQLException {
		String strSQL = "Update C_CUSTOMERS set FNAME = '" + customer.getfName() + "'" + ", LNAME = '"
				+ customer.getlName() + "', PHONE = '" + customer.getPhoneNo() + "', EMAIL = '" + customer.getEmail()
				+ "', STREET = '" + customer.getStreet() + "', CITY = '" + customer.getCity() + "', PROVINCE = '"
				+ customer.getProvince() + "', POST_CODE = '" + customer.getPostalCode() + "' where CustomerID = "
				+ customer.getCustomerid();

		Statement stm = conn.createStatement();
		stm.executeUpdate(strSQL);
		stm.close();
	}

	// This method is designed to update rows in Products Table
	public void updateProduct(Products product) throws SQLException {

		String strSQL = "Update P_PRODUCTS set PRODUCT_NAME = '" + product.getProductName() + "'" + ", LIST_PRICE = "
				+ product.getListPrice() + "where ProductID = " + product.getProductid();

		Statement stm = conn.createStatement();
		stm.executeUpdate(strSQL);
		stm.close();
	}

	public String[] comboBoxLoader() throws SQLException {
		String[] list = new String[14];
		int i = 0;

		String sqlQuery = "SELECT * FROM PROVINCES ORDER BY PROVINCENAME";

		Statement stm = conn.createStatement();

		ResultSet rst = stm.executeQuery(sqlQuery);

		while (rst.next()) {
			list[i] = rst.getString("provincename");
			i++;
		}

		stm.close();

		return list;
	}

	// get the first result in result set - cust table
	public ArrayList<Customers> firstCust() throws SQLException {
		ArrayList<Customers> custList = new ArrayList<Customers>();
		
		try {
			
			String sqlQuery = "Select * from C_CUSTOMERS";

			Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rst = stm.executeQuery(sqlQuery);

			while (rst.next()) {
				if (rst.isFirst()) { pos = 1;
					Customers cust1 = new Customers(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
							rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9));
					custList.add(cust1);
				}
			}

			rst.close();
			stm.close();
			//pos += 1;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custList;
	}

	public ArrayList<Customers> lastCust() throws SQLException {
		ArrayList<Customers> custList = new ArrayList<Customers>();

		try {
			
			String sqlQuery = "Select * from C_CUSTOMERS";

			Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			ResultSet rst = stm.executeQuery(sqlQuery);
			

			while (rst.next()) {
				if (rst.isLast()) { pos = rst.getRow();
					Customers cust1 = new Customers(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
							rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9));
					custList.add(cust1);
				}
			}

			rst.close();
			stm.close();
			//pos -= 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custList;
	}

	public ArrayList<Customers> nextCust(int i) throws SQLException {
		ArrayList<Customers> custList = new ArrayList<Customers>();

		try {
			pos += 1;
			String sqlQuery = "Select * from C_CUSTOMERS";

			Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rst = stm.executeQuery(sqlQuery);

			//rst.next();
			rst.absolute(pos);
			//pos +=1;

			Customers cust1 = new Customers(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
					rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9));
			custList.add(cust1);

			rst.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custList;
	}

	public ArrayList<Customers> prevCust(int j) throws SQLException {
		ArrayList<Customers> custList = new ArrayList<Customers>();

		try {
			pos -=1;			
			String sqlQuery = "Select * from C_CUSTOMERS";

			Statement stm = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			// stm.setMaxRows(1);
			ResultSet rst = stm.executeQuery(sqlQuery);
			
			//rst.last();
			rst.absolute(pos);			
			
			Customers cust1 = new Customers(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
					rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getString(9));

			custList.add(cust1);

			rst.close();
			stm.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return custList;
	}

	// Search for Keyword
	public ArrayList<Products> findProducts(String str) {
		ArrayList<Products> prodList = new ArrayList<Products>();

		String sqlQuery = "Select * from P_PRODUCTS where product_name = ? ";

		try {
			PreparedStatement prepState = conn.prepareStatement(sqlQuery);
			
			prepState.setString(1, str);

			ResultSet rst = prepState.executeQuery();

			while (rst.next()) {
				Products product = new Products(rst.getInt(1), rst.getString(2), rst.getDouble(3));
				prodList.add(product);

			}

			rst.close();
			prepState.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return prodList;
	}

	// Search for ProductID
	public ArrayList<Products> findProducts(int num) {
		ArrayList<Products> prodList = new ArrayList<Products>();

		String sqlQuery = "Select * from P_PRODUCTS where productid = ?";

		try {

			PreparedStatement prepState = conn.prepareStatement(sqlQuery);
			prepState.setInt(1, num);

			ResultSet rst = prepState.executeQuery();

			while (rst.next()) {
				Products product = new Products(rst.getInt(1), rst.getString(2), rst.getDouble(3));
				prodList.add(product);

			}

			rst.close();
			prepState.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return prodList;
	}

	// Search for Price Range
	public ArrayList<Products> findProducts(double numOne, double numTwo) {
		ArrayList<Products> prodList = new ArrayList<Products>();

		String sqlQuery = "Select * from P_PRODUCTS where list_price Between ? And ?";

		try {
			PreparedStatement prepState = conn.prepareStatement(sqlQuery);
			prepState.setDouble(1, numOne);
			prepState.setDouble(2, numTwo);

			ResultSet rst = prepState.executeQuery();

			while (rst.next()) {
				Products product = new Products(rst.getInt(1), rst.getString(2), rst.getDouble(3));
				prodList.add(product);

			}

			rst.close();
			prepState.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return prodList;
	}
}
