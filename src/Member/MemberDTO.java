package Member;

public class MemberDTO {
	private int number;
	private String id;
	private String pw;
	private String phonenum;
	private String name;
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
	public MemberDTO(int number, String id, String pw, String phonenum, String name) {
		super();
		this.number = number;
		this.id = id;
		this.pw = pw;
		this.phonenum = phonenum;
		this.name = name;
	}
	
}



