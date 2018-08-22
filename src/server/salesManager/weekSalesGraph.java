package server.salesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import org.jfree.chart.ChartPanel;

import DB.DAO.SalesDAO;
import DB.DTO.SalesDTO;

public class weekSalesGraph implements ActionListener{

	ChartPanel chart;
	
	public weekSalesGraph(ChartPanel chart) {
		super();
		this.chart = chart;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] category= {"SUN","MON","TUE","WED","THU","FRI","SAT"};
		
		SalesDAO dao = new SalesDAO();
		Vector<SalesDTO> arr = dao.getSalesGraph("week");
		Iterator<SalesDTO> it = arr.iterator();
		Vector<Integer> money= new Vector<>();
		while(it.hasNext())
			money.add(it.next().getToday_sales());
		
		
		makeGraph mg = new makeGraph();
		chart.setChart(mg.getChart(money,category));
	}

}
