package server.member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DB.DAO.MemberDAO;

public class DelMember implements ActionListener{

    private JTable memlist;
    public DelMember(JTable memlist) {
        super();
        this.memlist = memlist;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

        DefaultTableModel tm = (DefaultTableModel) memlist.getModel(); //테이블불러오기
        int row = memlist.getSelectedRow(); //행 선택

        if(row<0) {
            JOptionPane.showMessageDialog(null, "선택된 행이 없습니다.");
        }else {

            String id =  (String)memlist.getValueAt(row,0 );

            tm.removeRow(row);

            MemberDAO del = new MemberDAO();
            del.deleteAccount(id);
        }

    }

}
