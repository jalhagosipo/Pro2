package server.salesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.jfree.chart.ChartPanel;

import DB.DAO.SalesDAO;
import DB.DTO.SalesDTO;

public class SalesGraphShow  implements ActionListener{

	ChartPanel chart;
	String type; // 일,월,연매출인지 나타내는 변수
	
	public SalesGraphShow(ChartPanel chart,String type) {
		super();
		this.chart = chart;
		this.type=type;
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		SalesDAO dao = new SalesDAO();
		Vector<SalesDTO> arr = dao.getSalesGraph(type);
		Iterator<SalesDTO> it = arr.iterator();
		Vector<Integer> money= new Vector<>();
		String[] category =null;
		
		
		if(type.equals("month")) {
		    ArrayList<String> str = new ArrayList<>();
	        while(it.hasNext())
	            {
	                SalesDTO dto = it.next();
	                money.add(dto.getToday_sales());
	                str.add(dto.getToday_dates().substring(8, 10));
	            }
	        
	        category = new String[str.size()];
	        for(int i=0;i<str.size();i++)
	            category[i] = str.get(i);
	        
		}else {
		    while(it.hasNext())
	            money.add(it.next().getToday_sales());
		    
		    if(type.equals("week")) {
		        category=  new String[]{"SUN","MON","TUE","WED","THU","FRI","SAT"};
		    }else {
		        category= new String[]{"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};       
		    }
		}
		
		MakeGraph mg = new MakeGraph();
		chart.setChart(mg.getChart(money,category));
	}
}
