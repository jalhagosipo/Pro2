package Member;

public class MemberDTO {
	private int number;
	private String id;
	private String pw;
	private int phone_number;
	private String name;
	private String old_id;
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
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOld_id() {
		return old_id;
	}
	public void setOld_id(String old_id) {
		this.old_id = old_id;
	}
	
	public MemberDTO(int number, String id, String pw, int phone_number, String name, String old_id) {
		super();
		this.number = number;
		this.id = id;
		this.pw = pw;
		this.phone_number = phone_number;
		this.name = name;
		this.old_id = old_id;
	}
	
}




