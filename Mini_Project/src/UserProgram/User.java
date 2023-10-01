package UserProgram;

public class User {
	private int no;
	private String id;
	private String pwd;
	private String name;
	
	public User(int no2, String id2, String pwd2, String name2) {
		this.no = no2;
		this.id = id2;
		this.pwd = pwd2;
		this.name = name2;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
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
}
