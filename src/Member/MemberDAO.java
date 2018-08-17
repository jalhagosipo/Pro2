package Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import DB.DBconn;
import DB.dto.salesDTO;

public class MemberDAO {
	
	public MemberDAO() {}
		public Vector<MemberDTO>  Member(String textFieldsch) {
			
			Connection conn=null;
			PreparedStatement pstmt = null;
			DBconn dbconn = new DBconn();
			ResultSet rs;
			Vector<MemberDTO> arr = new Vector<>();
			try {
				conn = dbconn.getConnection();
				StringBuilder sql = new StringBuilder();

				
				
				
				if(textFieldsch.trim().equals(""))
				{
					sql.append("  select * ");
					sql.append("  from mydb.pro2_member    ");
					pstmt = conn.prepareStatement(sql.toString());
				}
				else
				{
					sql.append("  select * ");
				  sql.append("  from mydb.pro2_member    ");
				   sql.append("  where member_id=?   ");
				   pstmt = conn.prepareStatement(sql.toString());
					pstmt.setString(1, textFieldsch);
				}
				
				/*sql.append("  select * ");
				sql.append("  from mydb.pro2_member    ");
				sql.append("  where member_id=?   ");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, textFieldsch);*/

				
				
				
				
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					MemberDTO dto=new MemberDTO(); 
					dto.setId(rs.getString("member_id"));
					dto.setName(rs.getString("member_name"));
					dto.setTotal_price(rs.getInt("total_price"));
					dto.setLeft_time(rs.getDate("left_time"));
					dto.setPhonenum(rs.getString("phone_number"));
					arr.add(dto);
				}
				
			}catch(SQLException e){
				System.out.println(e);
			}
			return arr;
		}
	

}
