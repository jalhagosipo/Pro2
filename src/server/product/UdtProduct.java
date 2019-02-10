package server.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import views.server.UpdateProductView;

public class UdtProduct implements ActionListener{
	JTable table;

	public UdtProduct(JTable table) {
		super();
		this.table=table;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel tm = (DefaultTableModel) table.getModel(); //테이블불러오기
		int row = table.getSelectedRow(); //행 선택
		if(row<0) {
			JOptionPane.showMessageDialog(null, "선택된 행이 없습니다.");
		}else {

			String proName = (String)table.getValueAt(row, 0);
			String proPrice = (String)table.getValueAt(row, 1);
			int proStock = (int)table.getValueAt(row, 2);

			UpdateProductView upv = new UpdateProductView(table, proName, proPrice, proStock);
			upv.setVisible(true);
		}
	}



}
