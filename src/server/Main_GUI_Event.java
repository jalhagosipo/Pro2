package server;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

import client.clientInfo.infoDAO;
import client.clientInfo.infoDTO;
import views.client.Client;
import views.server.AddtimeView;
import views.server.ClientInfoView;
import views.server.MemberMgrView;
import views.server.SalesManagerView;
import views.server.SeatView;
import views.server.StockManagementView;

public class Main_GUI_Event extends JFrame implements MouseListener, ActionListener{
	private int cur_num;
	private JLabel cur_id_label;
	private JLabel cur_time_label;
	private JLabel time_label;
	private Seat s;
	private SeatView sv;
	
	//0814 cmd로 seatview 실행하려고 주석처리 밑에 액션리스너도 주석처리
	SalesManagerView smv= new SalesManagerView();
	MemberMgrView mm= new MemberMgrView();
	AddtimeView atv = new AddtimeView(new JLabel(""));
	StockManagementView sm = new StockManagementView();
	public Main_GUI_Event() {
	}
	public Main_GUI_Event(int i, Seat s,JLabel cur_id_label, JLabel cur_time_label, JLabel time_label, SeatView sv) {
		this.cur_num=i;
		this.cur_id_label=cur_id_label;
		this.cur_time_label=cur_time_label;
		this.time_label=time_label;
		this.s=s;
		this.sv=sv;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(cur_num+"번 PC 클릭함");
		infoDAO dao= new infoDAO();
		infoDTO dto= new infoDTO();
		dto = dao.GetInfo(cur_id_label.getText());
		
		ClientInfoView ci= new ClientInfoView(cur_num, s, cur_id_label.getText(),cur_time_label,time_label, sv);
		ci.SetName(dto.getName());
		ci.SetTime(dto.getHour(), dto.getMinute(), dto.getSecond());
		ci.setVisible(true);
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="매출현황") {
			smv.setVisible(true);
		}
		if(e.getActionCommand()=="회원관리") {
			mm.setVisible(true);
		}
		if(e.getActionCommand()=="재고관리") {
			sm.setVisible(true);
		}
		if(e.getActionCommand()=="충전") {
			atv.setVisible(true);
			atv.SetBtn_main();
		}
		
	}

	
}
