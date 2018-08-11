package salesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import dbconn.salesDAO;
import dbconn.salesDTO;

public class salesListShow implements ActionListener{

	private JTextField textField_from;
	private JTextField textField_to;
	private JButton search_button ;
	private JTable list;
	
	public salesListShow(JTextField textField_from, JTextField textField_to,JButton search_button,JTable list) {
		this.textField_from = textField_from;
		this.textField_to = textField_to;
		this.search_button=search_button;
		this.list=list;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == search_button)
		{
			salesDAO dao = new salesDAO();
			TableModel tm = list.getModel();
			ArrayList<salesDTO> lst = dao.getSalesList();
			Iterator<salesDTO> it = lst.iterator();
			int cnt=1;
			
			while(it.hasNext())
			{
				salesDTO sd = it.next();
//				tm.setValueAt(sd.getToday_dates(), cnt, 0);
//				tm.setValueAt(sd.getToday_sales(), cnt++, 1);
			}
		}
	}

	
}
