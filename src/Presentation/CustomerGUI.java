package Presentation;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Business.Customers;
import Data.DataIO;


import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import java.awt.Color;

public class CustomerGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtCustId;
	private JTextField txtFName;
	private JTextField txtLName;
	private JTextField txtPhoneNo;
	private JTextField txtEmail;
	private JTextField txtStreet;
	private JTextField txtCity;
	private JTextField txtPostal;
	private JComboBox cmbBxProv;
	private JTextArea txtArea;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CustomerGUI frame = new CustomerGUI();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public CustomerGUI() {
				
		ProductGUI prod = new ProductGUI();
		
		setTitle("Customer Info");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 539, 622);
		
		JMenuBar menuCust = new JMenuBar();
		setJMenuBar(menuCust);
		
		JMenu mnuSystem = new JMenu("System");
		menuCust.add(mnuSystem);
		
		JMenuItem mnuItemProduct = new JMenuItem("Switch to Product");
		mnuItemProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				prod.setVisible(true);
				//cust.dispose();
			}
		});
		mnuSystem.add(mnuItemProduct);
		
		JMenuItem mnuItemExit = new JMenuItem("Exit");
		mnuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuSystem.add(mnuItemExit);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 224));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCust_ID = new JLabel("Customer ID");
		lblCust_ID.setForeground(Color.RED);
		lblCust_ID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCust_ID.setBounds(10, 23, 104, 17);
		contentPane.add(lblCust_ID);
		
		JLabel lblFirst_Name = new JLabel("First Name");
		lblFirst_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblFirst_Name.setBounds(10, 51, 79, 17);
		contentPane.add(lblFirst_Name);
		
		JLabel lblLast_Name = new JLabel("Last Name");
		lblLast_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLast_Name.setBounds(229, 51, 79, 17);
		contentPane.add(lblLast_Name);
		
		JLabel lblPhone_No = new JLabel("Phone#");
		lblPhone_No.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPhone_No.setBounds(10, 79, 79, 17);
		contentPane.add(lblPhone_No);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(229, 79, 79, 17);
		contentPane.add(lblEmail);
		
		JLabel lblAutoGen = new JLabel("---> Will be auto generated for you");
		lblAutoGen.setForeground(Color.RED);
		lblAutoGen.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblAutoGen.setBounds(229, 23, 254, 17);
		contentPane.add(lblAutoGen);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblCity.setBounds(229, 107, 79, 17);
		contentPane.add(lblCity);
		
		JLabel lblProvince = new JLabel("Province");
		lblProvince.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProvince.setBounds(10, 135, 79, 17);
		contentPane.add(lblProvince);
		
		JLabel lblPostalCode = new JLabel("Postal Code");
		lblPostalCode.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPostalCode.setBounds(229, 135, 89, 17);
		contentPane.add(lblPostalCode);
		
		txtCustId = new JTextField();
		txtCustId.setBounds(111, 23, 120, 20);
		contentPane.add(txtCustId);
		txtCustId.setColumns(10);
		
		txtFName = new JTextField();
		txtFName.setColumns(10);
		txtFName.setBounds(99, 51, 120, 20);
		contentPane.add(txtFName);
		
		txtLName = new JTextField();
		txtLName.setColumns(10);
		txtLName.setBounds(318, 51, 120, 20);
		contentPane.add(txtLName);
		
		txtPhoneNo = new JTextField();
		txtPhoneNo.setColumns(10);
		txtPhoneNo.setBounds(99, 79, 120, 20);
		contentPane.add(txtPhoneNo);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(318, 79, 120, 20);
		contentPane.add(txtEmail);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStreet.setBounds(10, 107, 79, 17);
		contentPane.add(lblStreet);
		
		txtStreet = new JTextField();
		txtStreet.setColumns(10);
		txtStreet.setBounds(99, 107, 120, 20);
		contentPane.add(txtStreet);
		
		txtCity = new JTextField();
		txtCity.setColumns(10);
		txtCity.setBounds(318, 107, 120, 20);
		contentPane.add(txtCity);
		
		txtPostal = new JTextField();
		txtPostal.setColumns(10);
		txtPostal.setBounds(318, 135, 120, 20);
		contentPane.add(txtPostal);
		
		
		try {
			DataIO dat = new DataIO();
			cmbBxProv = new JComboBox(dat.comboBoxLoader());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		cmbBxProv.setBounds(77, 134, 142, 22);
		contentPane.add(cmbBxProv);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBackground(Color.GREEN);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{	
				
				try {
					DataIO data = new DataIO();
					Customers customer = new Customers(txtFName.getText(), 
													   txtLName.getText(), 
													   txtPhoneNo.getText(),
													   txtEmail.getText(),
													   txtStreet.getText(),
													   txtCity.getText(),
													   cmbBxProv.getSelectedItem(),
													   txtPostal.getText());
					
					data.insertCustomer(customer);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block					 
					e1.printStackTrace();
				}
			}
		});
		btnSave.setBounds(10, 162, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnDisplay = new JButton("Display");
		btnDisplay.setBackground(Color.ORANGE);
		btnDisplay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataIO data = new DataIO();
					
					String str = "First Name" + "\t" + "Last Name\n";
					
					for(Customers list : data.getCustomers()) {
						str += list.getfName() + "\t" + list.getlName() +"\n";
					}
					txtArea.setText(str);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnDisplay.setBounds(142, 163, 89, 23);
		contentPane.add(btnDisplay);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBackground(Color.YELLOW);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataIO data = new DataIO();
					Customers customer = new Customers(Integer.parseInt(txtCustId.getText()),
							txtFName.getText(), 
							   txtLName.getText(), 
							   txtPhoneNo.getText(),
							   txtEmail.getText(),
							   txtStreet.getText(),
							   txtCity.getText(),
							   cmbBxProv.getSelectedItem(),
							   txtPostal.getText());
					
					data.updateCustomer(customer);
					
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				
				
			}
		});
		btnUpdate.setBounds(281, 163, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(Color.RED);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		btnExit.setBounds(420, 162, 89, 23);
		contentPane.add(btnExit);
		
		JButton btnFirst = new JButton("First");
		btnFirst.setBackground(new Color(135, 206, 235));
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
				try {
					DataIO dbIO = new DataIO();
					ArrayList<Customers> customers = dbIO.firstCust();
					// call method to return program info from database					
					for(Customers c : customers) // for loop to print 
					{
						String cust_id = String.valueOf(c.getCustomerid());
						txtCustId.setText(cust_id);
						txtFName.setText(c.getfName());
						txtLName.setText(c.getlName());			
						txtPhoneNo.setText(c.getPhoneNo());						
						txtEmail.setText(c.getEmail());	
						txtStreet.setText(c.getStreet());	
						txtCity.setText(c.getCity());
						cmbBxProv.setSelectedItem(c.getProvince());
						txtPostal.setText(c.getPostalCode());	
					}
					dbIO = null;
					// database object is removed 
					
					//System.exit(0);
					// exits system 
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnFirst.setBounds(10, 535, 89, 23);
		contentPane.add(btnFirst);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBackground(Color.CYAN);
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataIO dbIO = new DataIO();
					ArrayList<Customers> customers = dbIO.nextCust();		
					
					for(Customers c : customers) // for loop to print 
					{
						String cust_id = String.valueOf(c.getCustomerid());
						txtCustId.setText(cust_id);
						txtFName.setText(c.getfName());
						txtLName.setText(c.getlName());			
						txtPhoneNo.setText(c.getPhoneNo());						
						txtEmail.setText(c.getEmail());	
						txtStreet.setText(c.getStreet());	
						txtCity.setText(c.getCity());
						cmbBxProv.setSelectedItem(c.getProvince());
						txtPostal.setText(c.getPostalCode());		
					}
					dbIO = null;
					// database object is removed 				
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"There are no next records"); 
					e1.printStackTrace();
				}
			}
		});
		btnNext.setBounds(142, 536, 89, 23);
		contentPane.add(btnNext);
		
		JButton btnPrev = new JButton("Previous");
		btnPrev.setBackground(Color.CYAN);
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataIO dbIO = new DataIO();
					ArrayList<Customers> customers = dbIO.prevCust();						
					for(Customers c : customers) // for loop to print 
					{
						String cust_id = String.valueOf(c.getCustomerid());
						txtCustId.setText(cust_id);
						txtFName.setText(c.getfName());
						txtLName.setText(c.getlName());			
						txtPhoneNo.setText(c.getPhoneNo());						
						txtEmail.setText(c.getEmail());	
						txtStreet.setText(c.getStreet());	
						txtCity.setText(c.getCity());
						cmbBxProv.setSelectedItem(c.getProvince());
						txtPostal.setText(c.getPostalCode());	
					}
					dbIO = null;
					// database object is removed 
					
					//System.exit(0);
					// exits system 
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null,"There are no prev records"); 
					e1.printStackTrace();
				}
			}
		});
		btnPrev.setBounds(281, 536, 89, 23);
		contentPane.add(btnPrev);
		
		JButton btnLast = new JButton("Last");
		btnLast.setBackground(new Color(135, 206, 235));
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataIO dbIO = new DataIO();
					ArrayList<Customers> customers = dbIO.lastCust(); // call method to return program info from database
					
					for(Customers c : customers) // for loop to print 
					{
						String cust_id = String.valueOf(c.getCustomerid());
						txtCustId.setText(cust_id);
						txtFName.setText(c.getfName());
						txtLName.setText(c.getlName());			
						txtPhoneNo.setText(c.getPhoneNo());						
						txtEmail.setText(c.getEmail());	
						txtStreet.setText(c.getStreet());	
						txtCity.setText(c.getCity());
						cmbBxProv.setSelectedItem(c.getProvince());
						txtPostal.setText(c.getPostalCode());	
					}
					dbIO = null;
					// database object is removed 
					
					//System.exit(0);
					// exits system 
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnLast.setBounds(420, 535, 89, 23);
		contentPane.add(btnLast);
		
		txtArea = new JTextArea();
		txtArea.setBounds(10, 204, 503, 320);
		contentPane.add(txtArea);
	}
}