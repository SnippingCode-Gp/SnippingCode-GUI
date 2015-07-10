package run;

import java.util.HashMap;

import login.LoginController;
import login.LoginModel;
import login.LoginView;

public class Login {
	LoginController controller;

	public Login() {
		controller = new LoginController(new LoginModel(), new LoginView());
	}

	public void run() {
		controller.setVisible(true);
	}

	public HashMap<String, String> getUser() {
		return controller.getUser();
	}

	public void refresh(){
	  controller.refresh();
	}
}
