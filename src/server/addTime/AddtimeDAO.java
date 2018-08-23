package server.addTime;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.JTextField;

import DB.DBconn;

public class AddtimeDAO{
	private JTextField textSearchid;
	private JTextArea textShowaddtime;
	public AddtimeDAO(JTextField textSearchid, JTextArea textShowaddtime) {
		this.textSearchid=textSearchid;
		this.textShowaddtime=textShowaddtime;
	}
	Connection conn = null;
	PreparedStatement pstmt =  null;
	DBconn dbconn = new DBconn();

	public void GetAddtime (String hours,String readid) {

		try {
			conn = dbconn.getConnection();
			StringBuilder sb = new StringBuilder();

			sb.append("	update mydb.pro2_member									");
			sb.append("	set left_time = addtime(								");
			sb.append("								( select left_time from		");
			sb.append("	( select left_time from mydb.pro2_member where member_id=?) bringup )	");
			sb.append("								 , ? )						");
			sb.append("	where member_id=?										");

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, readid);
			pstmt.setString(2, hours);

			pstmt.setString(3, readid);

			pstmt.executeUpdate();

		}catch(SQLException e) {
			System.out.println(e.getMessage());
		}finally {
			dbconn.close(conn,pstmt);
		}
	}
	//pstmt.clearParameters();
	public void GetChargetime (String hours,String readid) {
		try {
			conn = dbconn.getConnection();
			StringBuilder sb = new StringBuilder();



			sb.append("	insert into mydb.pro2_chargeIn					");
			sb.append("	values (null,?,now(),							");
			sb.append("	 		(select member_number from mydb.pro2_member where member_id=?));				");



			// 		delete from mydb.pro2_chargeIn where in_index= 1

			pstmt = conn.prepareStatement(sb.toString());

			pstmt.setString(1, hours);
			pstmt.setString(2, readid);

			pstmt.executeUpdate();

		}catch(SQLException e) {
			
			textShowaddtime.setText("ID 를 확인해주세요\n["+ textSearchid.getText()+ "] 는 등록되지 않은 ID 입니다");
			System.out.println(e.getMessage());
		}finally {
			dbconn.close(conn,pstmt);
		}
	}
}
