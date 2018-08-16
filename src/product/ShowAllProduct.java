package product;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import DB.DBconn;

public class ShowAllProduct {
	public Vector<ProductDTO> getProductList(String pnum,String pname, int pprice, int pstock)
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<ProductDTO> arr = new Vector<>();
		DBconn dbconn = new DBconn();

		try {
			conn = dbconn.getConnection();
			StringBuilder sql = new StringBuilder();

			sql.append(" select * from mydb.pro2_snack ");
			pstmt = conn.prepareStatement(sql.toString());
			rs = pstmt.executeQuery();
			

		}catch(SQLException e) {
			System.out.println(e);
		}finally {
			if(rs!=null)try {rs.close();}catch(Exception e) {}
			dbconn.close(conn,pstmt);
		}

		return arr;
	
	}
}
public class ShowAllPro implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<String> str = new ArrayList<>();
		ShowAllProduct sap = new ShowAllProduct();
		Vector<ProductDTO> arr = sap.getProductList(pnum, pname, pprice, pstock);
		Iterator<ProductDTO> it = arr.iterator();
		Vector<>
	}
	
}
