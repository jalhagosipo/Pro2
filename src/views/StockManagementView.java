package views;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import product.DelProduct;
import product.showschProduct;

public class StockManagementView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockManagementView frame = new StockManagementView();
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
	public StockManagementView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel headpan = new JPanel();
		headpan.setBounds(0, 0, 800, 39);
		contentPane.add(headpan);
		headpan.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\uC0C1\uD488\uBA85");
		lblNewLabel.setBounds(63, 13, 47, 15);
		headpan.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(122, 10, 404, 21);
		headpan.add(textField);
		textField.setColumns(10);
		
		JButton button_search = new JButton("\uAC80\uC0C9");
		button_search.setBounds(612, 9, 97, 23);
		headpan.add(button_search);
		
		JPanel botpan = new JPanel();
		botpan.setBounds(0, 500, 800, 48);
		contentPane.add(botpan);
		botpan.setLayout(null);
		
		JButton button_add = new JButton("\uC0C1\uD488 \uCD94\uAC00");
		button_add.setBounds(44, 0, 97, 38);
		botpan.add(button_add);
		
		JButton button_delete = new JButton("\uC0C1\uD488 \uC0AD\uC81C");
		button_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_delete.setBounds(165, 0, 97, 38);
		botpan.add(button_delete);
		
		JButton button_close = new JButton("\uB2EB\uAE30");
		button_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_close.setBounds(620, 0, 127, 38);
		botpan.add(button_close);
		button_close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton button_update = new JButton("\uC0C1\uD488 \uC218\uC815");
		button_update.setBounds(449, 0, 127, 38);
		botpan.add(button_update);
		
		
		
		JTable table = new JTable();
		
		
		
		
		Object [] columns = {"상품번호","상품이름","상품가격","재고"};
		DefaultTableModel model2 = new DefaultTableModel();
		model2.setColumnIdentifiers(columns);
		table.setModel(model2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 49, 644, 434);
		contentPane.add(scrollPane);
		
		scrollPane.setViewportView(table);
		
		button_search.addActionListener(new showschProduct(textField, table));
		button_delete.addActionListener(new DelProduct(table));
	}
}
