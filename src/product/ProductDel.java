package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import DB.DBconn;

public class ProductDel {
	
	public void deleteProduct(String pronum) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		DBconn dbconn = new DBconn();
		
		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" delete from mydb.pro2_stock ");
			sql.append(" where product_number= ?     ");
			
			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, pronum);
			
			int result = pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("삭제 성공");
			}
			else
				System.out.println("삭제 실패");
			
			
		}catch(SQLException e){
			System.out.println(e);
		}
	}
}
