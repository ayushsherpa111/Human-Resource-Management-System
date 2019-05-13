package user.login.lecturer;

import java.io.Serializable;
import java.util.Date;

public class Contract extends Lecturer implements Serializable {

	double salary;
	Date endDate;
	
	public Contract(int ID, String name, String address, String phoneNumber, String email, Date startDate,String department,double salary,Date endDate) {
		super(ID, name, address, phoneNumber, email, startDate, department);
		this.salary = salary;
		this.endDate = endDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

}
