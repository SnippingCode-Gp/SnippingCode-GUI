package main;

import java.io.IOException;

import org.json.JSONException;

import SnippingCode.Service.CodesHttpRequest;
import SnippingCode.Service.FileOperation;
import model.DownloadModel;
import mvc.MVCDownload;
import mvc.MVCLogin;
import mvc.MVCSignUp;

public class Main {

  public static void main(String[] args) {
    // MVCLogin l = new MVCLogin();
    // l.run();

    // MVCSignUp s = new MVCSignUp();
    // s.run();

    FileOperation fileOperation = new FileOperation();
    CodesHttpRequest codesHttpRequest = new CodesHttpRequest();

    try {
      fileOperation.initXmlFile(codesHttpRequest.getAllCode("abdelgawad",
          "123456", "0"));
    } catch (JSONException | IOException e) {
      e.printStackTrace();
    }
    
    DownloadModel downloadModel = new DownloadModel();
    

    MVCDownload d = new MVCDownload();
    d.run(new String[1]);
  }

}
