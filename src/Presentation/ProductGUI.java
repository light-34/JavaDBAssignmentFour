package Presentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Business.Products;
import Data.DataIO;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ProductGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtProduct_ID;
	private JTextField txtProd_Name;
	private JTextField txtPrice;
	private JTable tableProducts;
	private JTextField txtPriceRange1;
	private JTextField txtPriceRange2;
	private JTextField txtKeyword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductGUI frame = new ProductGUI();
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
	public ProductGUI() {
		setTitle("Product Info");		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 496, 518);
		
		JMenuBar menuProd = new JMenuBar();
		setJMenuBar(menuProd);
		
		JMenu mnuSystem = new JMenu("System");
		menuProd.add(mnuSystem);
		
		JMenuItem MnuItemExit = new JMenuItem("Exit");
		MnuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				System.exit(0);
			}
		});
		mnuSystem.add(MnuItemExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblProd_ID = new JLabel("Product ID");
		lblProd_ID.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProd_ID.setBounds(10, 11, 104, 17);
		contentPane.add(lblProd_ID);
		
		txtProduct_ID = new JTextField();
		txtProduct_ID.setColumns(10);
		txtProduct_ID.setBounds(111, 11, 120, 20);
		contentPane.add(txtProduct_ID);
		
		JLabel lblAutoGen = new JLabel("---> Will be auto generated for you");
		lblAutoGen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutoGen.setBounds(228, 11, 254, 17);
		contentPane.add(lblAutoGen);
		
		JLabel lblProd_Name = new JLabel("Product Name");
		lblProd_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProd_Name.setBounds(10, 39, 104, 17);
		contentPane.add(lblProd_Name);
		
		txtProd_Name = new JTextField();
		txtProd_Name.setColumns(10);
		txtProd_Name.setBounds(121, 39, 164, 20);
		contentPane.add(txtProd_Name);
		
		JLabel lblPrice = new JLabel("List Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(305, 39, 71, 17);
		contentPane.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(386, 39, 86, 20);
		contentPane.add(txtPrice);
		
		tableProducts = new JTable();
		tableProducts.setBounds(10, 67, 462, 302);
		contentPane.add(tableProducts);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataIO dbIO = new DataIO();
					Products product = new Products();
					
					// Below is to create table 
					//dbIO.createProductsTable();	
					
					// inserting rows below 
					/// need to work on prod id gen	
					
					/*
					product.setProductName(txtProd_Name.toString());
					double i = 0.0;		String str = "";   str = txtPrice.toString();
					i = Double.parseDouble(str);
					product.setListPrice(i);
					*/
					
					
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(10, 416, 128, 37);
		contentPane.add(btnSave);
		
		JButton btnFind = new JButton("Find");
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(177, 416, 128, 37);
		contentPane.add(btnFind);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataIO dbIO = new DataIO();
					Products product = new Products();
					
					// updating rows 	
					/*
					product.setProductName(txtProd_Name.toString());
					double i = 0.0;		String str = "";   str = txtPrice.toString();
					i = Double.parseDouble(str);
					product.setListPrice(i);
					
					dbIO.updateProduct(product);
					*/
					
					
					
					
				} catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(344, 416, 128, 37);
		contentPane.add(btnUpdate);
		
		JLabel lblPriceRange = new JLabel("Price Range");
		lblPriceRange.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPriceRange.setBounds(10, 380, 86, 25);
		contentPane.add(lblPriceRange);
		
		txtPriceRange1 = new JTextField();
		txtPriceRange1.setBounds(106, 384, 32, 20);
		contentPane.add(txtPriceRange1);
		txtPriceRange1.setColumns(10);
		
		JLabel lblAnd = new JLabel("&");
		lblAnd.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAnd.setBounds(148, 383, 18, 18);
		contentPane.add(lblAnd);
		
		txtPriceRange2 = new JTextField();
		txtPriceRange2.setColumns(10);
		txtPriceRange2.setBounds(166, 384, 32, 20);
		contentPane.add(txtPriceRange2);
		
		JLabel lblKeyword = new JLabel("Keyword");
		lblKeyword.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblKeyword.setBounds(208, 380, 86, 25);
		contentPane.add(lblKeyword);
		
		txtKeyword = new JTextField();
		txtKeyword.setColumns(10);
		txtKeyword.setBounds(279, 384, 193, 20);
		contentPane.add(txtKeyword);
	}
}
