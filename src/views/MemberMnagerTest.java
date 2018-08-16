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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
		frame.setBounds(100, 100, 801, 604);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 96, 760, 326);
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
		
		JButton buttonExit = new JButton("\uB2EB\uAE30");
		buttonExit.setBounds(648, 484, 111, 41);
		buttonExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		frame.getContentPane().add(buttonExit);
		
		JLabel MemberID = new JLabel("\uD68C\uC6D0 ID");//∂Û∫ß
		MemberID.setBounds(54, 42, 78, 22);
		frame.getContentPane().add(MemberID);
		MemberID.setFont(new Font("±º∏≤", Font.PLAIN, 16));
		
		textField_Search = new JTextField();
		textField_Search.setBounds(152, 40, 180, 29);
		frame.getContentPane().add(textField_Search);
		textField_Search.setColumns(10);
		
		JButton btnSearch = new JButton("\uAC80\uC0C9");
		btnSearch.setBounds(427, 36, 109, 37);
		frame.getContentPane().add(btnSearch);
		
		JButton btnAllSearch = new JButton("\uC804\uCCB4 \uAC80\uC0C9");
		btnAllSearch.setBounds(602, 22, 127, 64);
		frame.getContentPane().add(btnAllSearch);
		
		JButton btnAdd = new JButton("\uCD94\uAC00");
		btnAdd.setBounds(54, 474, 133, 60);
		frame.getContentPane().add(btnAdd);
		
		JButton buttonUdate = new JButton("\uC218\uC815");
		buttonUdate.setBounds(262, 474, 133, 60);
		frame.getContentPane().add(buttonUdate);
		

		JButton buttonDelete = new JButton("\uC0AD\uC81C");
		buttonDelete.setBounds(450, 474, 133, 60);
		frame.getContentPane().add(buttonDelete);
	}
}
