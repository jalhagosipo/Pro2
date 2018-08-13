package ClientInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dbconn.DBconn;

public class SignUp{
	
	public boolean insertAccount(infoDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		boolean ok = false;
		
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
			pstmt.setString(1, "id");
			pstmt.setString(2, "pw");
			pstmt.setString(3, "phone_number");
			pstmt.setString(4, "name");
			
			int result = pstmt.executeUpdate();
			if(result>1)
			{
				System.out.println("가입 성공");
				ok=true;
			}
			else
				System.out.println("가입 실패");
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return ok;
	}
	
}
