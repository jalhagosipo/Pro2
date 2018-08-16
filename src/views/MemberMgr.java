package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MemberMgr extends JFrame {

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
					MemberMgr frame = new MemberMgr();
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
	public MemberMgr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\uD68C\uC6D0 ID");
		label.setFont(new Font("±¼¸²", Font.PLAIN, 16));
		label.setBounds(54, 40, 78, 22);
		contentPane.add(label);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(152, 38, 180, 29);
		contentPane.add(textField);
		
		JButton button = new JButton("\uAC80\uC0C9");
		button.setBounds(427, 34, 109, 37);
		contentPane.add(button);
		
		JButton button_1 = new JButton("\uC804\uCCB4 \uAC80\uC0C9");
		button_1.setBounds(602, 20, 127, 64);
		contentPane.add(button_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 105, 760, 326);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"\uD68C\uC6D0ID", "\uD68C\uC6D0\uC774\uB984", "\uC0AC\uC6A9\uC2DC\uAC04", "\uB0A8\uC740\uC2DC\uAC04"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton button_2 = new JButton("\uCD94\uAC00");
		button_2.setBounds(54, 472, 133, 60);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("\uC218\uC815");
		button_3.setBounds(256, 472, 133, 60);
		contentPane.add(button_3);
		
		JButton button_4 = new JButton("\uC0AD\uC81C");
		button_4.setBounds(450, 472, 133, 60);
		contentPane.add(button_4);
		
		JButton button_5 = new JButton("\uB2EB\uAE30");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_5.setBounds(648, 482, 111, 41);
		contentPane.add(button_5);
	}
}
