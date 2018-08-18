package ClientInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBconn;

public class UpdateTimeDAO {
	public void UpdateTime(String id, String time) {
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		DBconn dbconn = new DBconn();

		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" update mydb.pro2_member  ");
			sql.append("   set                    ");
			sql.append("       left_time=?        ");
			sql.append("   where member_id=?      ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, time);
			pstmt.setString(2, id);
			
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("업데이트 성공");
			}
			else
				System.out.println("업데이트 실패");
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
	}
}
