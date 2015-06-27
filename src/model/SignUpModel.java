package model;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;

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
  
  public int tryToSignUp() throws JSONException, IOException {
    if(this.firstName.equals("")) return 1;
    if(this.lastName.equals("")) return 1;
    if(this.username.equals("")) return 1;
    if(this.password.equals("")) return 1;
    if(this.rePassword.equals("")) return 1;
    if(this.email.equals("")) return 1;
    if(!this.password.equals(this.rePassword)) return 2;
    if(!this.emailValidator.isValid(this.email)) return 3;
    
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("name", this.firstName);
//    jsonObject.put("lastname", this.lastName);
    jsonObject.put("username", this.username);
    jsonObject.put("password", this.password);
    jsonObject.put("email", this.email);
    String urlParameters = jsonObject.toString();

    String requestURL = "http://localhost:8080/CodeSnipping/SignUp";
    URL url = new URL(requestURL);
    HttpURLConnection connection = (HttpURLConnection)url.openConnection();           
    connection.setDoOutput(true);
    connection.setInstanceFollowRedirects(false);
    connection.setRequestMethod("POST");
    connection.setRequestProperty("Content-Type", "application/json");
    connection.setUseCaches(false);

    DataOutputStream outStream = new DataOutputStream(connection.getOutputStream());
    outStream.write(urlParameters.getBytes());
    outStream.flush();
    outStream.close();
    
    return connection.getResponseCode();
  }
  
}
