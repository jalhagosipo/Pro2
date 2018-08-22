package server.salesManager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import org.jfree.chart.ChartPanel;

import DB.DAO.SalesDAO;
import DB.DTO.SalesDTO;

public class monthSalesGraph  implements ActionListener{

	ChartPanel chart;
	
	public monthSalesGraph(ChartPanel chart) {
		super();
		this.chart = chart;
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		ArrayList<String> str = new ArrayList<>();
		
		SalesDAO dao = new SalesDAO();
		Vector<SalesDTO> arr = dao.getSalesGraph("month");
		Iterator<SalesDTO> it = arr.iterator();
		Vector<Integer> money= new Vector<>();
		
		while(it.hasNext())
			{
				SalesDTO dto = it.next();
				money.add(dto.getToday_sales());
				str.add(dto.getToday_dates().substring(8, 10));
			}
		
		String[] category = new String[str.size()];
		for(int i=0;i<str.size();i++)
		{
			category[i] = str.get(i);
		}
		
		makeGraph mg = new makeGraph();
		chart.setChart(mg.getChart(money,category));
	}
}
