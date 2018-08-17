package server;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Seat implements ActionListener{
	JLabel lb_time_value;
	JLabel lb_cur_time_value;
	JLabel lb_id_value;
	JPanel pan_seat;
	
	int lh=0;
	int lm=0;
	int ls=0;
	
	int hour = 0; 
	int minute = 0;
	int second = 0;

	javax.swing.Timer timer; 

	public Seat(JLabel lb_time_value,	JLabel lb_cur_time_value,	JLabel lb_id_value, JPanel pan_seat) {
		this.lb_time_value=lb_time_value;
		this.lb_cur_time_value=lb_cur_time_value;
		this.lb_id_value=lb_id_value;
		this.pan_seat=pan_seat;
	}

	public void SetStart(String id) {
		lb_time_value.setText("00:00:00");
		lb_cur_time_value.setText("00:00:00");
		
		SeatDAO dao= new SeatDAO();
		int[] time=dao.GetTime(id);
		lh=time[0];
		lm=time[1];
		ls=time[2];
		lb_time_value.setText(lh + ":" + lm +":" + ls);
		timer = new javax.swing.Timer(1000, this); 
		timer.setInitialDelay(0); 
		timer.start(); 

		lb_id_value.setText(id);
		pan_seat.setBackground(Color.green);
	}
	public void SetEnd() {
		timer.stop();
		lb_time_value.setText("00:00:00");
		lb_cur_time_value.setText("00:00:00");

		lb_id_value.setText("·Î±×¾Æ¿ô");
		pan_seat.setBackground(Color.GRAY);

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
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
		lb_time_value.setText(lh+ ":" + lm + ":"+ ls);
	}
}
