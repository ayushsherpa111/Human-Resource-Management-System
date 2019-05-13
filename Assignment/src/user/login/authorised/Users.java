package user.login.authorised;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Users implements Serializable{
	
	private String userName;
	private String password;

	public Users(String userName, String password) {
		this.userName = userName;
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

}
