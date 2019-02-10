package views.server;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import server.Main_GUI_Event;
import server.Seat;
import server.SeatThread;

public class SeatView extends JFrame{
    JFrame jf_main;			// 메인프레임
    JPanel pan_main_seat;	//전체 좌석 패널
    JPanel[] pan_seat;		//좌석1칸씩 묶어줄 패널
    JPanel[] pan_left;		//좌석의 왼쪽 항목들의 JLabel을 묶어줄 패널
    JPanel[] pan_right;		//좌석의 오른쪽 값들의 JLabel을 묶어줄 패널

    JLabel[] lb_time;		//남은시간을 알려줄 라벨
    JLabel[] lb_cur_time;	//사용시간을 알려줄 라벨
    JLabel[] lb_id; 		//현재 로그인한 아이디를 알려줄 라벨

    JLabel[] lb_time_value;		//남은시간을 알려줄 라벨
    JLabel[] lb_cur_time_value;	//사용시간을 알려줄 라벨
    JLabel[] lb_id_value;		//현재 로그인한 아이디를 알려줄 라벨

    private Socket socket;
    private Seat[] SaveSeat;

    public SeatView(){
        //전체 좌석수를 한번에 조절하기 위한 MAX상수
        final int MAX=20;
        jf_main=new JFrame("PC방");
        jf_main.setLayout(new BorderLayout(10,20));
        //JPanel
        pan_main_seat=new JPanel();
        pan_main_seat.setLayout(new GridLayout(4, 5, 30, 50));
        pan_seat=new JPanel[MAX];
        pan_left=new JPanel[MAX];
        pan_right=new JPanel[MAX];
        //JLabel
        lb_time=new JLabel[MAX];
        lb_cur_time=new JLabel[MAX];
        lb_id=new JLabel[MAX];
        lb_time_value=new JLabel[MAX];
        lb_cur_time_value=new JLabel[MAX];
        lb_id_value=new JLabel[MAX];

        //여러 컴포넌트를 묶어 좌석을 1칸 단위로 추가하기위한 패널.
        for(int i=0;i<MAX;i++) {
            pan_seat[i]=new JPanel();
            pan_seat[i].setLayout(new GridLayout(1, 2));
            pan_seat[i].setBackground(Color.GRAY);
            pan_seat[i].setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
            pan_seat[i].setBorder(new TitledBorder(new LineBorder(Color.white,4), (i+1)+" PC"));

            pan_left[i]=new JPanel();
            pan_right[i]=new JPanel();
            pan_left[i].setBackground(Color.GRAY);
            pan_right[i].setBackground(Color.GRAY);
            pan_left[i].setLayout(new BoxLayout(pan_left[i],BoxLayout.Y_AXIS));
            pan_right[i].setLayout(new BoxLayout(pan_right[i],BoxLayout.Y_AXIS));

            lb_time[i]=new JLabel("남은시간:");
            lb_cur_time[i]=new JLabel("사용시간:");
            lb_id[i] = new JLabel("아이디:");
            lb_time_value[i]=new JLabel(" ");
            lb_cur_time_value[i]=new JLabel(" ");
            lb_id_value[i] = new JLabel("");
            lb_time_value[i].setForeground(Color.white);
            lb_cur_time_value[i].setForeground(Color.white);
            lb_id_value[i].setForeground(Color.white);

            pan_left[i].add(lb_time[i]);
            pan_left[i].add(lb_cur_time[i]);
            pan_left[i].add(lb_id[i]);
            pan_right[i].add(lb_time_value[i]);
            pan_right[i].add(lb_cur_time_value[i]);
            pan_right[i].add(lb_id_value[i]);

            pan_seat[i].add(pan_left[i]);
            pan_seat[i].add(pan_right[i]);
            pan_main_seat.add(pan_seat[i]);
        }
        jf_main.add(pan_main_seat,BorderLayout.CENTER);//좌석패널을 CENTER에 추가

        //오른쪽 버튼메뉴들를 위한 GridLayout
        JPanel pan_btn = new JPanel();
        pan_btn.setLayout(new GridLayout(7, 1));

        //각 버튼에 사용될 리스너 생성
        Main_GUI_Event env = new  Main_GUI_Event(this);

        JButton btn1 =new JButton("매출현황");
        btn1.addActionListener(env);
        JButton btn2 =new JButton("재고관리");
        btn2.addActionListener(env);
        JButton btn3 =new JButton("충전");
        btn3.addActionListener(env);
        JButton btn4 =new JButton("회원관리");
        btn4.addActionListener(env);

        pan_btn.add(btn1);
        pan_btn.add(new JLabel(""));
        pan_btn.add(btn2);
        pan_btn.add(new JLabel(""));
        pan_btn.add(btn3);
        pan_btn.add(new JLabel(""));
        pan_btn.add(btn4);
        jf_main.add(pan_btn,BorderLayout.EAST);

        jf_main.setSize(900, 800);
        jf_main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf_main.setVisible(true);
    }

    //각 좌석에 리스너를 추가해줄 메서드(SeatView에서만 사용된다)
    //i	:PC번호/ pan_seat	: 좌석칸
    //lb_id_value	 	:ID 출력 라벨
    //lb_cur_time_value	:사용시간 출력 라벨
    //lb_time_value		:남은시간 출력 라벨
    //Seat				:좌석을 눌렀을때 ClientInfo를 띄워줄 리스너(오른쪽버튼들의 리스너와 같지만 생성자가 다르다)
    private Seat GetCom(SeatView sv ,int i) {
        Seat seat =new Seat(sv, lb_time_value[i], lb_cur_time_value[i], lb_id_value[i], pan_seat[i]);
        pan_seat[i].addMouseListener((MouseListener) new Main_GUI_Event(i, seat, lb_id_value[i], lb_cur_time_value[i], lb_time_value[i],this));
        return seat;
    }
    //클라이언트인포로 소켓을 보내주고 서버에서 충전할때 클라이어언트로 메시지를 보내는데 사용하기위해
    private void SetSocket(Socket socket) {
        this.socket=socket;
    }
    public Socket GetSocket() {
        return socket;
    }
    private void SetSeat(Seat[] seat) {
        this.SaveSeat=seat;
    }
    public Seat[] GetSeat() {
        return this.SaveSeat;
    }

    public static void main(String[] args) {
        SeatView sv = new SeatView();
        ServerSocket server=null;
        PrintWriter[] arr=null;
        Seat[] seat=new Seat[20];

        //각 좌석에 리스너를 추가해주기 위함
        for(int i=0; i<20;i++) {
            seat[i] =sv.GetCom(sv, i);
        }
        sv.SetSeat(seat);
        try{
            server=new ServerSocket(7777);
            arr=new PrintWriter[20];
            while(true) {
                System.out.println("접속대기중");
                Socket soc=server.accept();
                System.out.println("클라이언트 접속");
                SeatThread th=new SeatThread(soc,arr,seat,sv.lb_time_value,sv.lb_cur_time_value);
                sv.SetSocket(soc);
                Thread job=new Thread(th);
                job.start();
            }
        }catch(IOException e) {
            System.out.println(e.getMessage());  
        }
    }
}

