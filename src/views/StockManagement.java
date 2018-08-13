<<<<<<< HEAD
=======
package views;

>>>>>>> branch 'master' of https://github.com/carryyun/Pro2.git



import java.awt.Color;

import java.awt.EventQueue;




import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JTable;

import javax.swing.JTextField;

import javax.swing.border.EmptyBorder;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;




public class StockManagement extends JFrame {




 private JPanel contentPane;

 private JTextField textField_search;
 private JTable table;

 /**

  * Launch the application.

  */

 public static void main(String[] args) {
	 StockManagement sm=new StockManagement();
	 sm.setVisible(true);
	 //주석처리: 0811_윤건희_메인뷰와 연결
//  EventQueue.invokeLater(new Runnable() {
//
//   public void run() {
/////
//    try {
//
//     StockManagement frame = new StockManagement();
//
//     frame.setVisible(true);
//
//    } catch (Exception e) {
//
//     e.printStackTrace();
//
//    }
//
//   }
//
//  });

 }




 /**

  * Create the frame.

  */

 public StockManagement() {

  setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

  setBounds(100, 100, 800, 600);

  contentPane = new JPanel();

  contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

  setContentPane(contentPane);

  contentPane.setLayout(null);

  

  JPanel botpan = new JPanel();

  botpan.setBounds(0, 0, 800, 39);

  contentPane.add(botpan);

  botpan.setLayout(null);

  

  JLabel label_product = new JLabel("상품명");

  label_product.setBounds(27, 14, 41, 16);

  botpan.add(label_product);

  

  textField_search = new JTextField();

  textField_search.setBounds(80, 10, 339, 26);

  botpan.add(textField_search);

  textField_search.setColumns(10);

  

  JButton button_search = new JButton("寃��깋");

  button_search.setBounds(434, 9, 75, 29);

  botpan.add(button_search);

  

  JButton button_all = new JButton("�쟾泥� 議고쉶");

  button_all.setBounds(566, 8, 181, 29);

  botpan.add(button_all);

  

  JPanel headpan = new JPanel();

  headpan.setBounds(0, 503, 800, 48);

  contentPane.add(headpan);

  headpan.setLayout(null);

  

  JButton button_add = new JButton("�긽�뭹 異붽�");

  button_add.setBounds(28, 0, 117, 29);

  headpan.add(button_add);

  

  JButton button_del = new JButton("�긽�뭹 �궘�젣");

  button_del.setBounds(159, 0, 117, 29);

  headpan.add(button_del);

  

  JButton button_update = new JButton("�긽�뭹 �닔�젙");

  button_update.setBounds(567, 0, 181, 29);

  headpan.add(button_update);
  
  JScrollPane scrollPane = new JScrollPane();
  scrollPane.setBounds(31, 49, 724, 425);
  contentPane.add(scrollPane);
  
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
    "상품코드", "상품명", "가격", "재고"
   }
  ));
  scrollPane.setViewportView(table);

 }
}