package Addtime;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextArea;
import javax.swing.JTextField;

public  class Addtime implements ActionListener  {


	JTextField textSearchid;
	JTextArea textShowaddtime;
	String hours;
	
		
		public Addtime(JTextField textSearchid,JTextArea textShowaddtime) {
			this.textSearchid=textSearchid;
			this.textShowaddtime=textShowaddtime;
	
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			AddtimeDAO dao= new AddtimeDAO();
			
			
			if(e.getActionCommand()=="1 \uC2DC\uAC04") {
				
				hours="01:00:00";
				
				
				dao.GetAddtime(hours ,textSearchid.getText());
				textShowaddtime.setText( "["+textSearchid.getText()+ "] 님의  PC 이용시간이\n[1 시간] 추가 되었습니다."); 
						
			
			
			}
		
		
	
			else if(e.getActionCommand()=="2 \uC2DC\uAC04") {
				
				hours="02:00:00";
				
				dao.GetAddtime(hours,textSearchid.getText());
				textShowaddtime.setText("["+ textSearchid.getText()+ "] 님의  PC 이용시간이\n[2 시간] 추가 되었습니다."); 
						
				
			}
		
		
		
			else if(e.getActionCommand()=="3 \uC2DC\uAC04") {
				
				hours="03:00:00";
								
				dao.GetAddtime(hours, textSearchid.getText());
				textShowaddtime.setText("["+ textSearchid.getText()+ "] 님의  PC 이용시간이\n[3 시간] 추가 되었습니다."); 
						
			}
		
		
		
		
		
			else if(e.getActionCommand()=="5 \uC2DC\uAC04") {
				
				hours="05:00:00";
								
				dao.GetAddtime(hours,textSearchid.getText());
				textShowaddtime.setText("["+ textSearchid.getText()+ "] 님의  PC 이용시간이 [5 시간] 추가 되었습니다."); 
						
			}
		
		
		
			else if(e.getActionCommand()=="10 \uC2DC\uAC04") {
				
				hours="10:00:00";
				AddtimeDAO dao10= new AddtimeDAO();
				
				dao10.GetAddtime(hours,textSearchid.getText());
				textShowaddtime.setText("["+ textSearchid.getText()+ "] 님의  PC 이용시간이\n[10 시간] 추가 되었습니다."); 
				
			}
		
		
		
		
		
			else if(e.getActionCommand()=="24 \uC2DC\uAC04") {
				
				hours="24:00:00";
								
				dao.GetAddtime(hours,textSearchid.getText());
				textShowaddtime.setText("["+ textSearchid.getText()+ "] 님의  PC 이용시간이\n[24 시간] 추가 되었습니다."); 
				
			}
			
	
			
		}
		
		
		


}

