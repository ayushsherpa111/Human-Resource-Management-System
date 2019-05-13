package user.login.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import user.login.authorised.Users;
import user.login.model.DepartmentModel;
import user.login.model.HomeModel;
import user.login.model.LoginModel;
import user.login.success.DepartmentHome;
import user.login.success.HomePage;
import user.login.view.LoginView;

public class LoginController {
	LoginView view;
	LoginModel model;
	ArrayList<Users> users = new ArrayList<>();

	public LoginController(LoginView v, LoginModel m) {
		view = v;
		model = m;
		view.login(new LoginAction());
	}

	class LoginAction implements ActionListener {

		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand() == "Login") {
				String username = view.getUserName();
				String password = view.getPassword();
				char login = 0;
				try {
					login = model.checkPass(username, password);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if (login == 'A') {
					HomeModel homeModel = new HomeModel();
					HomePage homeView = new HomePage();
					HomeController control = new HomeController(homeView, homeModel);
					view.dispose();
				} else if (login == 'D') {
					DepartmentHome homeView = new DepartmentHome();
					homeView.setUserName(username);
					DepartmentModel model = new DepartmentModel();
					DepartmentController controller = new DepartmentController(homeView, model);
					view.dispose();
				} else {
					JOptionPane.showMessageDialog(view, "Your username and password were incorrect", "Login Failed",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		}

	}

}