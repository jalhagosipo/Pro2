package product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import DB.DBconn;

public class ProductDAO {
	
	public ProductDAO() {}
		public Vector<ProductDTO>  Product(String textField) {
			
			Connection conn=null;
			PreparedStatement pstmt = null;
			DBconn dbconn = new DBconn();
			ResultSet rs2;
			Vector<ProductDTO> arr2 = new Vector<>();
			try {
				conn = dbconn.getConnection();
				StringBuilder sql = new StringBuilder();

				
				
				
				if(textField.trim().equals(""))
				{
					sql.append("  select * ");
					sql.append("  from mydb.pro2_snack    ");
					pstmt = conn.prepareStatement(sql.toString());
				}
				else
				{
					sql.append("  select * ");
				  sql.append("  from mydb.pro2_snack    ");
				   sql.append("  where product_name like ?   ");
				   pstmt = conn.prepareStatement(sql.toString());
					pstmt.setString(1, "%"+textField+"%");
				}
				
				/*sql.append("  select * ");
				sql.append("  from mydb.pro2_member    ");
				sql.append("  where member_id=?   ");
				
				pstmt = conn.prepareStatement(sql.toString());
				pstmt.setString(1, textFieldsch);*/

				
				
				
				
				
				rs2 = pstmt.executeQuery();
				
				while(rs2.next())
				{
					ProductDTO dto=new ProductDTO(); 
					dto.setProNumber(rs2.getInt("product_number"));
					dto.setProName(rs2.getString("product_name"));
					dto.setProPrice(rs2.getString("product_price"));
					dto.setProStock(rs2.getInt("stock"));
					arr2.add(dto);
				}
				
			}catch(SQLException e){
				System.out.println(e);
			}
			return arr2;
		}
	

}
