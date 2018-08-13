package dbconn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

import ClientInfo.infoDAO;
import ClientInfo.infoDTO;
import views.ClientInfo;
import views.MemberMnagerTest;
import views.SalesManagerView;
import views.StockManagement;

public class Main_GUI_Event extends JFrame implements MouseListener, ActionListener{
	private int cur_num;
	private JLabel cur_id_label;
	
	SalesManagerView smv= new SalesManagerView();
	MemberMnagerTest mm= new MemberMnagerTest();
	StockManagement sm = new StockManagement();
	public Main_GUI_Event() {
	}
	public Main_GUI_Event(int i, JLabel cur_id_label) {
		this.cur_num=i;
		this.cur_id_label=cur_id_label;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		System.out.println((cur_num+1)+"번 PC 클릭함");
		infoDAO dao= new infoDAO();
		infoDTO dto= new infoDTO();
		dto = dao.GetInfo(cur_id_label.getText());
		
		ClientInfo ci= new ClientInfo(cur_num, cur_id_label.getText());
		ci.setTextField_1(dto.getName());
		ci.setTextField_2(dto.getLeftTime());
		ci.setVisible(true);
		
//		System.out.println(cur_id_label.toString());
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="매출현황") {
			smv.setVisible(true);
		}
		if(e.getActionCommand()=="회원관리") {
			mm.frame.setVisible(true);
		}
		if(e.getActionCommand()=="재고관리") {
			sm.setVisible(true);
		}
		
	}

	
}
