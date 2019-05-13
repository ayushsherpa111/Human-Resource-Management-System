package user.login.model;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import user.login.authorised.Department;
import user.login.lecturer.Lecturer;

public class DepartmentModel {
	Department dUser = null;
	private ObjectInputStream in = null;

	public Department userInfo(String userName) {
		Department d = null;
		try {
			ArrayList<Department> users = new LoginModel().getDepartmentUsers();
			for (Department department : users) {
				if (department.getUserName().equals(userName)) {
					d = department;
					dUser = department;
				}
			}
		} catch (IOException e) {
		}
		return d;
	}

	public ArrayList<Lecturer> getAllLecturer() throws IOException {
		ArrayList<Lecturer> lecs = new ArrayList<>();
		in = new ObjectInputStream(new FileInputStream("lecturer.bin"));
		Lecturer l = null;
		try {
			while ((l = (Lecturer) in.readObject()) != null) {
				if (dUser.getType().equals(l.getDepartment())) {
					lecs.add(l);
				}
			}
		} catch (EOFException | ClassNotFoundException e) {
		} finally {
			in.close();
		}
		return lecs;
	}

	public ArrayList<Lecturer> searchRecord(String cirteria, String value) throws IOException {
		ArrayList<Lecturer> searchRecord = new ArrayList<>();
		ArrayList<Lecturer> availableLecs = new ArrayList<>();
		availableLecs = getAllLecturer();
		for (Lecturer lecturer : availableLecs) {
			if (cirteria.equals("ID")) {
				if (lecturer.getID() == Integer.parseInt(value)) {
					searchRecord.add(lecturer);
					break;
				}
			} else if (cirteria.equals("Name")) {
				if (lecturer.getName().contains(value)) {
					searchRecord.add(lecturer);
				}
			} else if (cirteria.equals("Address")) {
				if (lecturer.getAddress().contains(value)) {
					searchRecord.add(lecturer);
				}
			} else if (cirteria.equals("Email")) {
				if (lecturer.getEmail().equalsIgnoreCase(value)) {
					searchRecord.add(lecturer);
				}
			}
		}
		return searchRecord;
	}
}
