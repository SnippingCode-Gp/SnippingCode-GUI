package run;

import signUp.SignUpController;
import signUp.SignUpModel;
import signUp.SignUpView;

public class SignUp {

  public void run() {
    SignUpModel model = new SignUpModel();
    SignUpView view = new SignUpView();
    SignUpController controller = new SignUpController(model, view);
    view.setVisible(true);
  }
  
}
