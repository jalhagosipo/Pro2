package Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import views.MemberUdt;

public class Up implements ActionListener{
	JTable memlist;
	
	public Up(JTable memlist) {
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
		MemberUdt udt  = new MemberUdt(id, name, phone);
		udt.setVisible(true);
	}
	
	

}
