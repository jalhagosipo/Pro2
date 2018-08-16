package Addtime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBconn;
import views.AddtimeView;

public class AddtimeDAO extends AddtimeView {
	
	
public void GetAddtime (String readid) {
		
		
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		DBconn dbconn = new DBconn();
		AddtimeDTO dto=new AddtimeDTO();

		try {
			conn = dbconn.getConnection();
			StringBuilder sb = new StringBuilder();

		
			
			sb.append("	update mydb.pro2_member									");
			sb.append("	set left_time = addtime(								");
			sb.append("								( select left_time from		");
			sb.append("	( select left_time from mydb.pro2_member where member_number=2) bringup )	");
			sb.append("								 , '01:00:00' )				");
			sb.append("	where member_id=?									");
		
		

			pstmt = conn.prepareStatement(sb.toString());
			
			pstmt.setString(1, readid);
			
			pstmt.executeUpdate();
			
		System.out.printf(" %s님의  PC 이용시간이 1시간 추가 되었습니다.",readid); 
		

			
		
			
						
			
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
	