package login;

import java.awt.event.ActionListener;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

@SuppressWarnings("serial")
public class LoginView extends JFrame {

  private JTextField usernameField;
  private JPasswordField passwordField;
  private JButton loginButton;

  public LoginView() {
    super("Login");
    this.setSize(370, 150);
    this.setResizable(false);
    this.setLocation(400, 200);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);

    this.usernameField = new JTextField(20);
    this.passwordField = new JPasswordField(20);
    this.loginButton = new JButton("Login");

    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel announcementLabel = new JLabel("* If you don't have an account please sign up first.");
    SpringLayout layout = new SpringLayout();


    layout.putConstraint(SpringLayout.EAST, this.usernameField, -20, SpringLayout.EAST, this.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, this.usernameField, 50, SpringLayout.NORTH, this.getContentPane());
    layout.putConstraint(SpringLayout.EAST, this.passwordField, -20, SpringLayout.EAST, this.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, this.passwordField, 10, SpringLayout.SOUTH, this.usernameField);

    
    layout.putConstraint(SpringLayout.WEST, announcementLabel, 5, SpringLayout.WEST, this.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, announcementLabel, 10, SpringLayout.NORTH, this.getContentPane());
    
    layout.putConstraint(SpringLayout.EAST, usernameLabel, -20, SpringLayout.WEST, this.usernameField);
    layout.putConstraint(SpringLayout.NORTH, usernameLabel, 50, SpringLayout.NORTH, this.getContentPane());
    layout.putConstraint(SpringLayout.EAST, passwordLabel, -20, SpringLayout.WEST, this.passwordField);
    layout.putConstraint(SpringLayout.NORTH, passwordLabel, 10, SpringLayout.SOUTH, this.usernameField);    
    
    
    layout.putConstraint(SpringLayout.EAST, this.loginButton, -20, SpringLayout.EAST, this.getContentPane());
    layout.putConstraint(SpringLayout.SOUTH, this.loginButton, -10, SpringLayout.SOUTH, this.getContentPane());


    this.add(usernameLabel);
    this.add(passwordLabel);
    this.add(this.usernameField);
    this.add(this.passwordField);
    this.add(this.loginButton);
    this.add(announcementLabel);
    this.setLayout(layout);
    this.getRootPane().setDefaultButton(loginButton);
  }

  public String getUsername() {
    return this.usernameField.getText();
  }

  public String getPassword() {
    return new String(this.passwordField.getPassword());
  }

  public void setLoginButtonAction(ActionListener listener) {
    this.loginButton.addActionListener(listener);
  }

  public void setUsernameFieldAction(KeyListener listener) {
    this.usernameField.addKeyListener(listener);
  }
  
  public void setPasswordFieldAction(KeyListener listener) {
    this.passwordField.addKeyListener(listener);
  }
  
  public void errorMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
  }

}
