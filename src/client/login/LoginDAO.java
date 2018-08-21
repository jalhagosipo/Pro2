package client.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import DB.DBconn;
import client.clientInfo.infoDTO;
public class LoginDAO {
	String name;
	String pw;
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
	public String GetPw(String id) {
		Connection conn = null;
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		DBconn dbconn = new DBconn();

		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" select member_pw      ");
			sql.append("    from mydb.pro2_member      ");
			sql.append("	where member_id= ?	");

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while(rs.next())
			{ 
				pw= rs.getString(1);
			}
		}catch(SQLException ex){
			System.out.println(ex.getMessage());
		}
		
		return pw;
	}
}
