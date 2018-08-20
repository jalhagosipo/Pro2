package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import DB.DBconn;

public class SelectProduct {
	
		
		public Vector<ProductDTO> SelectPro() {
			Connection conn = null;
			PreparedStatement pstmt = null;
			DBconn dbconn = new DBconn();
			ResultSet rs;
			Vector<ProductDTO> arr = new Vector<>();
			
			try {
				conn = dbconn.getConnection();
				StringBuilder sql = new StringBuilder();

				sql.append("  select product_name, product_price, stock ");
				sql.append("  from mydb.pro2_snack    ");
				
				pstmt = conn.prepareStatement(sql.toString());

				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					ProductDTO dto = new ProductDTO(); 
					dto.setProName(rs.getString("product_name"));
					dto.setProPrice(rs.getString("product_price"));
					dto.setProStock(rs.getInt("stock"));
					arr.add(dto);
				}
				
			}catch(SQLException e){
				System.out.println(e);
			}
			return arr;
		}
	

}
