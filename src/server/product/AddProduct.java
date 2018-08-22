package server.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import views.server.AddProductView;

public class AddProduct implements ActionListener{
	JTable table;
	
	public AddProduct(JTable table) {
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
