package main;

import mvc.MVCDownload;
import mvc.MVCLogin;
import mvc.MVCSignUp;


public class Main {

  public static void main(String[] args) {
//    MVCLogin l = new MVCLogin();
//    l.run();

//    MVCSignUp s = new MVCSignUp();
//    s.run();
    MVCDownload d = new MVCDownload();
    d.run(new String[1]);
  }

}
