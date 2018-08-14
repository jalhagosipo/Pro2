package salesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import org.jfree.chart.ChartPanel;

import DB.dao.salesDAO;

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
		Vector<Integer> money = dao.getSalesGraph("week");
		
		makeGraph mg = new makeGraph();
		chart.setChart(mg.getChart(money,category));
	}

}
