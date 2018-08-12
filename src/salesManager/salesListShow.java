package salesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import dbconn.salesDAO;
import dbconn.salesDTO;

public class salesListShow implements ActionListener{


	private JTextField textField_from;
	private JTextField textField_to;
	private JTable list;

	public salesListShow(JTextField textField_from, JTextField textField_to,JTable list) {
		this.textField_from = textField_from;
		this.textField_to = textField_to;
		this.list=list;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		salesDAO dao = new salesDAO();
		DefaultTableModel tm = (DefaultTableModel) list.getModel();
		tm.setNumRows(0);
		Vector<salesDTO> lst = dao.getSalesList(textField_from.getText(),textField_to.getText());
		Iterator<salesDTO> it = lst.iterator();

		while(it.hasNext())
		{
			salesDTO sd = it.next();
			tm.addRow(new Object[]{sd.getToday_dates(),sd.getToday_sales()});
		}


	}


}
