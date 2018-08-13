package views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

public class MemberMnagerTest extends JFrame{

	//¡÷ºÆ√≥∏Æ: 0811_¿±∞«»Ò_∏ﬁ¿Œ∫‰øÕ ø¨∞·
//	private JFrame frame;
	public JFrame frame;
	private JTextField textField_Search;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MemberMnagerTest mm= new MemberMnagerTest();
		mm.frame.setVisible(true);
		
		//¡÷ºÆ√≥∏Æ: 0811_¿±∞«»Ò_∏ﬁ¿Œ∫‰øÕ ø¨∞·
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MemberMnagerTest window = new MemberMnagerTest();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
	}

	/**
	 * Create the application.
	 */
	//¡÷ºÆ√≥∏Æ: 0811_¿±∞«»Ò_∏ﬁ¿Œ∫‰øÕ ø¨∞·
//	public MemberMnagerTest() {
//		initialize();
//	}

	/**
	 * Initialize the contents of the frame.
	 */
	public MemberMnagerTest() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 0, 760, 98);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel MemberID = new JLabel("\uD68C\uC6D0 ID");
		MemberID.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		MemberID.setBounds(57, 49, 78, 22);
		panel.add(MemberID);
		
		textField_Search = new JTextField();
		textField_Search.setBounds(131, 46, 180, 29);
		panel.add(textField_Search);
		textField_Search.setColumns(10);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setBounds(353, 43, 109, 37);
		panel.add(btnSearch);
		
		JButton btnAllSearch = new JButton("\uC804\uCCB4 \uAC80\uC0C9");
		btnAllSearch.setBounds(565, 29, 127, 64);
		panel.add(btnAllSearch);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 442, 760, 109);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAdd = new JButton("\uCD94\uAC00");
		btnAdd.setBounds(59, 21, 133, 60);
		panel_2.add(btnAdd);
		
		JButton buttonUdate = new JButton("\uC218\uC815");
		buttonUdate.setBounds(256, 21, 133, 60);
		panel_2.add(buttonUdate);
		
		JButton buttonDelete = new JButton("\uC0AD\uC81C");
		buttonDelete.setBounds(453, 21, 133, 60);
		panel_2.add(buttonDelete);
		
		JButton buttonExit = new JButton("\uB2EB\uAE30");
		buttonExit.setBounds(637, 58, 111, 41);
		panel_2.add(buttonExit);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 102, 760, 351);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"\uD68C\uC6D0ID", "\uD68C\uC6D0 \uC774\uB984", "\uC0AC\uC6A9 \uC2DC\uAC04", "\uB0A8\uC740 \uC2DC\uAC04"
			}
		));
		scrollPane.setViewportView(table);
	}
}
