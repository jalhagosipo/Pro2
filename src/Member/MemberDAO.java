package Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import DB.DBconn;

public class MemberDAO {
	
	
		public Vector<MemberDTO> Member() {
			Connection conn=null;
			PreparedStatement pstmt = null;
			DBconn dbconn = new DBconn();
			ResultSet rs;
			Vector<MemberDTO> arr = new Vector<>();
			MemberDTO dto=new MemberDTO(0, null, null, null, null, null, 0);
			
			try {
				conn = dbconn.getConnection();
				StringBuilder sql = new StringBuilder();

				sql.append("  select * ");
				sql.append("  from mydb.pro2_member    ");
				
				pstmt = conn.prepareStatement(sql.toString());

				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					
					dto.setId(rs.getString(1));
					dto.setName(rs.getString(2));
					dto.setTotal_price(rs.getInt(3));
					dto.setLeft_time(rs.getDate(4));
					dto.setPhonenum(rs.getString(5));
					arr.add(dto);
				}
				
			}catch(SQLException e){
				System.out.println(e);
			}
			return arr;
		}
	

}
