package salesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;

import dbconn.salesDAO;
import dbconn.salesDTO;

public class salesListShow implements ActionListener{

	private JTextField textField_from;
	private JTextField textField_to;
	private JButton search_button ;
	private JList list;
	
	public salesListShow(JTextField textField_from, JTextField textField_to,JButton search_button,JList list) {
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
			ArrayList<salesDTO> lst = dao.getSalesList();
			
//			list.setListData(listData);
			
		}
	}

	
}
