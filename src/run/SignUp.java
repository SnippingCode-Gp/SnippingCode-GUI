package run;

import java.util.HashMap;

import signUp.SignUpController;
import signUp.SignUpModel;
import signUp.SignUpView;

public class SignUp {
	SignUpController controller;

	public SignUp() {
		controller = new SignUpController(new SignUpModel(), new SignUpView());
	}

	public void run() {
		controller.setVisible(true);
	}

	public HashMap<String, String> getUser() {
		return controller.getUser();
	}

}
