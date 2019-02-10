package server.salesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DB.DAO.SalesDAO;
import DB.DTO.SalesDTO;

public class SalesListShow implements ActionListener{


	private JTextField textField_from;
	private JTextField textField_to;
	private JTable list;

	public SalesListShow(JTextField textField_from, JTextField textField_to,JTable list) {
		this.textField_from = textField_from;
		this.textField_to = textField_to; 
		this.list=list;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub


		SalesDAO dao = new SalesDAO();
		DefaultTableModel tm = (DefaultTableModel) list.getModel();
		tm.setNumRows(0);
		Vector<SalesDTO> lst = dao.getSalesList(textField_from.getText().trim(),textField_to.getText().trim());
		Iterator<SalesDTO> it = lst.iterator();

		while(it.hasNext())
		{
			SalesDTO sd = it.next();
			tm.addRow(new Object[]{sd.getToday_dates(),sd.getToday_sales()});
		}
	}
}
