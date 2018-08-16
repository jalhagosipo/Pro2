package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBconn;

public class DeleteProduct {
	
	public boolean deleteAccount(ProductDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		boolean ok = false;
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" delete from mydb.pro2_snack ");
			sql.append(" where product_number = ?    ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "product_number");
			
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("삭제 완료");
				ok=true;
			}
			else
				System.out.println("삭제 실패");
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return ok;
	}
}
