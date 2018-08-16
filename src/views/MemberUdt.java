package views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MemberUdt extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldid;
	private JTextField textFieldpw;
	private JTextField textFieldphone;
	private JTextField textFieldname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberUdt frame = new MemberUdt();
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
	public MemberUdt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel id = new JLabel("\uD68C\uC6D0 \uC544\uC774\uB514");
		id.setBounds(29, 41, 73, 15);
		contentPane.add(id);
		
		JLabel pw = new JLabel("\uD68C\uC6D0 \uBE44\uBC00\uBC88\uD638");
		pw.setBounds(12, 87, 90, 15);
		contentPane.add(pw);
		
		JLabel phonenum = new JLabel("\uC804\uD654\uBC88\uD638");
		phonenum.setBounds(45, 127, 57, 15);
		contentPane.add(phonenum);
		
		JLabel name = new JLabel("\uC774\uB984");
		name.setBounds(56, 170, 57, 15);
		contentPane.add(name);
		
		textFieldid = new JTextField();
		textFieldid.setBounds(136, 38, 116, 21);
		contentPane.add(textFieldid);
		textFieldid.setColumns(10);
		
		textFieldpw = new JTextField();
		textFieldpw.setBounds(136, 84, 116, 21);
		contentPane.add(textFieldpw);
		textFieldpw.setColumns(10);
		
		textFieldphone = new JTextField();
		textFieldphone.setBounds(136, 124, 116, 21);
		contentPane.add(textFieldphone);
		textFieldphone.setColumns(10);
		
		textFieldname = new JTextField();
		textFieldname.setBounds(136, 167, 116, 21);
		contentPane.add(textFieldname);
		textFieldname.setColumns(10);
		
		JButton btnup = new JButton("\uC218\uC815");
		btnup.setBounds(29, 286, 97, 23);
		contentPane.add(btnup);
		
		JButton btnexit = new JButton("\uB2EB\uAE30");
		btnexit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnexit.setBounds(155, 286, 97, 23);
		contentPane.add(btnexit);
	}
}
