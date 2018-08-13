package ClientInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class info implements ActionListener{
	String cur_id;
	JTextField name;
	JTextField lefttime;
	public info(String cur_id, JTextField name, JTextField lefttime) {
		this.cur_id=cur_id;
		this.name=name;
		this.lefttime=lefttime;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="·Î±×ÀÎ") {
			infoDAO dao= new infoDAO();
			dao.GetInfo(cur_id);
		}
	}

}
