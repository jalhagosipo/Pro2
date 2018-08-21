package DB.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import DB.DBconn;
import DB.dto.MemberDTO;
import DB.dto.salesDTO;

public class MemberDAO {
	
		public Vector<MemberDTO>  selectAccount(String id) {
			
			Connection conn=null;
			PreparedStatement pstmt = null;
			DBconn dbconn = new DBconn();
			ResultSet rs;
			Vector<MemberDTO> arr = new Vector<>();
			
			try {
				conn = dbconn.getConnection();
				StringBuilder sql = new StringBuilder();
			
				if(id.trim().equals(""))
				{
					sql.append("  select member_id, member_name,total_price,CONCAT(hour(left_time),':',minute(left_time),':',second(left_time)) as 'left_time',phone_number");
					sql.append("  from mydb.pro2_member    ");
					pstmt = conn.prepareStatement(sql.toString());
				}
				else
				{
					sql.append("  select * ");
				  sql.append("  from mydb.pro2_member    ");
				   sql.append("  where member_id=?   ");
				   pstmt = conn.prepareStatement(sql.toString());
					pstmt.setString(1, id);
				}
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					MemberDTO dto=new MemberDTO(); 
					dto.setId(rs.getString("member_id"));
					dto.setName(rs.getString("member_name"));
					dto.setTotal_price(rs.getInt("total_price"));
					dto.setLeft_time(rs.getString("left_time"));
					dto.setPhonenum(rs.getString("phone_number"));
					arr.add(dto);
				}
				
			}catch(SQLException e){
				System.out.println(e);
			}
			return arr;
		}
	
		public void deleteAccount(String id) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			DBconn dbconn = new DBconn();
			
			try {
				conn = dbconn.getConnection();
				StringBuilder sql = new StringBuilder();

				sql.append(" delete from mydb.pro2_member ");
				sql.append(" where member_id= ?           ");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, id);
				
				int result = pstmt.executeUpdate();
				if(result>0)
				{
					System.out.println("삭제 성공");
					JOptionPane.showMessageDialog(null, "삭제 성공.");
				}
				else {
					System.out.println("삭제 실패");
				JOptionPane.showMessageDialog(null, "삭제 실패.");
				}
				
			}catch(SQLException e){
				System.out.println(e);
			}
		}
		
		public void updateAccount(String newId, String pw, String phone, String  name, String oldId ) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			DBconn dbconn = new DBconn();
			
			try {
				conn = dbconn.getConnection();
				StringBuilder sql = new StringBuilder();

				sql.append(" update mydb.pro2_member           ");
				sql.append("       set       member_id=?              ");
				sql.append("	      , member_pw=? 	                ");
				sql.append("          , phone_number=?             ");
				sql.append("          , member_name=?              ");
				sql.append("   where member_id=?               ");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, newId);
				pstmt.setString(2, pw);
				pstmt.setString(3, phone);
				pstmt.setString(4, name);
				pstmt.setString(5, oldId);
				
				int result = pstmt.executeUpdate();
				if(result>0)
				{
					System.out.println("수정 성공");
					JOptionPane.showMessageDialog(null, "수정 성공.");

					
				}
				else {
					System.out.println("수정 실패");
				JOptionPane.showMessageDialog(null, "수정 실패.");
				}
			}catch(SQLException e){
				System.out.println(e);
			}
		}
}
