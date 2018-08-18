package snackChoose;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import ClientInfo.UpdateTimeDAO;
import views.ChooseSnackView;
import views.Client;

public class buysnack implements ActionListener{
	Client ci;
	ChooseSnackView csv;
	JTable table;
	JTextField tf_lefttime;
	JTextField tf_id;
	DefaultTableModel tm;
	
	int lh=0;
	int lm=0;
	int ls=0;
	int have_m=0;
	public buysnack(Client c, ChooseSnackView csv, JTable table,JTextField tf_id,JTextField tf_lefttime){
		this.ci=c;
		this.csv=csv;
		this.table=table;
		this.tf_id = tf_id;
		this.tf_lefttime = tf_lefttime;
		tm = (DefaultTableModel) table.getModel();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String[] str=tf_lefttime.getText().split(":");
		//클라이언트의 남은시간JtextField 값을 가져와 ':'으로 split해 시간과 분을 구한다. 나온값을 통해 모든 시간을 분으로 환산한다.
		lh=Integer.parseInt(str[0].trim());
		lm=Integer.parseInt(str[1].trim());
		have_m=(lh*60)+lm;
		
		
		int row = tm.getRowCount();
		int total=0;
		for(int i = 0; i < row; i++) {
			int m= Integer.parseInt(tm.getValueAt(i, 1).toString().substring(3, 5));
			int cnt= Integer.parseInt(tm.getValueAt(i, 2).toString());
			total+=m*cnt;
		}
		
		//연결된 클라이언트의 시간을 분으로 환산한것과 선택한 항목의 총액을 비교해서 클라이언트의 시간이 많을때 실행.
		if(have_m>total) {
			have_m-=total;
			int h=have_m/60;
			int m=have_m%60;
			
			ci.setLh(h);
			ci.setLm(m);
		}
		String time= ci.getLh()+ ":" + ci.getLm() + ":" + ci.getLs();
		UpdateTimeDAO dao=new UpdateTimeDAO();
		dao.UpdateTime(tf_id.getText(), time);
		
		row = tm.getRowCount();
		
		for(int i=0;i<row;i++)
			tm.removeRow(0);
		csv.dispose();
	}
	
}
