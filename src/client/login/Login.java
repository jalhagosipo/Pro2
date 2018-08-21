package client.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DB.DBconn;
import DB.DAO.MemberDAO;
import DB.DTO.MemberDTO;
import client.clientInfo.infoDAO;
import client.clientInfo.infoDTO;
import views.client.ClientInfoView;
import views.client.LoginView;
import views.server.Client;
import views.server.SeatView;

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
					
					Client ci= new Client(Integer.parseInt(num.getText())-1, id.getText());
					infoDAO infodao= new infoDAO();
					infoDTO dto= new infoDTO();
					dto= infodao.GetInfo(id.getText());
					ci.SetName(dto.getName());
					ci.SetTime(dto.getHour(), dto.getMinute(), dto.getSecond());
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
