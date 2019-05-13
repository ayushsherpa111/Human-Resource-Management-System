package user.login.lecturer;

import java.io.Serializable;
import java.util.Date;

public class FullTime extends Lecturer implements Serializable {
	double salary;

	public FullTime(int ID, String name, String address, String phoneNumber, String email, Date startDate,String department,double salary) {
		super(ID, name, address, phoneNumber, email, startDate,department);
		this.salary = salary;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}
