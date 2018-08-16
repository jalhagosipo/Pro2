package server;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class Seat {
	JLabel lb_time_value[];
	JLabel lb_cur_time_value[];
	JLabel lb_id_value[];
	JPanel pan_seat[];

	public Seat(JLabel[] lb_time_value,	JLabel[] lb_cur_time_value,	JLabel[] lb_id_value, JPanel[] pan_seat) {
		this.lb_time_value=lb_time_value;
		this.lb_cur_time_value=lb_cur_time_value;
		this.lb_id_value=lb_id_value;
		this.pan_seat=pan_seat;
	}

	public void SetStart(int num,String id) {
		lb_time_value[num].setText("00:00:00");
		lb_cur_time_value[num].setText("00:00:00");

		lb_id_value[num].setText(id);
		pan_seat[num].setBackground(Color.green);
	}
	public void SetEnd(int num) {
		lb_time_value[num].setText("00:00:00");
		lb_cur_time_value[num].setText("00:00:00");

		lb_id_value[num].setText("·Î±×¾Æ¿ô");
		pan_seat[num].setBackground(Color.GRAY);

	}
}
