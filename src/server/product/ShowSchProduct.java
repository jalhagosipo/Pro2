package server.product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DB.DAO.ProductDAO;
import DB.DTO.ProductDTO;

public class ShowSchProduct implements ActionListener{

	private JTextField textField;
	private JTable table;
	
	
	
	public ShowSchProduct(JTextField textField, JTable table) {
		this.textField = textField;
		this.table = table;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="검색") {
			DefaultTableModel tm2 = (DefaultTableModel) table.getModel();
			tm2.setNumRows(0);
			ProductDAO dao2=new ProductDAO();
			Vector<ProductDTO> dto2= dao2.Product( textField.getText());
			Iterator<ProductDTO> it2 = dto2.iterator();
			
			while(it2.hasNext())
			{
				ProductDTO pd = it2.next();
				tm2.addRow(new Object[]{pd.getProName(),pd.getProPrice(),pd.getProStock()});
			}
			
			
		}
	}

}
