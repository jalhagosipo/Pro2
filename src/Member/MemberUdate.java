package Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ClientInfo.infoDTO;
import DB.DBconn;

public class MemberUdate {
	
	public boolean updateAccount(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		boolean ok = false;
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" update mydb.pro2_member           ");
			sql.append("       set       member_id=?              ");
			sql.append("	      , member_pw=? 	                ");
			sql.append("          , phone_number=?             ");
			sql.append("          , member_name=?              ");
			sql.append("   where member_number=?               ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			pstmt.setString(1, "id");
			pstmt.setString(2, "pw");
			pstmt.setString(3, "phone_number");
			pstmt.setString(4, "name");
			pstmt.setString(5, "memnum");

			
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("수정 성공");
				ok=true;
			}
			else
				System.out.println("수정 실패");
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return ok;
	}

}
