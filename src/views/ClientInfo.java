package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ClientInfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;//id
	private JTextField textField_1;//이름
	private JTextField textField_2;//남은시간
	private JTextField textField_3;//사용시간
	
	public void setTextField_1(String text) {
		textField_1.setText(text);
	}

	public void setTextField_2(String text) {
		textField_2.setText(text);;
	}

	/**
	 * Create the frame.
	 */
	////////////////////////////////////
	public ClientInfo(int i, String cur_id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPcnumber = new JLabel((i+1) + " \uBC88 PC");
		lblPcnumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPcnumber.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblPcnumber.setBounds(145, 39, 200, 32);
		contentPane.add(lblPcnumber);
		// PC 번호 출력 라벨
		
		JLabel lblClientid = new JLabel("\uD68C\uC6D0 I.D.");
		lblClientid.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblClientid.setBounds(40, 155, 121, 32);
		contentPane.add(lblClientid);
	
		JLabel lblClientname = new JLabel("\uD68C\uC6D0 \uC774\uB984");
		lblClientname.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblClientname.setBounds(40, 225, 121, 32);
		contentPane.add(lblClientname);
		
		JLabel lblResttime = new JLabel("\uB0A8\uC740 \uC2DC\uAC04");
		lblResttime.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblResttime.setBounds(40, 285, 121, 32);
		contentPane.add(lblResttime);
		
		JLabel lblSpendtime = new JLabel("\uC0AC\uC6A9 \uC2DC\uAC04");
		lblSpendtime.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblSpendtime.setBounds(40, 345, 121, 32);
		contentPane.add(lblSpendtime);
		// 라벨 : 회원 id, 회원 이름, 남은 시간, 사용 시간 
		
		textField = new JTextField(cur_id);
		textField.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField.setBounds(200, 150, 236, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_1.setBounds(200, 220, 236, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_2.setBounds(200, 280, 236, 38);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_3.setBounds(200, 340, 236, 38);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		// 출력 필드 : 회원 ID, 회원 이름, 남은 시간, 사용 시간
		
		JButton btnAddtime = new JButton("\uCDA9 \uC804");
		btnAddtime.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddtimeView at_Clientid=new AddtimeView();
				at_Clientid.run();
			}
		});
		btnAddtime.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnAddtime.setBounds(155, 449, 175, 40);
		contentPane.add(btnAddtime);
		
		JButton btnLogout = new JButton("\uC0AC\uC6A9 \uC885\uB8CC");
		btnLogout.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnLogout.setBounds(40, 616, 175, 40);
		contentPane.add(btnLogout);
		
		JButton btnclose = new JButton("\uB2EB\uAE30");
		btnclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				dispose();
			}
		});
		btnclose.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnclose.setBounds(250, 616, 175, 40);
		contentPane.add(btnclose);
		// 버튼 : 충 전, 사용 종료 , 닫기'
		this.setVisible(true);
		
	}
}


/*
public Clientinfo() {
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setBounds(100, 100, 500,800);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JLabel lblPcnumber = new JLabel("OO \uBC88 PC");
	lblPcnumber.setHorizontalAlignment(SwingConstants.CENTER);
	lblPcnumber.setFont(new Font("Gulim", Font.PLAIN, 27));
	lblPcnumber.setBounds(145, 39, 200, 32);
	contentPane.add(lblPcnumber);
	// PC 번호 출력 라벨
	
	JLabel lblClientid = new JLabel("\uD68C\uC6D0 I.D.");
	lblClientid.setFont(new Font("Gulim", Font.PLAIN, 27));
	lblClientid.setBounds(40, 155, 121, 32);
	contentPane.add(lblClientid);

	JLabel lblClientname = new JLabel("\uD68C\uC6D0 \uC774\uB984");
	lblClientname.setFont(new Font("Gulim", Font.PLAIN, 27));
	lblClientname.setBounds(40, 225, 121, 32);
	contentPane.add(lblClientname);
	
	JLabel lblResttime = new JLabel("\uB0A8\uC740 \uC2DC\uAC04");
	lblResttime.setFont(new Font("Gulim", Font.PLAIN, 27));
	lblResttime.setBounds(40, 285, 121, 32);
	contentPane.add(lblResttime);
	
	JLabel lblSpendtime = new JLabel("\uC0AC\uC6A9 \uC2DC\uAC04");
	lblSpendtime.setFont(new Font("Gulim", Font.PLAIN, 27));
	lblSpendtime.setBounds(40, 345, 121, 32);
	contentPane.add(lblSpendtime);
	// 라벨 : 회원 id, 회원 이름, 남은 시간, 사용 시간 
	
	textField = new JTextField();
	textField.setFont(new Font("Gulim", Font.PLAIN, 27));
	textField.setBounds(200, 150, 236, 38);
	contentPane.add(textField);
	textField.setColumns(10);
	
	textField_1 = new JTextField();
	textField_1.setFont(new Font("Gulim", Font.PLAIN, 27));
	textField_1.setBounds(200, 220, 236, 38);
	contentPane.add(textField_1);
	textField_1.setColumns(10);
	
	textField_2 = new JTextField();
	textField_2.setFont(new Font("Gulim", Font.PLAIN, 27));
	textField_2.setBounds(200, 280, 236, 38);
	contentPane.add(textField_2);
	textField_2.setColumns(10);
	
	textField_3 = new JTextField();
	textField_3.setFont(new Font("Gulim", Font.PLAIN, 27));
	textField_3.setBounds(200, 340, 236, 38);
	contentPane.add(textField_3);
	textField_3.setColumns(10);
	// 출력 필드 : 회원 ID, 회원 이름, 남은 시간, 사용 시간
	
	JButton btnAddtime = new JButton("\uCDA9 \uC804");
	btnAddtime.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			Addtime at_Clientid=new Addtime();
			at_Clientid.run();
		}
	});
	btnAddtime.setFont(new Font("Gulim", Font.PLAIN, 27));
	btnAddtime.setBounds(155, 449, 175, 40);
	contentPane.add(btnAddtime);
	
	JButton btnLogout = new JButton("\uC0AC\uC6A9 \uC885\uB8CC");
	btnLogout.setFont(new Font("Gulim", Font.PLAIN, 27));
	btnLogout.setBounds(40, 616, 175, 40);
	contentPane.add(btnLogout);
	
	JButton btnclose = new JButton("\uB2EB\uAE30");
	btnclose.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			
			dispose();
		}
	});
	btnclose.setFont(new Font("Gulim", Font.PLAIN, 27));
	btnclose.setBounds(250, 616, 175, 40);
	contentPane.add(btnclose);
	// 버튼 : 충 전, 사용 종료 , 닫기'
	
	
}
*/