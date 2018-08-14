package ClientInfo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBconn;


public class infoDAO {
	
	public infoDTO GetInfo(String cur_id) {
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		DBconn dbconn = new DBconn();
		infoDTO dto=new infoDTO();

		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" select member_name      ");
			sql.append("        ,left_time      ");
			sql.append("    from mydb.pro2_member      ");
			sql.append("	where member_id= ?	");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, cur_id);

			rs = pstmt.executeQuery();
			while(rs.next())
			{ 
				dto.setName(rs.getString(1));
				dto.setLeftTime(rs.getString(2));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return dto;
	}
}
