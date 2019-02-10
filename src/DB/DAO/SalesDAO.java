package DB.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import DB.DBconn;
import DB.DTO.SalesDTO;

public class SalesDAO {

    public Vector<SalesDTO> getSalesList(String from,String to)
    {
        Connection conn = null;
        PreparedStatement pstmt =  null;
        ResultSet rs = null;
        Vector<SalesDTO> arr = new Vector<>();
        DBconn dbconn = new DBconn();

        try {
            conn = dbconn.getConnection();
            StringBuilder sql = new StringBuilder();

            sql.append(" select today_dates      ");
            sql.append("        ,today_sales      ");
            sql.append("    from mydb.pro2_salesStatus      ");
            sql.append("    where today_dates >= ?      ");
            sql.append("    and today_dates <= ?      ");

            pstmt = conn.prepareStatement(sql.toString());

            if(from.equals("") || from.equals("YY-MM-DD"))
            {
                pstmt.setString(1, "0");
            }
            else
            {
                pstmt.setString(1, from);
            }

            if(to.equals("YY-MM-DD")|| to.equals(""))
            {
                pstmt.setString(2, "curdate()");
            }
            else
            {
                pstmt.setString(2, to);
            }

            rs = pstmt.executeQuery();
            while(rs.next())
            {
                SalesDTO dto = new SalesDTO(); 
                dto.setToday_dates(rs.getString("today_dates"));
                dto.setToday_sales(rs.getInt("today_sales"));
                arr.add(dto);
            }

        }catch(SQLException e) {
            System.out.println(e);
        }finally {
            if(rs!=null)try {rs.close();}catch(Exception e) {}
            dbconn.close(conn,pstmt);
        }

        return arr;
    }

    public Vector<SalesDTO> getSalesGraph(String date)
    {
        Connection conn = null;
        PreparedStatement pstmt =  null;
        ResultSet rs = null;
        Vector<SalesDTO> arr = new Vector<>();
        DBconn dbconn = new DBconn();

        try {
            conn = dbconn.getConnection();
            StringBuilder sql = new StringBuilder();
            if(date.trim().equals("year"))
            {
                sql.append("    select DATE_FORMAT(today_dates,'%m') as \"today_dates\",sum(today_sales) as \"today_sales\"      ");
                sql.append("    from mydb.pro2_salesStatus                                                                       ");
                sql.append("    where DATE_FORMAT(today_dates,'%Y') = year(DATE_ADD(now(),INTERVAL -1 year))                     ");
                sql.append("    group by DATE_FORMAT(today_dates,'%m')                                                           ");

            }
            else {

                sql.append(" select today_dates,today_sales      ");
                sql.append("    from mydb.pro2_salesStatus      ");
                if(date.trim().equals("week"))
                {
                    sql.append("    WHERE YEARWEEK(today_dates) = YEARWEEK(CURRENT_DATE - INTERVAL 7 DAY)      ");
                }

                else //month
                {
                    sql.append("   where LAST_DAY(NOW() - interval 1 month)>= today_dates and LAST_DAY(NOW() - INTERVAL 2 MONTH) + INTERVAL 1 DAY<= today_dates      ");
                }
            }
            pstmt = conn.prepareStatement(sql.toString());

            rs = pstmt.executeQuery();
            while(rs.next())
            {
                SalesDTO dto = new SalesDTO(); 
                dto.setToday_dates(rs.getString("today_dates"));
                dto.setToday_sales(rs.getInt("today_sales"));
                arr.add(dto);
            }

        }catch(SQLException e) {
            System.out.println(e);
        }finally {
            if(rs!=null)try {rs.close();}catch(Exception e) {}
            dbconn.close(conn,pstmt);
        }

        return arr;
    }

}
