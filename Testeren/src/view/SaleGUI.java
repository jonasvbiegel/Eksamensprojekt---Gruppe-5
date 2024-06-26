package view;

import controller.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextField;

public class SaleGUI extends JDialog {

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private String customerNo;
	private int orderNo;
	private JTextField textField;
	
	private SaleController sc;
	private CustomerController cc;
	private ProductController pc;

	private JLabel lblCustomerError;
	private JLabel lblCustomerInfo;
	private JTextField textFieldProduct;
	private JTextField textFieldQuantity;
	private JTextField textFieldOrderNo;
	private JLabel lblProductInfo;
	private JLabel lblProductError;
	private JLabel lblAddError;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SaleGUI dialog = new SaleGUI();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Create the dialog.
	 */
	public SaleGUI() {
		setBounds(100, 100, 423, 385);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblCustomerNo = new JLabel("Customer No.:");
		lblCustomerNo.setBounds(10, 8, 96, 20);
		contentPanel.add(lblCustomerNo);
		
		textField = new JTextField();
		textField.setBounds(111, 8, 107, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JButton btnFindCustomer = new JButton("Create Sale");
		btnFindCustomer.setBounds(111, 61, 107, 23);
		btnFindCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cc = new CustomerController();
				sc = new SaleController();
				try {
					cc.findCustomerByPhoneNo(textField.getText());
				} catch(Exception e1) {
					lblCustomerError.setText("Customer not found");
					return;
				}
				
				try {
					Integer.valueOf(textFieldOrderNo.getText());
				}
				catch(Exception e1) {
					lblCustomerError.setText("Invalid order number");
					return;
				}
				
				orderNo = Integer.valueOf(textFieldOrderNo.getText());
				customerNo = textField.getText();
				
				sc.createSale(orderNo, customerNo, "111");
				
				lblCustomerError.setText("");
				lblCustomerInfo.setText("Sale created for " + cc.findCustomerByPhoneNo(customerNo).getName() + " with order number " + orderNo);
			}
		});
		contentPanel.add(btnFindCustomer);
		
		lblCustomerError = new JLabel("");
		lblCustomerError.setBounds(228, 8, 166, 14);
		contentPanel.add(lblCustomerError);
		
		lblCustomerInfo = new JLabel("");
		lblCustomerInfo.setBounds(10, 95, 384, 14);
		contentPanel.add(lblCustomerInfo);
		
		JLabel lblProductNo = new JLabel("Product No.:");
		lblProductNo.setBounds(10, 191, 96, 20);
		contentPanel.add(lblProductNo);
		
		textFieldProduct = new JTextField();
		textFieldProduct.setColumns(10);
		textFieldProduct.setBounds(111, 191, 107, 20);
		contentPanel.add(textFieldProduct);
		
		JButton btnFindProduct = new JButton("Find Product");
		btnFindProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pc = new ProductController();
				
				String barcode = textFieldProduct.getText();
				
				try {
					pc.findProductByBarcode(barcode);
				} catch(Exception e1) {
					lblProductError.setText("Product not found");
					return;
				}
				
				String productName = pc.findProductByBarcode(textFieldProduct.getText()).getName();
				double currentPrice = pc.findProductByBarcode(textFieldProduct.getText()).getCurrentPrice();
				
				lblProductError.setText("");
				
				lblProductInfo.setText(productName + " - " + String.valueOf(currentPrice) + " DKK / stk");
			}
		});
		btnFindProduct.setBounds(111, 253, 107, 23);
		contentPanel.add(btnFindProduct);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(10, 222, 96, 20);
		contentPanel.add(lblQuantity);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		textFieldQuantity.setBounds(111, 222, 107, 20);
		contentPanel.add(textFieldQuantity);
		
		textFieldOrderNo = new JTextField();
		textFieldOrderNo.setColumns(10);
		textFieldOrderNo.setBounds(111, 34, 107, 20);
		contentPanel.add(textFieldOrderNo);
		
		JLabel lblOrderNo = new JLabel("Order No.:");
		lblOrderNo.setBounds(10, 34, 96, 20);
		contentPanel.add(lblOrderNo);
		
		JButton btnAddProduct = new JButton("Add Product");
		btnAddProduct.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sc = new SaleController();
				
				String barcode = textFieldProduct.getText();
				
				if(textFieldQuantity.getText() == "") {
					try {
						sc.addProductToSale(barcode, 1, Integer.parseInt(textFieldOrderNo.getText()));
					} catch(Exception e1) {
						lblAddError.setText("A problem occurred");
						return;
					}
					
					lblAddError.setText("Product added");
				}
				
				try {
					sc.addProductToSale(barcode, Integer.parseInt(textFieldQuantity.getText()), orderNo);
				} catch(Exception e1){
					lblAddError.setText("A problem occurred");
					return;
				}
				
				lblAddError.setText("Product added");
			}
		});
		btnAddProduct.setBounds(227, 253, 107, 23);
		contentPanel.add(btnAddProduct);
		
		lblProductInfo = new JLabel("");
		lblProductInfo.setBounds(228, 191, 166, 14);
		contentPanel.add(lblProductInfo);
		
		lblProductError = new JLabel("");
		lblProductError.setBounds(228, 194, 48, 14);
		contentPanel.add(lblProductError);
		
		lblAddError = new JLabel("");
		lblAddError.setBounds(228, 225, 166, 14);
		contentPanel.add(lblAddError);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
					}
				});
				//okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				
			}
			{
				JButton cancelButton = new JButton("Cancel");
//				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);
						dispose();
					}
				});
			}
		}
	}
}
