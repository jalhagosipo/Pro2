package views;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class SignUpView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_repwd;
	private JTextField textField_phone;
	private JTextField textField_pwd;
	private JTextField textField_id;
	private JTextField textField_name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUpView frame = new SignUpView();
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
	public SignUpView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 400, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 384, 461);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_title = new JLabel("회원가입");
//		label_title.setFont(new Font("占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�", Font.BOLD, 20));
		label_title.setBounds(145, 39, 80, 27);
		panel.add(label_title);
		
		JLabel label_id = new JLabel("ID");
//		label_id.setFont(new Font("占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�", Font.PLAIN, 15));
		label_id.setBounds(45, 150, 50, 15);
		panel.add(label_id);
		
		JLabel label_pwd = new JLabel("비밀번호");
//		label_pwd.setFont(new Font("占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�", Font.PLAIN, 15));
		label_pwd.setBounds(45, 200, 60, 15);
		panel.add(label_pwd);
		
		JLabel label_repwd = new JLabel("비밀번호확인");
//		label_repwd.setFont(new Font("占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�", Font.PLAIN, 15));
		label_repwd.setBounds(45, 250, 97, 15);
		panel.add(label_repwd);
		
		JLabel label_name = new JLabel("이름");
		label_name.setFont(new Font("占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�", Font.PLAIN, 15));
		label_name.setBounds(45, 100, 50, 15);
		panel.add(label_name);
		
		JLabel label_phone = new JLabel("전화번호");
		label_phone.setFont(new Font("占쎈쐻占쎈짗占쎌굲占쎈쐻占쎈짗占쎌굲 占쎈쐻占쎈짗占쎌굲占쎈쐻�뜝占�", Font.PLAIN, 15));
		label_phone.setBounds(45, 300, 60, 15);
		panel.add(label_phone);
		
		JButton btn_signup = new JButton("회원가입");
		btn_signup.setBounds(69, 379, 97, 23);
		panel.add(btn_signup);
		
		JButton btn_cancel = new JButton("취소");
		btn_cancel.setBounds(219, 379, 97, 23);
		panel.add(btn_cancel);
		btn_cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		textField_repwd = new JTextField();
		textField_repwd.setBounds(158, 249, 158, 21);
		panel.add(textField_repwd);
		textField_repwd.setColumns(10);
		
		textField_phone = new JTextField();
		textField_phone.setColumns(10);
		textField_phone.setBounds(158, 299, 158, 21);
		panel.add(textField_phone);
		
		textField_pwd = new JTextField();
		textField_pwd.setColumns(10);
		textField_pwd.setBounds(158, 199, 158, 21);
		panel.add(textField_pwd);
		
		textField_id = new JTextField();
		textField_id.setColumns(10);
		textField_id.setBounds(158, 149, 158, 21);
		panel.add(textField_id);
		
		textField_name = new JTextField();
		textField_name.setColumns(10);
		textField_name.setBounds(158, 99, 158, 21);
		panel.add(textField_name);
	}
}
