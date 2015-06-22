package mvc;

import controller.LoginController;
import view.LoginView;
import model.LoginModel;

public class MVCLogin {
  public void run() {
    LoginModel model = new LoginModel();
    LoginView view = new LoginView();
    LoginController controller = new LoginController(model, view);
    view.setVisible(true);
  }
}
