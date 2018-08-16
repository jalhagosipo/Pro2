package Addtime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import views.AddtimeView;

public class Addtime implements ActionListener  {


		JTextField textSearchid;
		JTextField textShowaddtime;
		
		
		public Addtime(JTextField textSearchid,JTextField textShowaddtime) {
			this.textSearchid=textSearchid;
			this.textShowaddtime=textShowaddtime;
	
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand()=="1 \uC2DC\uAC04") {
				
				
				AddtimeDAO dao= new AddtimeDAO();
				dao.GetAddtime(textSearchid.getText());
				
				textShowaddtime.setText( textSearchid.getText()+ " 님의  PC 이용시간이 1시간 추가 되었습니다."); 
				

				
					
			}
		}


	}

