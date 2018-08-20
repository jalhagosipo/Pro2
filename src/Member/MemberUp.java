package Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DB.DBconn;

public class MemberUp {
	public void updateAccount(String newId, String pw, String phone, String  name, String oldId ) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" update mydb.pro2_member           ");
			sql.append("       set       member_id=?              ");
			sql.append("	      , member_pw=? 	                ");
			sql.append("          , phone_number=?             ");
			sql.append("          , member_name=?              ");
			sql.append("   where member_id=?               ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, newId);
			pstmt.setString(2, pw);
			pstmt.setString(3, phone);
			pstmt.setString(4, name);
			pstmt.setString(5, oldId);
			
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("수정 성공");
				JOptionPane.showMessageDialog(null, "성공.");

				
			}
			else
				System.out.println("수정 실패");
			JOptionPane.showMessageDialog(null, "실패.");
			
		}catch(SQLException e){
			System.out.println(e);
		}
	}
}
