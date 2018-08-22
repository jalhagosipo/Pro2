package server.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import views.server.MemberUdtView;

public class UdtMember implements ActionListener{
	JTable memlist;
	
	public UdtMember(JTable memlist) {
		super();
		this.memlist=memlist;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel tm = (DefaultTableModel) memlist.getModel(); //테이블불러오기
		int row = memlist.getSelectedRow(); //행 선택

		String id =  (String)memlist.getValueAt(row,0 );
		String name=  (String)memlist.getValueAt(row,1);
		String phone=  (String)memlist.getValueAt(row,4 );
		
		MemberUdtView udt  = new MemberUdtView(memlist,id, name, phone);
		udt.setVisible(true);
	}
	
	

}
