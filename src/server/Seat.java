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
	
	int num = 0;
	
	int hour = 0; 
	int min = 0;
	int sec = 0;

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
		
		timer = new javax.swing.Timer(1000, this); 
		timer.setInitialDelay(0); 
		timer.start(); 
		

		lb_id_value.setText(id);
		pan_seat.setBackground(Color.green);
	}
	public void SetEnd() {
		lb_time_value.setText("00:00:00");
		lb_cur_time_value.setText("00:00:00");

		lb_id_value.setText("·Î±×¾Æ¿ô");
		pan_seat.setBackground(Color.GRAY);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		sec++; 		
		if(sec>=60) {
			min++;
			sec=0;
		}
		if(min>=60) {
			hour++;
			min=0;
		}
		
		lb_cur_time_value.setText(hour + ":" + min + ": " + sec); 
	}
}
