package Login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ClientInfo.infoDTO;
import dbconn.DBconn;
public class LoginDAO {
	String name;

	public String CheckMember(String id) {
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		DBconn dbconn = new DBconn();

		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" select member_id      ");
			sql.append("    from mydb.pro2_member      ");
			sql.append("	where member_id= ?	");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{ 
				name= rs.getString(1);
			}
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		return name;
	}
}