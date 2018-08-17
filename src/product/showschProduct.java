package product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class showschProduct implements ActionListener{

	private JTextField textField;
	private JTable table;
	
	
	
	public showschProduct(JTextField textField, JTable table) {
		this.textField = textField;
		this.table = table;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand()=="°Ë»ö") {
			DefaultTableModel tm2 = (DefaultTableModel) table.getModel();
			tm2.setNumRows(0);
			ProductDAO dao2=new ProductDAO();
			Vector<ProductDTO> dto2= dao2.Product( textField.getText());
			Iterator<ProductDTO> it2 = dto2.iterator();
			
			while(it2.hasNext())
			{
				ProductDTO pd = it2.next();
				tm2.addRow(new Object[]{pd.getProNumber(),pd.getProName(),pd.getProPrice(),pd.getProStock()});
			}
			
			
				
				
				
			
			
			
		}
	}

}
