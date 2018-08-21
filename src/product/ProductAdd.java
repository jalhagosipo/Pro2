package product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import views.AddProductView;

public class ProductAdd implements ActionListener{
	JTable table;
	
	public ProductAdd(JTable table) {
		super();
		this.table = table;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		DefaultTableModel tm = (DefaultTableModel) table.getModel();
		
		String proName = null;
		String proPrice = null;
		int proStock = 0;
		
		AddProductView apv = new AddProductView(table, proName, proPrice, proStock);
		apv.setVisible(true);
		
		
	}
}
