package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

import javax.swing.JLabel;

import views.SeatView;

public class SeatThread implements Runnable{
	private Socket socket;
	private int num;
	private String id;
	private Seat[] seat;
	private int check_num=0;
	private int check_id=0;
	
	private ArrayList<PrintWriter> arr=null;
	
	public  SeatThread(Socket socket,ArrayList<PrintWriter> arr, Seat[] seat) {// String id, int num){
		this.socket=socket;
		this.seat=seat;
		this.arr=arr;//채팅없으면 삭제해도됨
		PrintWriter pw=null;
		try {
			pw=new PrintWriter(socket.getOutputStream());   
			System.out.println("PC 연결 대기중...");
			BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			num=Integer.parseInt(in.readLine());
			if(seat[num].GetId().equals("대기중") || seat[num].GetId().equals("로그아웃")) {
				check_num=0;
			}else {
				check_num=1;
			}
			
			if(check_num==0) {
				System.out.println((num+1) + "번PC 접속.");
			
				pw.println("1");
				pw.flush();
				id=in.readLine();
				for(int i=0; i<20; i++) {
					if(seat[i].GetId().equals(id)&& num!=i)
						check_id=1;
				}
				if(check_id==0) {
					System.out.println(id + "사용자 로그인");
					pw.println("1");
					pw.flush();
					seat[num].SetStart(id);
					System.out.println((num+1)+"번PC 사용자 "+ id);	
				}else {
					System.out.println("이미 로그인한 아이디입니다.");
					pw.println("0");
					pw.flush();
				}//end check_id
			}else{
				System.out.println("사용중인 PC입니다.");
				pw.println("0");
				pw.flush();
			}//end check_num
		} catch(IOException e){
			System.out.println(e);
		}
	}

	@Override
	public void run() {
		BufferedReader in=null;
		try {
			in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str=null;
			while((str=in.readLine())!=null){
				if(str.equals("/quit")){
					break;
				}else{
//					broadcast(str);
				}
			}//while
		}catch(IOException e)
		{
			System.out.println(e);
		}
		finally{
			seat[num].SetEnd();
			System.out.println((num+1) + "PC 종료.");	
			if(socket != null)
				try{	socket.close(); } catch(IOException e){}
		}		
	}
}
