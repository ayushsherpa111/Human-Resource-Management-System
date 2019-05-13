package user.login.lecturer;

import java.io.Serializable;
import java.util.Date;

public class PartTime extends Lecturer implements Serializable {

	double payRate;
	public PartTime(int ID, String name, String address, String phoneNumber, String email, Date startDate,String department,double payRate) {
		super(ID, name, address, phoneNumber, email, startDate,department);
		this.payRate = payRate;
	}
	public double getPayRate() {
		return payRate;
	}
	public void setPayRate(double payRate) {
		this.payRate = payRate;
	}

}
