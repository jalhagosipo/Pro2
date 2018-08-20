package views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import product.AddProduct;

public class AddProductView extends JFrame {

	private JPanel contentPane;
	private JTextField tf_proName;
	private JTextField tf_price;
	private JTextField tf_stock;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProductView frame = new AddProductView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public AddProductView(String _name, String _price, int _stock) {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 200, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_proName = new JLabel("\uC0C1\uD488\uBA85");
		label_proName.setBounds(12, 36, 46, 15);
		contentPane.add(label_proName);
		
		JLabel label_price = new JLabel("\uAC00   \uACA9");
		label_price.setBounds(12, 96, 46, 15);
		contentPane.add(label_price);
		
		JLabel label_stock = new JLabel("\uC7AC   \uACE0");
		label_stock.setBounds(12, 156, 46, 15);
		contentPane.add(label_stock);
		
		tf_proName = new JTextField();
		tf_proName.setBounds(70, 33, 102, 21);
		contentPane.add(tf_proName);
		tf_proName.setColumns(10);
		
		tf_price = new JTextField();
		tf_price.setBounds(70, 93, 102, 21);
		contentPane.add(tf_price);
		tf_price.setColumns(10);
		
		tf_stock = new JTextField();
		tf_stock.setBounds(70, 153, 102, 21);
		contentPane.add(tf_stock);
		tf_stock.setColumns(10);
		
		tf_proName.setText(_name);
		tf_price.setText(_price);
		tf_stock.setText(""+_stock);
		
		JButton button_add = new JButton("Ãß°¡");
		button_add.setBounds(12, 217, 71, 23);
		contentPane.add(button_add);
		button_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddProduct ap = new AddProduct();
				ap.insertProduct(tf_proName.getText()
						,tf_price.getText()
						,Integer.parseInt(tf_stock.getText()));
				
			}
		});
		
		JButton button_close = new JButton("\uB2EB\uAE30");
		button_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_close.setBounds(101, 217, 71, 23);
		contentPane.add(button_close);
	}
}
