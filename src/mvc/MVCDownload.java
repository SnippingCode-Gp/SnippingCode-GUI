package mvc;

import model.DownloadModel;
import view.DownloadView;
import controller.DownloadController;

public class MVCDownload {
  public void run(String[] arr) {
    DownloadView view = new DownloadView();
    DownloadModel model = new DownloadModel();
    view.setCodesNameList(arr);
    DownloadController controller = new DownloadController(model, view);
    view.setVisible(true);
  }
}
