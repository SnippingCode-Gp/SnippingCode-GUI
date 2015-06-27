package model;

import java.io.IOException;

import SnippingCode.Domain.User;
import SnippingCode.Service.UserHttpRequest;
import service.EmailValidator;

public class SignUpModel {
  
  private String firstName;
  private String lastName;
  private String username;
  private String password;
  private String rePassword;
  private String email;
  
  private EmailValidator emailValidator = new EmailValidator();
  
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  public void setRePassword(String rePassword) {
    this.rePassword = rePassword;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public int tryToSignUp() throws IOException {
    if(this.firstName.equals("")) return 1;
    if(this.lastName.equals("")) return 1;
    if(this.username.equals("")) return 1;
    if(this.password.equals("")) return 1;
    if(this.rePassword.equals("")) return 1;
    if(this.email.equals("")) return 1;
    if(!this.password.equals(this.rePassword)) return 2;
    if(!this.emailValidator.isValid(this.email)) return 3;
    
    User user = new User();
    user.setFirstName(this.firstName);
    user.setLastName(this.lastName);
    user.setUsername(this.username);
    user.setPassword(this.password);
    user.setEmail(this.email);
    
    UserHttpRequest request = new UserHttpRequest(user);
    return request.signUp();
  }
  
}
