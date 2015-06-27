package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import SnippingCode.Domain.Code;
import SnippingCode.Service.FileOperation;

public class DownloadModel {
  private String path;

  private String codeName;
  private FileOperation fileOperation;
  private Code code;

  public DownloadModel() {
    fileOperation = new FileOperation();
    setPath();
  }

  private String OperatingSystemVersion() {
    return System.getProperty("os.name");
  }

  private String executeCommand(String command) {

    StringBuffer output = new StringBuffer();
    Process process;
    try {
      process = Runtime.getRuntime().exec(command);
      process.waitFor();
      BufferedReader reader = new BufferedReader(new InputStreamReader(
          process.getInputStream()));

      String line = "";
      while ((line = reader.readLine()) != null) {
        return line;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }

    return "error";
  }

  private void setPath() {
    if (OperatingSystemVersion().equals("Linux")) {
      path = "/home/" + executeCommand("whoami") + "/.SC/code/";
    } else {
      path = "/home/" + executeCommand("whoami") + "/.SC/code/";
    }
  }

  public String getCode() {
    return codeName + " implementation";
  }

  public String getVersion() {
    return codeName + " 0.0.1";
  }

  public String[] getCodeTags() {
    String[] arr = new String[10];
    for (int i = 0; i < arr.length; ++i)
      arr[i] = codeName + String.format(" tag%d", i);
    return arr;
  }

  public void setCodeName(String codeName) {
    this.codeName = codeName;
  }

  public void run() {
    this.code = fileOperation.parseCodeJsonFile(this.codeName);
  }

}
