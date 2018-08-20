package ClientInfo;

public class SignUpDTO {
	String name;
	String id;
	String pw;
	String phno;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getPhno() {
		return phno;
	}
	public void setPhno(String phno) {
		this.phno = phno;
	}
	
	public SignUpDTO(String name, String id, String pw, String phno) {
		super();
		this.name = name;
		this.id = id;
		this.pw = pw;
		this.phno = phno;
	}
	
}
