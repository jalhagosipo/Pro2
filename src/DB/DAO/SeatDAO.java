package DB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBconn;
import client.clientInfo.infoDTO;

public class SeatDAO {
	private int[] time;

	public int[] GetTime(String id) {
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		DBconn dbconn = new DBconn();

		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" select hour(left_time)      ");
			sql.append("        ,minute(left_time)      ");
			sql.append("        ,second(left_time)      ");
			sql.append("    from mydb.pro2_member      ");
			sql.append("	where member_id= ?	");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);

			time=new int[3];
			rs = pstmt.executeQuery();
			while(rs.next())
			{ 
				time[0]=Integer.parseInt(rs.getString(1));
				time[1]=Integer.parseInt(rs.getString(2));
				time[2]=Integer.parseInt(rs.getString(3));
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return time;
	}
}
