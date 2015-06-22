package model;

public class DownloadModel {
  private String codeName;
  
  public String getCode() {
    return codeName + " implementation";
  }
  
  public String getVersion() {
    return codeName + " 0.0.1";
  }
  
  public String[] getCodeTags() {
    String[] arr = new String[10];
    for(int i = 0; i < arr.length; ++i)
      arr[i] = codeName + String.format(" tag%d", i);
    return arr;
  }
  
  public void setCodeName(String codeName) {
    this.codeName = codeName;
  }
  
}
