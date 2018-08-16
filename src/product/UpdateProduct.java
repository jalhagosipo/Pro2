package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBconn;

public class UpdateProduct {
	
	public boolean updateAccount(ProductDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		boolean ok = false;
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" update mydb.pro2_snack       ");
			sql.append("   set     product_number = ? ");
			sql.append("          , product_name = ?  ");
			sql.append("	      , product_price = ? ");
			sql.append("          , stock=?           ");
			sql.append("   where product_number = ?   ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "product_number");
			pstmt.setString(2, "product_name");
			pstmt.setString(3, "product_price");
			pstmt.setString(4, "stock");
			pstmt.setString(5, "product_number");

			
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("수정 완료");
				ok=true;
			}
			else
				System.out.println("수정 실패");
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return ok;
	}

}
