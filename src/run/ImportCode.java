package run;

import importCode.ImportCodeController;
import importCode.ImportCodeModel;
import importCode.ImportCodeView;

import java.util.List;

import SnippingCode.Domain.Code;
import SnippingCode.Service.FileOperation;

public class ImportCode {
  
  public void run(String workspacePath) {
    ImportCodeModel model = new ImportCodeModel();
    ImportCodeView view = new ImportCodeView();
    String pathTest = "/home/abdelgawad/.SC/Codes.xml";
    FileOperation fileOperation = new FileOperation();
    List<Code> codes = fileOperation.parseXmlFile(pathTest);
    String[] arr = new String[codes.size()];
    for(int i = 0; i < codes.size(); ++i)
      arr[i] = codes.get(i).getName();
    view.setCodesNameList(arr);
    ImportCodeController controller = new ImportCodeController(model, view);
    controller.setWorkspacePath(workspacePath);
    view.setVisible(true);
  }
  
}
