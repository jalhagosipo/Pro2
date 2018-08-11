package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBconn {

	private Connection getConnection()
	{
		String className="com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://my5509.gabiadb.com:3306/mydb";  
		String user = "bit504";  		//mysql 아이디
		String password = "bitcamp504*";//비밀번호
		Connection conn = null;
		
		try {
			Class.forName(className);
			conn = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return conn;
	}
	public ArrayList<salesDTO> getSalesList()
	{
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		ArrayList<salesDTO> arr = new ArrayList<>();
		try {
			conn = getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" select today_dates      ");
			sql.append("        ,today_sales      ");
			sql.append("    from mydb.pro2_salesStatus      ");

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
			close(conn,pstmt);
		}
		
		return arr;
	}
	
	private void close(Connection conn,PreparedStatement pstmt)
	{
		if(conn!=null)try {conn.close();}catch(Exception e) {}
		if(pstmt!=null)try {pstmt.close();}catch(Exception e) {}
	}
}
