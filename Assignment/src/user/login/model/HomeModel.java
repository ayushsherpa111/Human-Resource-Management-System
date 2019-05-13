package user.login.model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import user.login.authorised.Department;
import user.login.lecturer.Contract;
import user.login.lecturer.FullTime;
import user.login.lecturer.Lecturer;
import user.login.lecturer.PartTime;

public class HomeModel {
	String departmentPath = "department.bin";
	String lecturerPath = "lecturer.bin";

	ObjectOutputStream os = null;
	PrintWriter pw = null;
	ObjectInputStream in = null;

	public boolean checkID(int id,ArrayList<Lecturer> list)
	{
		boolean contains = false;
		for (Lecturer lecturer : list) {
			if (lecturer.getID() == id) {
				contains = true;
			}
		}
		return contains;
	}
	
	public boolean checkField(Object field)
	{
		boolean empty = false;
		if (field instanceof Department) {
			Department d = (Department) field;
			if (d.getdepartmentName().isEmpty() || d.getUserName().isEmpty() || d.getType().isEmpty() || d.getPassword().isEmpty()) {
				empty = true;
			}
		}else if(field instanceof FullTime)
		{
			FullTime ft1 = (FullTime)field;
			if (ft1.getID() == 0 || ft1.getDepartment().isEmpty() || ft1.getAddress().isEmpty() || ft1.getEmail().isEmpty() || ft1.getName().isEmpty() || ft1.getPhoneNumber().isEmpty() || ft1.getSalary() == 0.0) {
				empty = true;
			} 
		}
		else if(field instanceof PartTime)
		{
			PartTime pt1 = (PartTime)field;
			if (pt1.getID() == 0 || pt1.getDepartment().isEmpty() || pt1.getAddress().isEmpty() || pt1.getEmail().isEmpty() || pt1.getName().isEmpty() || pt1.getPhoneNumber().isEmpty() || pt1.getPayRate() == 0.0) {
				empty = true;
			}
		}
		else if(field instanceof Contract)
		{
			Contract ct1 = (Contract)field;
			if (ct1.getID() == 0 || ct1.getDepartment().isEmpty() || ct1.getAddress().isEmpty() || ct1.getEmail().isEmpty() || ct1.getName().isEmpty()||ct1.getPhoneNumber().isEmpty() || ct1.getSalary() == 0.0) {
				empty = true;
			}
		}
		return empty;
	}
	
	public <T> void addDepartment(ArrayList<T> u,String filePath) throws FileNotFoundException, IOException {
		os = new ObjectOutputStream(new FileOutputStream(filePath));
		for (T person : u) {
			os.writeObject(person);
		}
		os.close();
	}

	public ArrayList<Department> getDepartment() throws FileNotFoundException, IOException {
		ArrayList<Department> u = new ArrayList<>();
		try {
			in = new ObjectInputStream(new FileInputStream(departmentPath));
			Department user = null;
			while ((user = (Department) in.readObject()) != null) {
				u.add(user);
				
			}
			in.close();
		} catch (EOFException e) {
		} catch (ClassNotFoundException e) {
		} 
		return u;
	}
	
	public ArrayList<Lecturer> getLecturer() throws FileNotFoundException, IOException {
		ArrayList<Lecturer> u = new ArrayList<>();
		try {
			in = new ObjectInputStream(new FileInputStream(lecturerPath));
			Lecturer user = null;
			while ((user = (Lecturer) in.readObject()) != null) {
				u.add(user);
			}
			in.close();
		} catch (EOFException e) {
		} catch (ClassNotFoundException e) {
		} 
		return u;
	}
	
	
}
