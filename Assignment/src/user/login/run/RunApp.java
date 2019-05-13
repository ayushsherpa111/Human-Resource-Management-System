package user.login.run;

import user.login.controller.LoginController;
import user.login.model.LoginModel;
import user.login.view.LoginView;

public class RunApp {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		LoginView view = new LoginView();
		view.setVisible(true);

		LoginModel model = new LoginModel();

		LoginController control = new LoginController(view, model);
	

	}
}
