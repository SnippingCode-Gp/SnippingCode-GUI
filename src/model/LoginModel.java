package model;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;


public class LoginModel {
  
  private String username;
  private String password;

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int tryToLogin() throws IOException, JSONException {
    JSONObject jsonObject = new JSONObject();
    jsonObject.put("username", this.username);
    jsonObject.put("password", this.password);
    String urlParameters = jsonObject.toString();

    String requestURL = "http://localhost:8080/CodeSnipping/registration/login";
    URL url = new URL(requestURL);
    HttpURLConnection connection = (HttpURLConnection)url.openConnection();           
    connection.setDoOutput( true );
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
