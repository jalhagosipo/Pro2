package member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Delmem implements ActionListener{

	private JTable memlist;
	public Delmem(JTable memlist) {
		super();
		this.memlist = memlist;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		DefaultTableModel tm = (DefaultTableModel) memlist.getModel(); //테이블불러오기
		int row = memlist.getSelectedRow(); //행 선택

		String id =  (String)memlist.getValueAt(row,0 );
		
		tm.removeRow(row);
		
		MemberDel del = new MemberDel();
		del.deleteAccount(id);
		
		
	}

}
