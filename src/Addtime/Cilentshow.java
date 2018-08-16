package Addtime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;



public class Cilentshow implements ActionListener  {


		JTextField textSearchid;
		JTextField textShowname;

		public Cilentshow(JTextField textSearchid,JTextField textShowname) {
			this.textSearchid=textSearchid;
			this.textShowname=textShowname;
			
	
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand()=="\uAC80\uC0C9") {
				
				
				
				ClientshowDAO dao= new ClientshowDAO();
				ClientshowDTO dto= new ClientshowDTO();
				dto= dao.GetShow(textSearchid.getText());
				
				textShowname.setText(dto.getMember_name());
				
				
			}


		}


	
	}

