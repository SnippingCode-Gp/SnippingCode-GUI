package importCode;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Set;

import SnippingCode.Domain.Code;
import SnippingCode.Service.FileOperation;

public class ImportCodeModel {
  private String path;
  private String codeName;
  private FileOperation fileOperation;
  private Code code;

  public ImportCodeModel() {
    this.fileOperation = new FileOperation();
    setPath();
  }

  private String OperatingSystemVersion() {
    return System.getProperty("os.name");
  }

  private String executeCommand(String command) {
    Process process;
    try {
      process = Runtime.getRuntime().exec(command);
      process.waitFor();
      BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
      String line = "";
      while((line = reader.readLine()) != null) {
        return line;
      }
    } catch(Exception e) {
      e.printStackTrace();
    }
    return "error";
  }

  private void setPath() {
    if(OperatingSystemVersion().equals("Linux")) {
      this.path = "/home/" + executeCommand("whoami") + "/.SC/codes/";
    } else {
      this.path = "/home/" + executeCommand("whoami") + "/.SC/codes/";
    }
  }

  public String getCodeBody() {
    return this.code.getCode();
  }

  public String getCodeVersion() {
    return "1.0.0";
  }

  public String[] getCodeTags() {
    Set<String> tags = this.code.getTagSet();
    return tags.toArray(new String[tags.size()]);
  }

  public void setCodeName(String codeName) {
    this.codeName = codeName;
    this.code = this.fileOperation.parseCodeJsonFile(this.path + this.codeName);
    code.printAll();
  }

  public void importCode() {
    String strManyDirectories="src"+File.separator+"imported";
    try {
      (new File(strManyDirectories)).mkdirs();
      PrintWriter writer = new PrintWriter(strManyDirectories+File.separator+this.codeName+".java", "UTF-8");
      writer.write(this.code.getCode());
      writer.close();
    } catch(Exception e) {
      System.err.println("Error: " + e.getMessage());
    }
  }
  
}
