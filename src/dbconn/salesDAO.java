package dbconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class salesDAO {
	
	public ArrayList<salesDTO> getSalesList()
	{
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		ArrayList<salesDTO> arr = new ArrayList<>();
		DBconn dbconn = new DBconn();
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select today_dates      ");
			sql.append("        ,today_sales      ");
			sql.append("    from mydb.pro2_salesStatus      ");
//			sql.append("    where condition~~~~~~~~~~~~      ");
			
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();

			while(rs.next())
			{
				salesDTO dto = new salesDTO();
				dto.setToday_dates(rs.getString("today_dates"));
				dto.setToday_sales(rs.getInt("today_sales"));
				arr.add(dto);
			}
			
		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			dbconn.close(conn,pstmt);
		}
		
		return arr;
	}
	
}
