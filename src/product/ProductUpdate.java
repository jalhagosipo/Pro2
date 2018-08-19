package product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import views.MemberUdt;
import views.UpdateProductView;

public class ProductUpdate implements ActionListener{
	JTable table;
	
	public ProductUpdate(JTable table) {
		super();
		this.table=table;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel tm = (DefaultTableModel) table.getModel(); //테이블불러오기
		int row = table.getSelectedRow(); //행 선택

		String proName = (String)table.getValueAt(row, 1);
		String proPrice = (String)table.getValueAt(row, 2);
		int proStock = (int)table.getValueAt(row, 3);
		
		UpdateProductView upv = new UpdateProductView(proName, proPrice, proStock);
		upv.setVisible(true);
	}
	
	

}
