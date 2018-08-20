package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import DB.DBconn;

public class UpdateProduct {
	
	public void updateProduct(String newName, String newPrice, int newStock, String oldName) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" update mydb.pro2_snack       ");
			sql.append("   set      product_name = ?  ");
			sql.append("	      , product_price = ? ");
			sql.append("          , stock=?           ");
			sql.append("   where product_name = ?   ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, newName);
			pstmt.setString(2, newPrice);
			pstmt.setInt(3, newStock);
			pstmt.setString(4, oldName);

			
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("수정 완료");
				JOptionPane.showMessageDialog(null, "수정 완료");
			}
			else
			{
				System.out.println("수정 실패");
				JOptionPane.showMessageDialog(null, "수정 완료");
			}
		}catch(SQLException e){
			System.out.println(e);
		}
	}

}
