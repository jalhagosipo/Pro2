package salesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.jfree.chart.ChartPanel;

import dbconn.salesDAO;

public class weekSalesGraph implements ActionListener{

	ChartPanel chart;
	
	public weekSalesGraph(ChartPanel chart) {
		super();
		this.chart = chart;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String[] category= {"MON","TUE","WED","THU","FRI","SAT","SUN"};
		
		salesDAO dao = new salesDAO();
		dao.getSalesGraph();
		
		makeGraph mg = new makeGraph();
		chart = new ChartPanel(mg.getChart());
	}

}
