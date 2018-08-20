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

import server.Seat;


//주석 : 윤건희
public class ClientInfo extends JFrame implements ActionListener {
	private JPanel contentPane;
	private JTextField textField;//id
	private JTextField textField_1;//이름
	private JTextField textField_2;//남은시간
	private JTextField textField_3;//사용시간
	
	//메인뷰에서 좌석칸을 누를때 실행된다. Main_GUI_Event에서 생성자를 호출해 만들어지고 값을 설정한다.
	//lh	:남은시간 중 시간	/ lb_cur_time	:남은시간 출력 JLabel
	//lm	:남은시간 중 분	/ lb_time		:사용시간 출력 JLabel
	//ls	:남은시간 중 초
	//seat	:메인뷰에서 로그인된 PC의 좌석칸
	//timer	:메인뷰에서 남은시간과 사용시간을 불러오기위한 타이머
	private int lh=0;
	private int lm=0;
	private int ls=0;
	private Seat seat;
	private JLabel lb_cur_time;
	private JLabel lb_time;
	private javax.swing.Timer timer;
	
	//Addtime에서 충전한 시간을 메인뷰의 좌석에도 적용시키기위한 메서드.
	public void AddT(int h) {
		seat.Setlh(seat.Getlh()+h);
	}
	
	//창이 닫힐때 timer종료.
	@Override
	public void dispose() {
		timer.stop();
		super.dispose();
	}
	
	//Main_GUI_Event에서 이름을 설정하기 위한 메서드.
	public void SetName(String text) {
		textField_1.setText(text);
	}
	
	//초기값 띄워주기위해.
	public void SetTime(int hour, int minute, int second) {
		lh=hour;
		lm=minute;
		ls=second;
		textField_2.setText(lh+ ":" + lm + ":"+ ls);
	}

	//timer 1초마다 실행될 내용. 메인뷰 좌석의 남은시간과 사용시간을 불러온다.
	@Override
	public void actionPerformed(ActionEvent e) {
		textField_2.setText(lb_time.getText());
		textField_3.setText(lb_cur_time.getText());	
	}
	
	//메인뷰에서 좌석칸을 누를때 실행된다. Main_GUI_Event에서 생성자를 호출해 만들어지고 값을 설정한다.
	//i			 :로그인된 PC번호 	/ seat 	: 메인뷰에서 로그인된 PC의 좌석칸
	//cur_id	 : 				/ cur_id: 메인뷰에서 로그인된 PC의 ID값
	//lb_cur_time:메인뷰에서 로그인된 PC의 남은시간 JLabel
	//lb_time	 :메인뷰에서 로그인된 PC의 사용시간 JLabel
	public ClientInfo(int i,Seat seat, String cur_id, JLabel lb_cur_time, JLabel lb_time) {
		this.lb_cur_time=lb_cur_time;
		this.lb_time=lb_time;
		this.seat=seat;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//PC 번호 출력 라벨
		JLabel lblPcnumber = new JLabel((i+1) + " \uBC88 PC");
		lblPcnumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPcnumber.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblPcnumber.setBounds(145, 39, 200, 32);
		contentPane.add(lblPcnumber);

		//로그인된 아이디 출력 라벨
		JLabel lblClientid = new JLabel("\uD68C\uC6D0 I.D.");
		lblClientid.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblClientid.setBounds(40, 155, 121, 32);
		contentPane.add(lblClientid);
	
		//로그인된 아이디의 이름 출력 라벨
		JLabel lblClientname = new JLabel("\uD68C\uC6D0 \uC774\uB984");
		lblClientname.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblClientname.setBounds(40, 225, 121, 32);
		contentPane.add(lblClientname);
		
		//로그인된 아이디의 남은시간 출력 라벨
		JLabel lblResttime = new JLabel("\uB0A8\uC740 \uC2DC\uAC04");
		lblResttime.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblResttime.setBounds(40, 285, 121, 32);
		contentPane.add(lblResttime);
		
		//로그인된 아이디의 사용시간 출력 라벨
		JLabel lblSpendtime = new JLabel("\uC0AC\uC6A9 \uC2DC\uAC04");
		lblSpendtime.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblSpendtime.setBounds(40, 345, 121, 32);
		contentPane.add(lblSpendtime);
		// 라벨 : 회원 id, 회원 이름, 남은 시간, 사용 시간 
		
		//텍스트필드는 Enable을 flase로 설정해 수정할 수 없도록함.
		//ID 출력 필드
		textField = new JTextField(cur_id);
		textField.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField.setBounds(200, 150, 236, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setEnabled(false);
		
		//이름 출력 필드
		textField_1 = new JTextField();
		textField_1.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_1.setBounds(200, 220, 236, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEnabled(false);
		
		//남은시간 출력필드
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_2.setBounds(200, 280, 236, 38);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setEnabled(false);
		
		//사용시간 출력 필드
		textField_3 = new JTextField();
		textField_3.setFont(new Font("Gulim", Font.PLAIN, 27));
		textField_3.setBounds(200, 340, 236, 38);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		textField_3.setEnabled(false);
		// 출력 필드 : 회원 ID, 회원 이름, 남은 시간, 사용 시간
		
		//충전버튼
		JButton btnAddtime = new JButton("\uCDA9 \uC804");
		btnAddtime.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnAddtime.setBounds(155, 449, 175, 40);
		contentPane.add(btnAddtime);
		
		//사용종료 버튼.
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
		// 버튼 : 충 전, 사용 종료 , 닫기
		
		this.setVisible(true);
		
		//충전버튼을 누를때 띄울 View를 만든다.
		//여기선 출력을 Textfield했지만 충전View에선 JLabel형식이라 JLabel에 ID값을 설정하고 새로만들어서 넘겨줌
		AddtimeView atv=new AddtimeView(new JLabel(textField.getText()));
		//충전했을때 메인뷰에도 적용시키기위해 현재 클라이언트 정보창을 넘겨준다.
		atv.setClientInfo(this);
		//클라이언트의 정보를 넘겨준뒤 액션리스너를 설정하기 위한 메서드.
		atv.SetBtn();
		btnAddtime.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				atv.setVisible(true);
			}
		});
		
		//타이머 시작.
		//메인뷰의 사용시간을 1초마다 불러오는 방식. 관련소스는 actionPerformed메소드에 있음.
		timer = new javax.swing.Timer(1000, this); 
		timer.setInitialDelay(0); 
		timer.start(); 
	}
}
