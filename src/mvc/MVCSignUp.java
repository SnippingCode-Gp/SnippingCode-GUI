package mvc;

import controller.SignUpController;
import model.SignUpModel;
import view.SignUpView;

public class MVCSignUp {
  public void run() {
    SignUpView view = new SignUpView();
    SignUpModel model = new SignUpModel();
    SignUpController controller = new SignUpController(model, view);
    view.setVisible(true);
  }
}
