package Addtime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import views.AddtimeView;

public  class Addtime implements ActionListener  {


	JTextField textSearchid;
	JTextField textShowaddtime;
	String hours;
		
		
		public Addtime(JTextField textSearchid,JTextField textShowaddtime) {
			this.textSearchid=textSearchid;
			this.textShowaddtime=textShowaddtime;
	
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getActionCommand()=="1 \uC2DC\uAC04") {
				
				hours="01:00:00";
				AddtimeDAO dao= new AddtimeDAO();
				dao.GetAddtime(hours ,textSearchid.getText());
				textShowaddtime.setText( textSearchid.getText()+ " 님의  PC 이용시간이 1시간 추가 되었습니다."); 
						
				
			}
		
		
	
			else if(e.getActionCommand()=="2 \uC2DC\uAC04") {
				
				hours="02:00:00";
				AddtimeDAO dao= new AddtimeDAO();
				dao.GetAddtime(hours,textSearchid.getText());
				textShowaddtime.setText( textSearchid.getText()+ " 님의  PC 이용시간이 2시간 추가 되었습니다."); 
						
			}
		
		
		
			else if(e.getActionCommand()=="3 \uC2DC\uAC04") {
				
				hours="03:00:00";
				AddtimeDAO dao= new AddtimeDAO();
				dao.GetAddtime(hours, textSearchid.getText());
				textShowaddtime.setText( textSearchid.getText()+ " 님의  PC 이용시간이 3시간 추가 되었습니다."); 
						
			}
		
		
		
		
		
			else if(e.getActionCommand()=="5 \uC2DC\uAC04") {
				
				hours="05:00:00";
				AddtimeDAO dao= new AddtimeDAO();
				dao.GetAddtime(hours,textSearchid.getText());
				textShowaddtime.setText( textSearchid.getText()+ " 님의  PC 이용시간이 5시간 추가 되었습니다."); 
						
			}
		
		
		
			else if(e.getActionCommand()=="10 \uC2DC\uAC04") {
				
				hours="10:00:00";
				AddtimeDAO dao= new AddtimeDAO();
				dao.GetAddtime(hours,textSearchid.getText());
				textShowaddtime.setText( textSearchid.getText()+ " 님의  PC 이용시간이 10시간 추가 되었습니다."); 
						
			}
		
		
		
		
		
			else if(e.getActionCommand()=="24 \uC2DC\uAC04") {
				
				hours="24:00:00";
				AddtimeDAO dao= new AddtimeDAO();
				dao.GetAddtime(hours,textSearchid.getText());
				textShowaddtime.setText( textSearchid.getText()+ " 님의  PC 이용시간이 24시간 추가 되었습니다."); 
						
			}
			
			
		}
		
		
		


}

