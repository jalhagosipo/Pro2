package DB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;

import DB.DBconn;
import DB.DTO.ProductDTO;

public class ProductDAO {

    public Vector<ProductDTO>  Product(String textField) {
        Connection conn=null;
        PreparedStatement pstmt = null;
        DBconn dbconn = new DBconn();
        
        System.out.println("dbconn: "+dbconn);
        
        ResultSet rs2=null;
        Vector<ProductDTO> arr2 = new Vector<>();
        try {
            conn = dbconn.getConnection();
            StringBuilder sql = new StringBuilder();
            if(textField.trim().equals(""))
            {
                sql.append("  select product_name, product_price, stock ");
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

            rs2 = pstmt.executeQuery();

            while(rs2.next())
            {
                ProductDTO dto=new ProductDTO(); 
                dto.setProName(rs2.getString("product_name"));
                dto.setProPrice(rs2.getString("product_price"));
                dto.setProStock(rs2.getInt("stock"));
                arr2.add(dto);
            }

        }catch(SQLException e){
            System.out.println(e);
        }finally {
            if(rs2!=null)try {rs2.close();}catch(Exception e) {}
            dbconn.close(conn,pstmt);
        }
        return arr2;
    }

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
        }finally {
            dbconn.close(conn,pstmt);
        }
    }

    public void deleteProduct(String proName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        DBconn dbconn = new DBconn();

        try {
            conn = dbconn.getConnection();
            StringBuilder sql = new StringBuilder();

            sql.append(" delete from mydb.pro2_snack ");
            sql.append(" where product_name= ?     ");

            pstmt = conn.prepareStatement(sql.toString());
            pstmt.setString(1, proName);

            int result = pstmt.executeUpdate();
            if(result>0)
            {
                System.out.println("삭제 완료");
                JOptionPane.showMessageDialog(null, "삭제 완료");
            }
            else
            {
                System.out.println("삭제 실패");
                JOptionPane.showMessageDialog(null, "삭제 실패");
            }

        }catch(SQLException e){
            System.out.println(e);
        }finally {
            dbconn.close(conn,pstmt);
        }
    }

    public int updateProduct(String newName, String newPrice, int newStock, String oldName) {
        Connection conn = null;
        PreparedStatement pstmt = null;
        DBconn dbconn = new DBconn();
        int result=0;

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


            result = pstmt.executeUpdate();

        }catch(SQLException e){
            System.out.println(e);
        }finally {
            dbconn.close(conn,pstmt);
        }
        return result;
    }
}
