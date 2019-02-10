package DB.DTO;

public class MemberDTO {
	private int number;
	private String id;
	private String pw;
	private String phonenum;
	private String name;
	private  String left_time;
	private int total_price;
	
	public String getLeft_time() {
		return left_time;
	}
	public void setLeft_time(String left_time) {
		this.left_time = left_time;
	}
	public int getTotal_price() {
		return total_price;
	}
	public MemberDTO(String name, String id, String pw, String phonenum) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phonenum = phonenum;
	}
	public MemberDTO(int number, String id, String pw, String phonenum, String name, String left_time, int total_price) {
		super();
		this.number = number;
		this.id = id;
		this.pw = pw;
		this.phonenum = phonenum;
		this.name = name;
		this.left_time = left_time;
		this.total_price = total_price;
	}
	public MemberDTO() {}
	public void setTotal_price(int total_price) {
		this.total_price = total_price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getPhonenum() {
		return phonenum;
	}
	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}