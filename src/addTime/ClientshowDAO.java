package addTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBconn;
import views.AddtimeView;

public class ClientshowDAO{	
	public ClientshowDTO GetShow(String readtxt) {
		
		
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		DBconn dbconn = new DBconn();
		ClientshowDTO dto=new ClientshowDTO();

		try {
			conn = dbconn.getConnection();
			StringBuilder sb = new StringBuilder();

			sb.append("	select member_name			");
			sb.append("	from mydb.pro2_member		");
			sb.append("	where member_id= ?			");

			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, readtxt);
			
			rs = pstmt.executeQuery();
			while(rs.next())
			{ 
				dto.setMember_name(rs.getString(1));
			}
			
			
		
			
						
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		return dto;
	}
}
	
	
