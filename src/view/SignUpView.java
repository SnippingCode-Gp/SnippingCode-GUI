package view;

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
public class SignUpView extends JFrame {
  private JTextField firstNameField;
  private JTextField lastNameField;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JPasswordField rePasswordField;
  private JTextField emailField;
  private JButton signUpButton;
  
  public SignUpView() {
    super("Sign Up");
    this.setSize(400, 300);
    this.setResizable(false);
    this.setLocation(400, 100);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    
    this.firstNameField = new JTextField(20);
    this.lastNameField = new JTextField(20);
    this.usernameField = new JTextField(20);
    this.passwordField = new JPasswordField(20);
    this.rePasswordField = new JPasswordField(20);
    this.emailField = new JTextField(20);
    this.signUpButton = new JButton("Sign Up");

    
    JLabel firstNameLabel = new JLabel("First Name:");
    JLabel lastNameLabel = new JLabel("Last Name:");
    JLabel usernameLabel = new JLabel("Username:");
    JLabel passwordLabel = new JLabel("Password:");
    JLabel rePasswordLabel = new JLabel("re-Password:");
    JLabel emailLabel = new JLabel("Email:");
    SpringLayout layout = new SpringLayout();
    
    
    layout.putConstraint(SpringLayout.EAST, this.firstNameField, -20, SpringLayout.EAST, this.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, this.firstNameField, 10, SpringLayout.NORTH, this.getContentPane());

    layout.putConstraint(SpringLayout.EAST, this.lastNameField, -20, SpringLayout.EAST, this.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, this.lastNameField, 20, SpringLayout.SOUTH, this.firstNameField);
    
    layout.putConstraint(SpringLayout.EAST, this.usernameField, -20, SpringLayout.EAST, this.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, this.usernameField, 20, SpringLayout.SOUTH, this.lastNameField);
    
    layout.putConstraint(SpringLayout.EAST, this.passwordField, -20, SpringLayout.EAST, this.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, this.passwordField, 20, SpringLayout.SOUTH, this.usernameField);
    
    layout.putConstraint(SpringLayout.EAST, this.rePasswordField, -20, SpringLayout.EAST, this.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, this.rePasswordField, 20, SpringLayout.SOUTH, this.passwordField);
    
    layout.putConstraint(SpringLayout.EAST, this.emailField, -20, SpringLayout.EAST, this.getContentPane());
    layout.putConstraint(SpringLayout.NORTH, this.emailField, 20, SpringLayout.SOUTH, this.rePasswordField);
    
    layout.putConstraint(SpringLayout.EAST, this.signUpButton, -20, SpringLayout.EAST, this.getContentPane());
    layout.putConstraint(SpringLayout.SOUTH, this.signUpButton, -10, SpringLayout.SOUTH, this.getContentPane());
    
    
    layout.putConstraint(SpringLayout.EAST, firstNameLabel, -40, SpringLayout.WEST, this.firstNameField);
    layout.putConstraint(SpringLayout.NORTH, firstNameLabel, 10, SpringLayout.NORTH, this.getContentPane());

    layout.putConstraint(SpringLayout.EAST, lastNameLabel, -40, SpringLayout.WEST, this.lastNameField);
    layout.putConstraint(SpringLayout.NORTH, lastNameLabel, 20, SpringLayout.SOUTH, this.firstNameField);
    
    layout.putConstraint(SpringLayout.EAST, usernameLabel, -40, SpringLayout.WEST, this.usernameField);
    layout.putConstraint(SpringLayout.NORTH, usernameLabel, 20, SpringLayout.SOUTH, this.lastNameField);
    
    layout.putConstraint(SpringLayout.EAST, passwordLabel, -40, SpringLayout.WEST, this.passwordField);
    layout.putConstraint(SpringLayout.NORTH, passwordLabel, 20, SpringLayout.SOUTH, this.usernameField);
    
    layout.putConstraint(SpringLayout.EAST, rePasswordLabel, -40, SpringLayout.WEST, this.rePasswordField);
    layout.putConstraint(SpringLayout.NORTH, rePasswordLabel, 20, SpringLayout.SOUTH, this.passwordField);
    
    layout.putConstraint(SpringLayout.EAST, emailLabel, -40, SpringLayout.WEST, this.emailField);
    layout.putConstraint(SpringLayout.NORTH, emailLabel, 20, SpringLayout.SOUTH, this.rePasswordField);
    
    
    this.add(firstNameLabel);
    this.add(lastNameLabel);
    this.add(usernameLabel);
    this.add(passwordLabel);
    this.add(rePasswordLabel);
    this.add(emailLabel);
    this.add(this.firstNameField);
    this.add(this.lastNameField);
    this.add(this.usernameField);
    this.add(this.passwordField);
    this.add(this.rePasswordField);
    this.add(this.emailField);
    this.add(this.signUpButton);
    this.setLayout(layout);
    this.getRootPane().setDefaultButton(signUpButton);
  }
  
  public String getFirstName() {
    return this.firstNameField.getText();
  }
  
  public String getLastName() {
    return this.lastNameField.getText();
  }
  
  public String getUsername() {
    return this.usernameField.getText();
  }
  
  public String getPassword() {
    return new String(this.passwordField.getPassword());
  }
  
  public String getRePassword() {
    return new String(this.rePasswordField.getPassword());
  }
  
  public String getEmail() {
    return this.emailField.getText();
  }
  
  public void setSignUpButtonAction(ActionListener listener) {
    this.signUpButton.addActionListener(listener);
  }
  
  public void setFirstNameFieldAction(KeyListener listener) {
    this.firstNameField.addKeyListener(listener);
  }
  
  public void setLastNameFieldAction(KeyListener listener) {
    this.lastNameField.addKeyListener(listener);
  }
  
  public void setUsernameFieldAction(KeyListener listener) {
    this.usernameField.addKeyListener(listener);
  }
  
  public void setPasswordFieldAction(KeyListener listener) {
    this.passwordField.addKeyListener(listener);
  }
  
  public void setRePasswordFieldAction(KeyListener listener) {
    this.rePasswordField.addKeyListener(listener);
  }
  
  public void setEmailFieldAction(KeyListener listener) {
    this.emailField.addKeyListener(listener);
  }
  
  public void errorMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
  }
  
}
