package views;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Login.Login;

public class LoginView extends JFrame{
	JPanel pan_main;
	public LoginView(){
		pan_main= new JPanel();
		pan_main.setLayout(null);
		setContentPane(pan_main);
		
		JLabel lb_pcnum= new JLabel("좌석번호");
		lb_pcnum.setFont(new Font("",1, 15));
		JTextField tf_pcnum = new JTextField();
		tf_pcnum.setFont(new Font("",1, 15));
		pan_main.add(lb_pcnum);
		lb_pcnum.setBounds(120, 10, 100, 20);
		pan_main.add(tf_pcnum);
		tf_pcnum.setBounds(185, 10, 50, 20);
		
		JLabel lb_id= new JLabel("I  D");
		lb_id.setFont(new Font("",1, 15));
		JTextField tf_id = new JTextField();
		tf_id.setFont(new Font("",1, 15));
		JLabel lb_pw= new JLabel("PW");
		lb_pw.setFont(new Font("",1, 15));
		JTextField tf_pw = new JTextField();
		tf_pw.setFont(new Font("",1, 15));
		pan_main.add(lb_id);
		lb_id.setBounds(50, 50, 100, 20);
		pan_main.add(tf_id);
		tf_id.setBounds(120, 50, 80, 20);
		pan_main.add(lb_pw);
		lb_pw.setBounds(50, 100, 100, 20);
		pan_main.add(tf_pw);
		tf_pw.setBounds(120, 100, 80, 20);
		
		JButton btn_signin =new JButton("로그인");
		JButton btn_signup =new JButton("회원가입");
		btn_signin.addActionListener(new Login(this,tf_id, tf_pw,tf_pcnum));
		pan_main.add(btn_signin);
		btn_signin.setBounds(75, 150, 100, 20);
		pan_main.add(btn_signup);
		btn_signup.setBounds(75, 180, 100, 20);
		
		setBounds(100, 100, 260, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginView login = new LoginView();
		login.setVisible(true);
	}

}
