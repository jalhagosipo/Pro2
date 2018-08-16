package Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBconn;

public class MemberDel {
	
	public boolean deleteAccount(MemberDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		boolean ok = false;
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" delete from mydb.pro2_member ");
			sql.append(" where member_id= ?           ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getId());
			
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("삭제 성공");
				ok=true;
			}
			else
				System.out.println("삭제 실패");
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return ok;
	}
}
