package dbconn;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/*
 getSalesList() - 寃��깋踰꾪듉�쓣�닃���쓣�븣 from湲곌컙 遺��꽣 to湲곌컙 源뚯��쓽 �궇吏쒖� 留ㅼ텧�븸�쓣 select濡� 異붿텧. arraylist�삎�깭濡� 
*/
public class salesDAO {
	
	public Vector<salesDTO> getSalesList()
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
