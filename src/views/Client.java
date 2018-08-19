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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import ClientInfo.UpdateTimeDAO;

public class Client extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
		Client c= new Client(0,"a");
	}
	
	public void closeview() {
		// TODO Auto-generated method stub
		UpdateTimeDAO dao= new UpdateTimeDAO();
		dao.UpdateTime(textField.getText(), textField_2.getText());
		System.exit(0);
	}
	
	private JPanel contentPane;
	private JTextField textField;//id
	private JTextField textField_1;//이름
	private JTextField textField_2;//남은시간
	private JTextField textField_3;//사용시간
	javax.swing.Timer timer; 
	int lh=0;
	int lm=0;
	int ls=0;
	int hour = 0; 
	int minute = 0;
	int second = 0;
	
	ChooseSnackView csv;
	
	public int getLh() {
		return lh;
	}
	public void setLh(int lh) {
		this.lh = lh;
	}
	public int getLm() {
		return lm;
	}
	public void setLm(int lm) {
		this.lm = lm;
	}
	public int getLs() {
		return ls;
	}
	public void setLs(int ls) {
		this.ls = ls;
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

	////////////////////////////////////
	public Client(int i, String cur_id) {
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
		textField.setEnabled(false);
		
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_1.setBounds(200, 220, 236, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_2.setBounds(200, 280, 236, 38);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEnabled(false);
		
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_3.setBounds(200, 340, 236, 38);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEnabled(false);
		// 출력 필드 : 회원 ID, 회원 이름, 남은 시간, 사용 시간
		
		JButton btnFood = new JButton("먹거리선택");
		btnFood.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnFood.setBounds(155, 449, 175, 40);
		contentPane.add(btnFood);

		JButton btnLogout = new JButton("\uC0AC\uC6A9 \uC885\uB8CC");
		btnLogout.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnLogout.setBounds(40, 616, 175, 40);
		contentPane.add(btnLogout);
		
		JButton btnclose = new JButton("\uB2EB\uAE30");
		btnclose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//DB에 저장후 dipose하는 클래스메소드
				closeview();
			}
		});
		btnclose.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnclose.setBounds(250, 616, 175, 40);
		contentPane.add(btnclose);
		
		//ChooseSnackView를 여기서 선언하면 먹거리선택할때 로그아웃됨 이유모르겠음
		ChooseSnackView csv= new ChooseSnackView(this,textField,textField_2);
		btnFood.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				csv.setVisible(true);
			}
		});
		
		// 버튼 : 충 전, 사용 종료 , 닫기'
		this.setVisible(true);
//		192.168.0.84
		String host="localhost";
		int port=7777;
		Socket socket=null;
		PrintWriter pw=null;
		BufferedReader in=null;
		try {
			socket=new Socket(host, port);
			pw=new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			pw.println(i);
			pw.flush();
			
			String rs1=null;
			String rs2=null;
			rs1=in.readLine();
			if(rs1.equals("1")) {
				pw.println(cur_id);
				pw.flush();
				rs2=in.readLine();
				if(rs2.equals("1")) {
					timer = new javax.swing.Timer(1000, this); 
					timer.setInitialDelay(0); 
					timer.start();
				}else {
					JOptionPane.showMessageDialog(null, "이미 접속중인 아이디입니다.");
				}
			}else {
				JOptionPane.showMessageDialog(null, "사용중인 PC입니다.");	
			}
			if(!rs1.equals("1") || !rs2.equals("1")) {
				LoginView lv= new LoginView();
				lv.setVisible(true);
				dispose();
			}
		}catch(IOException ex){
			System.out.println(ex);
		}finally {
//			if(pw!=null) try { pw.close();} catch(Exception ex) {}
//			if(socket!=null) try { socket.close();} catch(IOException ex) {}
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		second++; 		
		if(second>=60) {
			minute++;
			second=0;
		}
		if(minute>=60) {
			hour++;
			minute=0;
		}
		textField_3.setText(hour + ":" + minute + ": " + second); 
		
		if(ls<=0) {
			ls=59;
			lm--;
			if(lm<=0) {
				lm=59;
				lh--;
			}else {
				lm--;
			}
		}else {
			ls--;
		}
		textField_2.setText(lh+ ":" + lm + ":"+ ls);
	}
}