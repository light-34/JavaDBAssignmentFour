package Presentation;

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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ProductGUI extends JFrame {

	private JPanel contentPane;
	private JTextField txtProductID;
	private JTextField txtProdName;
	private JTextField txtPrice;
	private JTextField txtPriceRange1;
	private JTextField txtPriceRange2;
	private JTextField txtKeyword;
	private JTextArea txtArea;

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
		
		txtProductID = new JTextField();
		txtProductID.setColumns(10);
		txtProductID.setBounds(111, 11, 120, 20);
		contentPane.add(txtProductID);
		
		JLabel lblAutoGen = new JLabel("---> Will be auto generated for you");
		lblAutoGen.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAutoGen.setBounds(228, 11, 254, 17);
		contentPane.add(lblAutoGen);
		
		JLabel lblProd_Name = new JLabel("Product Name");
		lblProd_Name.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblProd_Name.setBounds(10, 39, 104, 17);
		contentPane.add(lblProd_Name);
		
		txtProdName = new JTextField();
		txtProdName.setColumns(10);
		txtProdName.setBounds(121, 39, 164, 20);
		contentPane.add(txtProdName);
		
		JLabel lblPrice = new JLabel("List Price");
		lblPrice.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPrice.setBounds(305, 39, 71, 17);
		contentPane.add(lblPrice);
		
		txtPrice = new JTextField();
		txtPrice.setColumns(10);
		txtPrice.setBounds(386, 39, 86, 20);
		contentPane.add(txtPrice);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataIO data = new DataIO();
					Products product = new Products(txtProdName.getText(),
													Double.parseDouble(txtPrice.getText()));
					
					data.insertProduct(product);
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 		
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSave.setBounds(10, 416, 128, 37);
		contentPane.add(btnSave);
		
		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataIO data = new DataIO();
					String str = "Product ID" + "\t" + "Product Name" + "\t" + "Price\n";
					if (!txtProductID.getText().isEmpty()) {

						for(Products list : data.findProducts(Integer.parseInt(txtProductID.getText()))) {
							str +=list.getProductid() + "\t" + list.getProductName() + "\t" + list.getListPrice() +"\n";
						}
						txtArea.setText(str);
						
					} else if (!txtPriceRange1.getText().isEmpty() && !txtPriceRange2.getText().isEmpty()) {
						
						for(Products list : data.findProducts(Double.parseDouble(txtPriceRange1.getText()), Double.parseDouble(txtPriceRange2.getText()))) {
							
							str +=list.getProductid() + "\t" + list.getProductName() + "\t" + list.getListPrice() +"\n";
						}
						txtArea.setText(str);
					}
					else if (!txtKeyword.getText().isEmpty()){	
						data.findProducts(txtKeyword.getText());
						for(Products list : data.findProducts(txtKeyword.getText())) {
							
							str +=list.getProductid() + "\t" + list.getProductName() + "\t" + list.getListPrice() +"\n";
						}
						txtArea.setText(str);
					}
					else {
						str = "Something is wrong!!!" + "\nMake sure you entered a search criteria";
						txtArea.setText(str);
					}
				}catch (Exception ex) {
					ex.printStackTrace();
				}
				
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnFind.setBounds(177, 416, 128, 37);
		contentPane.add(btnFind);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					DataIO data = new DataIO();
					Products product = new Products(Integer.parseInt(txtProductID.getText()), 
													txtProdName.getText(),
													Double.parseDouble(txtPrice.getText()));
					data.updateProduct(product);
					
				} catch (Exception e1) {
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
		
		txtArea = new JTextArea();
		txtArea.setBounds(10, 67, 460, 302);
		contentPane.add(txtArea);
	}
}
