package Member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DB.DBconn;

public class MemberDel {
	
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
			else
				System.out.println("삭제 실패");
			JOptionPane.showMessageDialog(null, "삭제 실패.");
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
	}
}
