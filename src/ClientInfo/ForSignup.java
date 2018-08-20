package ClientInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import views.SignUpView;


public class ForSignup implements ActionListener {

	private JTextField textField_phone;
	private JTextField textField_pwd;
	private JTextField textField_id;
	private JTextField textField_name;
	private SignUpView suv ;
	
	
	
	public ForSignup(SignUpView suv , JTextField textField_name,JTextField textField_id, JTextField textField_pwd, JTextField textField_phone
			) {
	
		this.suv=suv;
		this.textField_phone = textField_phone;
		this.textField_pwd = textField_pwd;
		this.textField_id = textField_id;
		this.textField_name = textField_name;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		SignUpDTO dto = new SignUpDTO(textField_name.getText().trim(), textField_id.getText().trim(), textField_pwd.getText().trim(), textField_phone.getText().trim());
		SignUpDAO dao = new SignUpDAO();
		
		boolean result = dao.insertAccount(dto);
		if(result)
		{
			JOptionPane.showMessageDialog(null, "회원가입이완료되었습니다.");
			suv.dispose();
		}
		
	}

}
