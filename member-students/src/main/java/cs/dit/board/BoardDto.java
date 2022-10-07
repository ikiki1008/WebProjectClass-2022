package cs.dit.board;

//import java.sql.Date;

public class BoardDto {
	private int bcode;
	private String id;
	private String pwd;
	private String name;
	private String email;
	public int getBcode() {
		return bcode;
	}
	public void setBcode(int bcode) {
		this.bcode = bcode;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public BoardDto(int bcode, String id, String pwd, String name, String email) {
		this.bcode = bcode;
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
	}
	
	
}
