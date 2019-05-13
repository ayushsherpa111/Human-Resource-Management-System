package user.login.lecturer;

import java.io.Serializable;
import java.util.Date;

public class Lecturer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected int ID;
	protected String name;
	protected String address;
	protected String phoneNumber;
	protected String email;
	protected Date startDate;
	protected String department;

	public Lecturer(int ID, String name, String address, String phoneNumber, String email,Date startDate,String department) {
		this.ID = ID;
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.startDate = startDate;
		this.department = department;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getID() {
		return ID;
	}

	public String getName() {
		return name;
	}

	public String getAddress() {
		return address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public Date getStartDate() {
		return startDate;
	}
}
