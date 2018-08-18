package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Addtime.Addtime;
import Addtime.Cilentshow;

public class AddtimeView extends JFrame {

	public JPanel contentPane;
	public JTextField textSearchid;
	public JTextField textShowname;
	private JTextArea textShowaddtime;
	

	public void run() {
		try {
			AddtimeView frame = new AddtimeView();
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		AddtimeView at=new AddtimeView();
		at.run();
	}

	/**
	 * Create the frame.
	 */
	public AddtimeView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblClientid = new JLabel("\uD68C\uC6D0 I.D.");
		lblClientid.setFont(new Font("굴림", Font.PLAIN, 27));
		lblClientid.setBounds(30, 45, 121, 32);
		contentPane.add(lblClientid);
		// 라벨 : 회원 ID
		
		textSearchid = new JTextField();
		textSearchid.setFont(new Font("Gulim", Font.PLAIN, 27));
		textSearchid.setBounds(155, 42, 170, 38);
		contentPane.add(textSearchid);
		textSearchid.setColumns(10);
		// 검색 필드 : 회원 ID
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnSearch.setBounds(338, 41, 95, 40);
		contentPane.add(btnSearch);
		// 버튼 : 검색
		
		textShowname = new JTextField();
		textShowname.setEditable(false);
		textShowname.setFont(new Font("Gulim", Font.PLAIN, 27));
		textShowname.setBounds(155, 103, 170, 38);
		contentPane.add(textShowname);
		textShowname.setColumns(10);
		// 출력 필드 : 회원 이름
		
		JButton btnAddtime1 = new JButton("1 \uC2DC\uAC04");
		btnAddtime1.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnAddtime1.setBounds(30, 200, 175, 40);
		contentPane.add(btnAddtime1);
		
		JButton btnAddtime2 = new JButton("2 \uC2DC\uAC04");
		btnAddtime2.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnAddtime2.setBounds(257, 200, 175, 40);
		contentPane.add(btnAddtime2);
		
		JButton btnAddtime3 = new JButton("3 \uC2DC\uAC04");
		btnAddtime3.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnAddtime3.setBounds(30, 280, 175, 40);
		contentPane.add(btnAddtime3);
		
		JButton btnAddtime4 = new JButton("5 \uC2DC\uAC04");
		btnAddtime4.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnAddtime4.setBounds(257, 280, 175, 40);
		contentPane.add(btnAddtime4);
		
		JButton btnAddtime5 = new JButton("10 \uC2DC\uAC04");
		btnAddtime5.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnAddtime5.setBounds(30, 360, 175, 40);
		contentPane.add(btnAddtime5);
		
		JButton btnAddtime6 = new JButton("24 \uC2DC\uAC04");
		btnAddtime6.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnAddtime6.setBounds(257, 360, 175, 40);
		contentPane.add(btnAddtime6);
		
		JButton btnClose = new JButton("\uB2EB\uAE30");
		btnClose.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnClose.setBounds(155, 611, 160, 40);
		contentPane.add(btnClose);
		// 버튼 : 1 2 3 5 10 24 시간 , 닫기
		
		
		textShowaddtime = new JTextArea();
		textShowaddtime.setLineWrap(true);
		textShowaddtime.setFont(new Font("굴림", Font.PLAIN, 27));
		textShowaddtime.setBounds(30, 444, 402, 122);
		contentPane.add(textShowaddtime);
		textShowaddtime.setColumns(10);
	
		
		
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		btnSearch.addActionListener(new Cilentshow(textSearchid,textShowname));
		btnAddtime1.addActionListener(new Addtime(textSearchid,textShowaddtime));
		btnAddtime2.addActionListener(new Addtime(textSearchid,textShowaddtime));
		btnAddtime3.addActionListener(new Addtime(textSearchid,textShowaddtime));
		btnAddtime4.addActionListener(new Addtime(textSearchid,textShowaddtime));
		btnAddtime5.addActionListener(new Addtime(textSearchid,textShowaddtime));
		btnAddtime6.addActionListener(new Addtime(textSearchid,textShowaddtime));
			
		
	}
}
