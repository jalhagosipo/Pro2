package salesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import org.jfree.chart.ChartPanel;

import DB.dao.salesDAO;

public class yearSalesGraph  implements ActionListener{
	
ChartPanel chart;
	
	public yearSalesGraph(ChartPanel chart) {
		super();
		this.chart = chart;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] category= {"JAN","FEB","MAR","APR","MAY","JUN","JUL","AUG","SEP","OCT","NOV","DEC"};
		
		salesDAO dao = new salesDAO();
		Vector<Integer> money = dao.getSalesGraph("year");
		
		makeGraph mg = new makeGraph();
		chart.setChart(mg.getChart(money,category));
	}
}
