package server.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import DB.DAO.ProductDAO;

public class DelProduct implements ActionListener{

	private JTable table;
	public DelProduct(JTable table) {
		super();
		this.table = table;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		DefaultTableModel tm = (DefaultTableModel) table.getModel(); //테이블불러오기
		int row = table.getSelectedRow(); //행 선택

		String proName =  (String)table.getValueAt(row, 0);
		
		tm.removeRow(row);
		
		ProductDAO del = new ProductDAO();
		del.deleteProduct(proName);
		
		
	}

}
