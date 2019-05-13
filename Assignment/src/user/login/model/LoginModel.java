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
import user.login.authorised.Users;

public class LoginModel {
	String userName;
	String password;

	String filePath = "Login.bin";

	ObjectOutputStream os = null;
	ObjectInputStream inDepartment = null;
	ObjectInputStream in = null;
	PrintWriter pw = null;

	public void addUser(ArrayList<Users> u) throws FileNotFoundException, IOException {
		os = new ObjectOutputStream(new FileOutputStream(filePath));
		for (Users person : u) {
			os.writeObject(person);
		}

		os.close();
	}

	public ArrayList<Department> getDepartmentUsers() throws FileNotFoundException, IOException {
		ArrayList<Department> d = new ArrayList<>();
		in = new ObjectInputStream(new FileInputStream("department.bin"));
		Department dep = null;
		try {
			while ((dep = (Department) in.readObject()) != null) {
				d.add(dep);
			}
		} catch (EOFException | ClassNotFoundException e) {
		} finally {
			in.close();
		}
		return d;
	}

	public ArrayList<Users> getUser() throws FileNotFoundException, IOException {
		ArrayList<Users> u = new ArrayList<>();
		in = new ObjectInputStream(new FileInputStream(filePath));

		Users user = null;
		try {
			while ((user = (Users) in.readObject()) != null) {
				u.add(user);
			}
		} catch (EOFException | ClassNotFoundException e) {
		} finally {
			in.close();
		}
		return u;
	}

	public char checkPass(String userName, String password)
			throws ClassNotFoundException, FileNotFoundException, IOException {
		char type = 0;
		ArrayList<Users> users = getUser();
		ArrayList<Department> depUsers = getDepartmentUsers();
		for (Users u : users) {
			if ((userName.equals(u.getUserName()) && (password.equals(u.getPassword())))) {
				type = 'A';
				break;
			}
		}
		for (Department d : depUsers) {
			if ((userName.equals(d.getUserName()) && (password.equals(d.getPassword())))) {
				type = 'D';
				break;
			}
		}
		return type;

	}

}
