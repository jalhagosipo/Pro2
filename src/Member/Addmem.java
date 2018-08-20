package Member;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.SignUpView;

public class Addmem implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SignUpView suv=new SignUpView();
		suv.setVisible(true);
		
	}

}
