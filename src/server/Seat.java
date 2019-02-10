package server;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;

import javax.swing.JLabel;
import javax.swing.JPanel;

import DB.DAO.MemberDAO;
import DB.DAO.SeatDAO;
import views.server.SeatView;

public class Seat implements ActionListener{
	
	private JLabel lb_time_value;
	private JLabel lb_cur_time_value;
	private JLabel lb_id_value;
	private JPanel pan_seat;
	private SeatView sv;
	private int lh=0;	//lh	:남은시간 중 시
	private int lm=0;	//lm	:남은시간 중 분
	private int ls=0;	//ls	:남은시간 중 초

	
	public int Getlh() {
		return lh;
	}
	public int Getlm() {
		return lm;
	}
	public void Setlh(int lh) {
		this.lh=lh;
	}
	public void Setlm(int lm) {
		this.lm=lm;
	}
	int hour = 0; 
	int minute = 0;
	int second = 0;
	javax.swing.Timer timer; 
	
	public String GetId() {
		return lb_id_value.getText().trim();
	}

	public Seat(SeatView sv, JLabel lb_time_value,	JLabel lb_cur_time_value,	JLabel lb_id_value, JPanel pan_seat) {
		this.sv=sv;
		this.lb_time_value=lb_time_value;
		this.lb_cur_time_value=lb_cur_time_value;
		this.lb_id_value=lb_id_value;
		this.pan_seat=pan_seat;
	}
	//SeatThread에서 클라이언트가 연결될 때 호출할 메서드
	//timer를 멈추고 좌석의 사용시간, 남은시간, ID를 / 클래스내에서 남은시간에 사용할 변수의 값을 불러와 설정한다.
	public void SetStart(String id) {
		lb_time_value.setText("");
		lb_cur_time_value.setText("");
		
		SeatDAO dao= new SeatDAO();
		//시, 분, 초 로 나눈다. 
		int[] time=dao.GetTime(id);
		lh=time[0];
		lm=time[1];
		ls=time[2];
//		if(lh<=0 && lm<=0 && ls<=0) {
//			ls=0;
//		}
		//SeatView의 좌석에 남은시간을 설정한다.
		lb_time_value.setText(lh + ":" + lm +":" + ls);
		timer = new javax.swing.Timer(1000, this); 
		timer.setInitialDelay(0); 
		timer.start(); 

		lb_id_value.setText(id);
		pan_seat.setBackground(Color.green);
	}
	
	//SeatThread에서 클라이언트의 연결이 종료될 때 호출할 메서드
	//timer를 멈추고 좌석의 사용시간, 남은시간, ID를 / 클래스내에서 사용시간에 사용할 변수를 초기화한다.
	public void SetEnd() {
		MemberDAO dao= new MemberDAO();
		dao.UpdateTime(lb_id_value.getText(), lb_time_value.getText());
		
		timer.stop();
		lb_time_value.setText("");
		lb_cur_time_value.setText("");
		hour = 0; 
		minute = 0;
		second = 0;
		lb_id_value.setText("");
		pan_seat.setBackground(Color.GRAY);
	}
	
	//timer의 소스. SeatView에 사용시간과 남은시간을 출력해준다.
	@Override
	public void actionPerformed(ActionEvent e) {
		//사용시간
		second++; 		
		if(second>=60) {
			minute++;
			second=0;
		}
		if(minute>=60) {
			hour++;
			minute=0;
		}
		lb_cur_time_value.setText(hour + ":" + minute + ": " + second); 
		
		//남은시간
		if(ls<=0) {
			ls=59;
			lm--;
			if(lm<=0) {
				lm=59;
				lh--;
				if(lh<0) {
					timer.stop();
					try {
						PrintWriter pw =new PrintWriter(sv.GetSocket().getOutputStream());
						lh=0;
						lm=0;
						ls=0;//임시로 시간 -되는것을 방지
						
						lb_time_value.setText(lh+ ":" + lm + ":"+ ls);
						pw.println("timeend");
						pw.flush();
					}catch (Exception ex) {
						System.out.println(ex.getMessage());
					}
				}
			}
		}else {
			ls--;
		}
		lb_time_value.setText(lh+ ":" + lm + ":"+ ls);
	}
}
