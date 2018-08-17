package views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Member.showschMember;

public class MemberMgr extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldsch;
	private JTable memlist;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberMgr frame = new MemberMgr();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MemberMgr() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\uD68C\uC6D0 ID");
		label.setFont(new Font("굴림", Font.PLAIN, 16));
		label.setBounds(54, 40, 78, 22);
		contentPane.add(label);
		
		textFieldsch = new JTextField();
		textFieldsch.setColumns(10);
		textFieldsch.setBounds(152, 38, 180, 29);
		contentPane.add(textFieldsch);
		
		JButton btnsch = new JButton("\uAC80\uC0C9"); //검색버튼
		
		btnsch.setBounds(427, 34, 109, 37);
		contentPane.add(btnsch);
		
		JTable memlist = new JTable();
		
		
		
		Object [] columns = {"회원ID","회원이름","총사용시간","남은시간","핸드폰"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		memlist.setModel(model);
		
		
       JScrollPane scrollPane = new JScrollPane(memlist);
		scrollPane.setBounds(12, 105, 760, 326);
		contentPane.add(scrollPane);
		
		
		scrollPane.setViewportView(memlist);
		
		JButton btnadd = new JButton("\uCD94\uAC00");//추가버튼
		btnadd.setBounds(54, 472, 133, 60);
		contentPane.add(btnadd);
		
		JButton btnudt = new JButton("\uC218\uC815");//수정버튼
		btnudt.setBounds(256, 472, 133, 60);
		contentPane.add(btnudt);
		
		JButton btndel = new JButton("\uC0AD\uC81C");//삭제버튼
		btndel.setBounds(450, 472, 133, 60);
		contentPane.add(btndel);
		
		JButton btnclose = new JButton("\uB2EB\uAE30");//닫기버튼
		btnclose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnclose.setBounds(648, 482, 111, 41);
		contentPane.add(btnclose);
		
		btnsch.addActionListener(new showschMember(textFieldsch,memlist));
	}
}
