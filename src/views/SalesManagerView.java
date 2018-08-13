package views;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartPanel;

import salesManager.makeGraph;
import salesManager.monthSalesGraph;
import salesManager.salesListShow;
import salesManager.weekSalesGraph;
import salesManager.yearSalesGraph;

public class SalesManagerView extends JFrame {

	private JPanel contentPane;
	private JTextField textField_from;
	private JTextField textField_to;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		SalesManagerView frame = new SalesManagerView();
		frame.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public SalesManagerView() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 800);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 10, 1184, 76);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_from = new JTextField();
		textField_from.setBounds(45, 36, 150, 27);
		textField_from.setText("YY-MM-DD");
		panel.add(textField_from);
		textField_from.setColumns(10);
		
		JLabel label = new JLabel("~");
		label.setBounds(207, 45, 17, 15);
		panel.add(label);
		
		textField_to = new JTextField();
		textField_to.setText("YY-MM-DD");
		textField_to.setBounds(228, 36, 150, 27);
		panel.add(textField_to);
		textField_to.setColumns(10);
		
		JButton search_button = new JButton("\uAC80\uC0C9");//검색
		search_button.setBounds(408, 28, 109, 43);
		panel.add(search_button);
	
		JButton week_sales_button = new JButton("\uC8FC\uAC04\uB9E4\uCD9C");//주간매출
		week_sales_button.setBounds(636, 28, 109, 43);
		panel.add(week_sales_button);
		
		JButton month_sales_button = new JButton("\uC6D4\uB9E4\uCD9C");//월매출
		month_sales_button.setBounds(802, 28, 109, 43);
		panel.add(month_sales_button);
		
		JButton year_sales_button = new JButton("\uC5F0\uB9E4\uCD9C");//연매출
		year_sales_button.setBounds(960, 28, 109, 43);
		panel.add(year_sales_button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 689, 1184, 62);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton close_button = new JButton("\uB2EB\uAE30");
		close_button.setBounds(1002, 10, 109, 43);
		panel_1.add(close_button);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 89, 1184, 601);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		DefaultTableModel model = new DefaultTableModel(new Object[]{"DATE","SALES"},0);
		
		JTable list = new JTable(model);
		JScrollPane scrollpane = new JScrollPane(list);
		scrollpane.setBounds(12, 10, 462, 561);
		panel_2.add(scrollpane);
		
		makeGraph mg = new makeGraph();
		Vector<Integer> a = new Vector<Integer>();
		a.add(0);
		ChartPanel chart = new ChartPanel(mg.getChart(a,new String[] {"0"}));
		chart.setBounds(500, 10, 672, 561);
		panel_2.add(chart);
		
		search_button.addActionListener(new salesListShow(textField_from,textField_to,list));
		week_sales_button.addActionListener(new weekSalesGraph(chart));
		month_sales_button.addActionListener(new monthSalesGraph());
		year_sales_button.addActionListener(new yearSalesGraph());
		
		close_button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});
	}
	
}
