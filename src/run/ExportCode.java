package run;

import exportCode.ExportCodeController;
import exportCode.ExportCodeModel;
import exportCode.ExportCodeView;

public class ExportCode {

  public void run(String workspacePath) {
    ExportCodeModel model = new ExportCodeModel();
    ExportCodeView view = new ExportCodeView();
    ExportCodeController controller = new ExportCodeController(model, view);
    controller.setWorkspacePath(workspacePath);
    view.setVisible(true);
  }
  
}
