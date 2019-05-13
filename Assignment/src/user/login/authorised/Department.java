package user.login.authorised;

import java.io.Serializable;

public class Department implements Serializable {
	private String departmentName;
	private String type;
	private String userName;
	private String password;

	public Department(String departmentName, String type, String userName, String password) {
		this.departmentName = departmentName;
		this.type = type;
		this.userName = userName;
		this.password = password;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getdepartmentName() {
		return departmentName;
	}

	public String getType() {
		return type;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
