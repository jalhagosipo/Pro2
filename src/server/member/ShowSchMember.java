package server.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DB.dao.MemberDAO;
import DB.dto.MemberDTO;
import DB.dto.salesDTO;

public class ShowSchMember implements ActionListener{

	private JTextField textFieldsch;
	private JTable memlist;
	
	public ShowSchMember(JTextField textFieldsch, JTable memlist) {
		this.textFieldsch = textFieldsch;
		this.memlist = memlist;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="°Ë»ö") {
			DefaultTableModel tm = (DefaultTableModel) memlist.getModel();
			tm.setNumRows(0);
			MemberDAO dao=new MemberDAO();
			Vector<MemberDTO> dto= dao.selectAccount(textFieldsch.getText());
			Iterator<MemberDTO> it = dto.iterator();
			
			while(it.hasNext())
			{
				MemberDTO sd = it.next();
				tm.addRow(new Object[]{sd.getId(),sd.getName(),sd.getTotal_price(),sd.getLeft_time(),sd.getPhonenum()});
			}
		}
	}

}
