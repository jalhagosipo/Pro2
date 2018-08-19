package views;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ClientInfo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField textField;//id
	private JTextField textField_1;//이름
	private JTextField textField_2;//남은시간
	private JTextField textField_3;//사용시간
	
	int lh=0;
	int lm=0;
	int ls=0;
	
	int hour = 0; 
	int minute = 0;
	int second = 0;
	private JLabel lb_cur_time;
	private JLabel lb_time;

	javax.swing.Timer timer; 
	String Test="";
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub\
		System.out.println("닫힘");
		timer.stop();
		super.dispose();
	}
	
	public void SetName(String text) {
		textField_1.setText(text);
	}
	public void SetTime(int hour, int minute, int second) {
		lh=hour;
		lm=minute;
		ls=second;
		textField_2.setText(lh+ ":" + lm + ":"+ ls);
	}

	@Override
	public void actionPerformed(ActionEvent e) {	
		textField_3.setText(lb_cur_time.getText());
		textField_2.setText(lb_time.getText());
		//Test용 
//		Test=textField_3.getText();
//		String[] str=Test.split(":");
//		this.hour=Integer.parseInt(str[0].trim());
//		this.minute=Integer.parseInt(str[1].trim());
//		this.second=Integer.parseInt(str[2].trim());
//		textField_3.setText(hour +"시" + minute + "분" + (second+1) + "초");
		
//		if(ls<=0) {
//			ls=59;
//			lm--;
//			if(lm<=0) {
//				lm=59;
//				lh--;
//			}else {
//				lm--;
//			}
//		}else {
//			ls--;
//		}
//		textField_2.setText(lh+ ":" + lm + ":"+ ls);
	}
	
	public ClientInfo(int i, String cur_id, JLabel lb_cur_time, JLabel lb_time) {
		this.lb_cur_time=lb_cur_time;
		this.lb_time=lb_time;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		
		//충전버튼
		//Jlabel형식으로 받는생성자라 그냥 새로만들어서 넘겨줌
		JButton btnAddtime = new JButton("\uCDA9 \uC804");
		btnAddtime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				AddtimeView atv=new AddtimeView(new JLabel(textField.getText()));
				atv.setVisible(true);
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
		
		//타이머 시작.
		//메인뷰의 사용시간을 1초마다 불러오는 방식. 관련소스는 actionPerformed메소드에 있음.
		timer = new javax.swing.Timer(1000, this); 
		timer.setInitialDelay(0); 
		timer.start(); 
		
//		메인뷰에서 클릭시에는 로그인처리 하지 않도록 주석처리.(테스트용으로 남겨둠)
//		String host="localhost";
//		int port=7777;
//		Socket socket=null;
//		BufferedReader read=null;
//		PrintWriter pw=null;
//		
//		try {
//			socket=new Socket(host, port);
//			
//			pw=new PrintWriter(socket.getOutputStream());
//			read= new BufferedReader(new InputStreamReader(socket.getInputStream()));
//			
//			pw.println(i);
//			pw.flush();
//			pw.println(cur_id);
//			pw.flush();
//			
//			timer = new javax.swing.Timer(1000, this); 
//			timer.setInitialDelay(0); 
//			timer.start(); 
//		}catch(IOException ex){
//			System.out.println(ex);
//		}finally {
////			if(pw!=null) try { pw.close();} catch(Exception ex) {}
////			if(read!=null) try { read.close();} catch(IOException ex) {}
////			if(socket!=null) try { socket.close();} catch(IOException ex) {}
//		}
		
	}
}
