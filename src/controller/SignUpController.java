package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.HttpURLConnection;

import model.SignUpModel;
import view.SignUpView;

public class SignUpController {

  private SignUpView view;
  private SignUpModel model;

  public SignUpController(SignUpModel model, SignUpView view) {
    this.view = view;
    this.model = model;

    this.view.setFirstNameFieldAction(new PreventSpacesInJTextFieldAction());
    this.view.setLastNameFieldAction(new PreventSpacesInJTextFieldAction());
    this.view.setUsernameFieldAction(new PreventSpacesInJTextFieldAction());
    this.view.setPasswordFieldAction(new PreventSpacesInJTextFieldAction());
    this.view.setRePasswordFieldAction(new PreventSpacesInJTextFieldAction());
    this.view.setEmailFieldAction(new PreventSpacesInJTextFieldAction());
    this.view.setSignUpButtonAction(new SignUpButtonAction());
  }

  class SignUpButtonAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      model.setFirstName(view.getFirstName());
      model.setLastName(view.getLastName());
      model.setUsername(view.getUsername());
      model.setPassword(view.getPassword());
      model.setRePassword(view.getRePassword());
      model.setEmail(view.getEmail());

      try {
        int statusCode = model.tryToSignUp();
        switch(statusCode) {
        case 1:
          view.errorMessage("some fields are missed");
          break;
        case 2:
          view.errorMessage("password doesn't match");
          break;
        case 3:
          view.errorMessage("invalid email address");
          break;
        case HttpURLConnection.HTTP_OK:
          view.errorMessage("Done");
          break;
        case HttpURLConnection.HTTP_CONFLICT:
          view.errorMessage("exists");
          break;
        default:
          break;
        }
      } catch(IOException e1) {
        view.errorMessage("the server is down");
      }
    }

  }

  class PreventSpacesInJTextFieldAction implements KeyListener {

    public void keyTyped(KeyEvent e) {
      if(e.getKeyChar() == KeyEvent.VK_SPACE) e.consume();      
    }
    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }

  }

}
