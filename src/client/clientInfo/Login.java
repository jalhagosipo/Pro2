package client.clientInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DB.DAO.MemberDAO;
import DB.DTO.MemberDTO;
import views.client.Client;
import views.client.LoginView;

public class Login implements ActionListener{
	LoginView view;
	JTextField id;
	JTextField pw;
	JTextField num;
	public Login(LoginView view, JTextField id, JTextField pw, JTextField num) {
		this.view=view;
		this.id=id;
		this.pw=pw;
		this.num=num;
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand()=="로그인") {
			MemberDAO dao=new MemberDAO();
			
			Vector<MemberDTO> memdto = dao.selectAccount(id.getText());

			if(memdto.size()<1) {
				JOptionPane.showMessageDialog(null, "아이디 없음.");
				id.setText("");
				pw.setText("");
			}else{
				
				String getpw=memdto.get(0).getPw();
				
				if(getpw.equals(pw.getText())) {
					infoDAO infodao= new infoDAO();
					infoDTO dto= new infoDTO();
					dto= infodao.GetInfo(id.getText());
					Client ci= new Client(Integer.parseInt(num.getText())-1, id.getText());
					ci.SetName(dto.getName());
					view.dispose();	
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호 틀림.");
					id.setText("");
					pw.setText("");
				}
			}

		}
	}

}
