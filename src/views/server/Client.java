package views.server;

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

import DB.DAO.MemberDAO;
import client.clientInfo.ClientThread;
import client.clientInfo.infoDAO;
import client.clientInfo.infoDTO;
import views.client.ChooseSnackView;
import views.client.LoginView;

//주석: 윤건희
public class Client extends JFrame implements ActionListener {
	//Test용. 테스트 완료 후 main은 삭제해야함  ====================================================================================
	public static void main(String[] args) {
		infoDAO dao= new infoDAO();
		infoDTO dto= new infoDTO();
		dto = dao.GetInfo("test");
		
		Client c= new Client(3,"test");
		c.SetName(dto.getName());
		c.SetTime(dto.getHour(), dto.getMinute(), dto.getSecond());
	}
	int swit=0;
	private JPanel contentPane;
	private JTextField textField;//id
	private JTextField textField_1;//이름
	private JTextField textField_2;//남은시간
	private JTextField textField_3;//사용시간
	
	private PrintWriter pw=null;
	private BufferedReader in=null;
	private int num=0;
	
	//메인뷰에서 좌석칸을 누를때 실행된다. Main_GUI_Event에서 생성자를 호출해 만들어지고 값을 설정한다.
	//lh	:남은시간 중 시	/ hour	:사용시간 중 시
	//lm	:남은시간 중 분	/ minute:사용시간 중 분
	//ls	:남은시간 중 초	/ second:사용시간 중 초
	//timer	:남은시간과 사용시간 설정을위한 타이머
	//csv	:먹거리 선택 View
	int lh=0;
	int lm=0;
	int ls=0;
	int hour = 0; 
	int minute = 0;
	int second = 0;
	javax.swing.Timer timer; 
	ChooseSnackView csv;
	
	//getter와 setter
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
	
	//Login에서 이름을 설정하기 위한 메서드.
	public void SetName(String text) {
		textField_1.setText(text);
	}
	
	//Login에서 남은시간을 설정하기 위한 메서드.
	public void SetTime(int hour, int minute, int second) {
		lh=hour;
		lm=minute;
		ls=second;
		textField_2.setText(lh+ ":" + lm + ":"+ ls);
	}
	
	//dipose가 호출될 때 호출될 메서드.
	//DAO를 통해 현재 남은 시간을 DB에 저장시키고 시스템을 종료시킨다.
	public void closeview() {
		// TODO Auto-generated method stub
		MemberDAO dao= new MemberDAO();
		dao.UpdateTime(textField.getText(), textField_2.getText());
		timer.stop();
		System.exit(0);
	}

	////////////////////////////////////
	//i		:로그인된 PC번호		/ cur_id	: Login에서 로그인된 ID
	public Client(int i, String cur_id) {
		this.num=i;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500,800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//PC번호라벨
		JLabel lblPcnumber = new JLabel((i+1) + " \uBC88 PC");
		lblPcnumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblPcnumber.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblPcnumber.setBounds(145, 39, 200, 32);
		contentPane.add(lblPcnumber);
		
		//아이디라벨
		JLabel lblClientid = new JLabel("\uD68C\uC6D0 I.D.");
		lblClientid.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblClientid.setBounds(40, 155, 121, 32);
		contentPane.add(lblClientid);
	
		//이름라벨
		JLabel lblClientname = new JLabel("\uD68C\uC6D0 \uC774\uB984");
		lblClientname.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblClientname.setBounds(40, 225, 121, 32);
		contentPane.add(lblClientname);
		
		//남은시간라벨
		JLabel lblResttime = new JLabel("\uB0A8\uC740 \uC2DC\uAC04");
		lblResttime.setFont(new Font("Gulim", Font.PLAIN, 27));
		lblResttime.setBounds(40, 285, 121, 32);
		contentPane.add(lblResttime);
		
		//사용시간라벨
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
		
		//먹거리선택버튼
		JButton btnFood = new JButton("먹거리선택");
		btnFood.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnFood.setBounds(155, 449, 175, 40);
		//ChooseSnackView를 여기서 선언하면 먹거리선택할때 로그아웃됨 이유모르겠음. 그래서 맨위에 선언해둠.
		csv= new ChooseSnackView(this,textField,textField_2);
		btnFood.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				csv.setVisible(true);
			}
		});
		contentPane.add(btnFood);

		//사용종료버튼
		JButton btnLogout = new JButton("\uC0AC\uC6A9 \uC885\uB8CC");
		btnLogout.setFont(new Font("Gulim", Font.PLAIN, 27));
		btnLogout.setBounds(40, 616, 175, 40);
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				//DB에 저장후 dipose하는 클래스메소드
				closeview();
			}
		});
		contentPane.add(btnLogout);
		
		//버튼 : 충전, 사용종료
		
		this.setVisible(true);
		
//		192.168.0.84
		String host="localhost";
		int port=7777;
		Socket socket=null;
		ClientThread ct=null;
		Thread job=null;
		try {
			socket=new Socket(host, port);
			pw=new PrintWriter(socket.getOutputStream());
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//로그인한 PC번호를 socket의 OutputStream을 이용해 SeatThread로 넘겨준다.
			pw.println(i);
			pw.flush();
			
			//rs1	:PC가 사용중인지 체크 후 반환받을 변수( 1:사용가능, else:사용중 )
			//rs1	:이미 로그인한 아이디인지 체크 후 반환받을 변수( 1:사용가능, else:사용중 )
			String rs1=null;
			String rs2=null;
			//SeatThread로부터 사용중인 PC인지 체크하는 반환값을 받을때까지 대기한다.
			rs1=in.readLine();
			if(rs1.equals("1")) {
				//로그인한 아이디를 SeatThread로 넘겨준다.
				pw.println(cur_id);
				pw.flush();
				//SeatThread로부터 사용중인 아이디인지 체크하는 반환값을 받을때까지 대기한다.
				rs2=in.readLine();
				if(rs2.equals("1")) {
					JOptionPane.showMessageDialog(null, cur_id + " 로그인 완료.");
					timer = new javax.swing.Timer(500, this); 
					timer.setInitialDelay(0); 
					timer.start();
				}else {
					JOptionPane.showMessageDialog(null, "이미 접속중인 아이디입니다.");
				}
			}else {
				JOptionPane.showMessageDialog(null, "사용중인 PC입니다.");	
			}
			//둘중 하나라도 사용불가능할 경우 로그인창을 다시 띄우고 클라이언트는 닫는다
			if(!rs1.equals("1") || !rs2.equals("1")) {
				LoginView lv= new LoginView();
				lv.setVisible(true);
				dispose();
			}
			ct=new ClientThread(socket,textField_2,textField_3);
			job=new Thread(ct);
			job.start();
		}catch(IOException ex){
			System.out.println(ex);
		}finally {
			//여기서 닫아도되는지 모르겠어서 일단 남겨둠 ====================================================================================
//			if(pw!=null) try { pw.close();} catch(Exception ex) {}
//			if(socket!=null) try { socket.close();} catch(IOException ex) {}
		}
		
	}
	//timer의 소스 남은시간과 사용시간을 계산하고 출력해준다.
	@Override
	public void actionPerformed(ActionEvent e) {
		if(swit==0) {
		pw.println("left@"+num);
		pw.flush();
		swit=1;
		}else {
		pw.println("cur@"+num);
		pw.flush();
		swit=0;
		}
	}
}