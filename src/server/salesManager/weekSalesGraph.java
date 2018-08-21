package server.salesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Vector;

import org.jfree.chart.ChartPanel;

import DB.dao.salesDAO;
import DB.dto.salesDTO;

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
		
		salesDAO dao = new salesDAO();
		Vector<salesDTO> arr = dao.getSalesGraph("week");
		Iterator<salesDTO> it = arr.iterator();
		Vector<Integer> money= new Vector<>();
		while(it.hasNext())
			money.add(it.next().getToday_sales());
		
		
		makeGraph mg = new makeGraph();
		chart.setChart(mg.getChart(money,category));
	}

}
