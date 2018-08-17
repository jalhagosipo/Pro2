package snackChoose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import product.ProductDTO;

public class cart implements ActionListener{

	
	String name;
	String price;
	JComboBox amount;
	Vector<ProductDTO> cartV;
	JTable table;

	public cart(String name, String price, JComboBox amount,JTable table) {
		
		this.name = name;
		this.price = price;
		this.amount = amount;
		this.table = table;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		DefaultTableModel tm = (DefaultTableModel) table.getModel();
		
		ProductDTO pd = new ProductDTO(name,price,amount.getSelectedIndex()+1);
		tm.addRow(new Object[]{pd.getProName(),pd.getProPrice(),pd.getAmount()});
	}

}
