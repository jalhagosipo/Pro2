package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StockManagementView extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

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
		lblNewLabel.setBounds(32, 13, 36, 15);
		headpan.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(92, 10, 404, 21);
		headpan.add(textField);
		textField.setColumns(10);
		
		JButton button_search = new JButton("\uAC80\uC0C9");
		button_search.setBounds(508, 9, 97, 23);
		headpan.add(button_search);
		
		JButton button_read = new JButton("\uC0C1\uD488 \uC870\uD68C");
		button_read.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_read.setBounds(634, 9, 123, 23);
		headpan.add(button_read);
		
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
		button_close.setBounds(620, 0, 127, 38);
		botpan.add(button_close);
		
		JButton button_update = new JButton("\uC0C1\uD488 \uC218\uC815");
		button_update.setBounds(449, 0, 127, 38);
		botpan.add(button_update);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 49, 644, 434);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uC0C1\uD488\uBC88\uD638", "\uC0C1\uD488\uBA85", "\uAC00\uACA9", "\uC7AC\uACE0"
			}
		));
		scrollPane.setViewportView(table);
	}
}
