package server.product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DB.DBconn;

public class AddProduct{
	
	public void insertProduct(String proName, String proPrice, int proStock) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into mydb.pro2_snack  ");
			sql.append("           (product_name      ");
			sql.append("          , product_price     ");
			sql.append("	      , stock)            ");
			sql.append("    values (?, ?, ?);         ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, proName);
			pstmt.setString(2, proPrice);
			pstmt.setInt(3, proStock);
			
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("추가 완료");
				JOptionPane.showMessageDialog(null, "추가 완료");

			}
			else
			{
				System.out.println("추가 실패");
				JOptionPane.showMessageDialog(null, "추가 실패");
			}
		}catch(SQLException e){
			System.out.println(e);
		}
	}
	
}
