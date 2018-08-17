package Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import views.MemberUdt;

public class Upmem implements ActionListener {
	private JTable memlist;
	
	public Upmem() {
		super();
		
		// TODO Auto-generated constructor stub
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		DefaultTableModel tm = (DefaultTableModel) memlist.getModel(); //테이블불러오기
		int row = memlist.getSelectedRow(); //행 선택

		String id =  (String)memlist.getValueAt(row,0 );
		
		MemberUdt udt  = new MemberUdt(id);
		udt.setVisible(true);
		
	}

}
