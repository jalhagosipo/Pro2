package ClientInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBconn;

public class SignUp{
	
	public boolean insertAccount(SignUpDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		boolean ok = false;
		SignUpDTO su = new SignUpDTO();
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" insert into mydb.pro2_member ");
			sql.append("           (member_id         ");
			sql.append("          , member_pw         ");
			sql.append("	      , phone_number	  ");
			sql.append("          , member_name)      ");
			sql.append("    values (?, ?, ?, ?);      ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, su.getId());
			pstmt.setString(2, su.getPw());
			pstmt.setString(3, su.getPhno());
			pstmt.setString(4, su.getName());
			
			int result = pstmt.executeUpdate();
			if(result>1)
			{
				System.out.println("���� ����");
				ok=true;
			}
			else
				System.out.println("���� ����");
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return ok;
	}
	
}
