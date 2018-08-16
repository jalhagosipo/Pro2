package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBconn;

public class AddProduct{
	
	public boolean insertProduct(ProductDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		boolean ok = false;
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();
			sql.append(" insert into mydb.snack       ");
			sql.append("           (product_name      ");
			sql.append("          , product_price     ");
			sql.append("	      , stock)            ");
			sql.append("    values (?, ?, ?);         ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, dto.getProName());
			pstmt.setInt(2, dto.getProPrice());
			pstmt.setInt(3, dto.getProStock());
			
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("추가 완료");
				ok=true;
			}
			else
				System.out.println("추가 실패");
			
		}catch(SQLException e){
			System.out.println(e);
		}
		return ok;
	}
	
}
