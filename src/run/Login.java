package run;

import login.LoginController;
import login.LoginModel;
import login.LoginView;

public class Login {
  
  public void run() {
    LoginModel model = new LoginModel();
    LoginView view = new LoginView();
    LoginController controller = new LoginController(model, view);
    view.setVisible(true);
  }
  
}
