package DB.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import DB.DBconn;
import DB.dto.salesDTO;

/*
 getSalesList() - ?ç∞?ù¥?Ñ∞ ?ùΩ?ñ¥?Ñú vector?òï?ÉúÎ°? Î¶¨ÌÑ¥
 */
public class salesDAO {

	public Vector<salesDTO> getSalesList(String from,String to)
	{
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		Vector<salesDTO> arr = new Vector<>();
		DBconn dbconn = new DBconn();

		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" select today_dates      ");
			sql.append("        ,today_sales      ");
			sql.append("    from mydb.pro2_salesStatus      ");
			sql.append("    where today_dates >= ?      ");
			sql.append("    and today_dates <= ?      ");
			
			pstmt = conn.prepareStatement(sql.toString());
			
			if(from.equals("") || from.equals("YY-MM-DD"))
			{
				pstmt.setString(1, "0");
			}
			else
			{
				pstmt.setString(1, from);
			}
			
			if(to.equals("YY-MM-DD")|| to.equals(""))
			{
				pstmt.setString(2, "curdate()");
			}
			else
			{
				pstmt.setString(2, to);
			}
			
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
	
	public Vector<Integer> getSalesGraph(String date)
	{
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		Vector<Integer> arr = new Vector<>();
		DBconn dbconn = new DBconn();

		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" select today_sales      ");
			sql.append("    from mydb.pro2_salesStatus      ");
			if(date.trim().equals("week"))
			{
				sql.append("    WHERE YEARWEEK(today_dates) = YEARWEEK(CURRENT_DATE - INTERVAL 7 DAY);      ");
			}
			else if(date.trim().equals("year"))
			{
//				sql.append("    WHERE YEARWEEK(today_dates) = YEARWEEK(CURRENT_DATE - INTERVAL 7 DAY);      ");
			}
			else //month
			{
//				sql.append("    WHERE YEARWEEK(today_dates) = YEARWEEK(CURRENT_DATE - INTERVAL 7 DAY);      ");
			}
			
			pstmt = conn.prepareStatement(sql.toString());
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{
				arr.add(rs.getInt("today_sales"));
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
