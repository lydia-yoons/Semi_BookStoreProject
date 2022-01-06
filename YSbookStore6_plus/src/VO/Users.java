package VO;

public class Users {
	private String userid;
	private String userpw;
	private String username;
	private String userphone;
	
	
	

	public Users(String userid, String userpw, String username, String userphone) {
		super();
		this.userid = userid;
		this.userpw = userpw;
		this.username = username;
		this.userphone = userphone;
	}

	public Users() {
		super();
	}


	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public String getUserpw() {
		return userpw;
	}

	public void setUserpw(String userpw) {
		this.userpw = userpw;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	@Override
	public String toString() {
		return "아이디=" + userid + ", 비밀번호=" + userpw + ", 이름=" + username + ", 전화번호=" + userphone;
	}

	
	
}
