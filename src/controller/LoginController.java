package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.HttpURLConnection;

import org.json.JSONException;

import view.LoginView;
import model.LoginModel;

public class LoginController {

  private LoginModel model;
  private LoginView view;

  public LoginController(LoginModel model, LoginView view) {
    this.model = model;
    this.view = view;

    this.view.setLoginButtonAction(new LoginButtonAction());
    this.view.setUsernameFieldAction(new PreventSpacesInJTextFieldAction());
    this.view.setPasswordFieldAction(new PreventSpacesInJTextFieldAction());
  }

  class LoginButtonAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      model.setUsername(view.getUsername());
      model.setPassword(view.getPassword());
      try {
        int statusCode = model.tryToLogin();
        switch(statusCode) {
        case HttpURLConnection.HTTP_OK:
          view.errorMessage("Done");
          break;
        case HttpURLConnection.HTTP_NOT_FOUND:
          view.errorMessage("invalid usename or password");
          break;
        default:
          break;
        }
      } catch (IOException e1) {
        view.errorMessage("the server is down");
      } catch (JSONException e1) {
        e1.printStackTrace();
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
