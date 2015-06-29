package importCode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ImportCodeController {
  
  private ImportCodeView view;
  private ImportCodeModel model;
  private String workspacePath;

  public ImportCodeController(ImportCodeModel model, ImportCodeView view) {
    this.view = view;
    this.model = model;

    this.view.setCodesListAction(new CodesNameListAction());
    this.view.setImportButtonAction(new ImportButtonAction());
  }

  private List<String> loadProjectsName(String workspacePath) {
    File folder = new File(workspacePath);
    File[] listOfFiles = folder.listFiles();
    List<String> projectsNamesList = new LinkedList<String>();
    for (int i = 0; i < listOfFiles.length; i++) {
      if(listOfFiles[i].isDirectory()) {
        if(!listOfFiles[i].getName().equals("RemoteSystemsTempFiles") && listOfFiles[i].getName().charAt(0) != '.')
          projectsNamesList.add(listOfFiles[i].getName());
      }
    } 
    return projectsNamesList;
  }
  
  public void setWorkspacePath(String workspacePath) {
    this.workspacePath = workspacePath;
    this.view.setProjectsNameBox(loadProjectsName(workspacePath));
  }
  
  class CodesNameListAction implements ListSelectionListener {
    
    public void valueChanged(ListSelectionEvent e) {
      model.setCodeName(view.getSelectedValueFromCodesList());
      view.setViewAreaContent(model.getCodeBody());
      view.setCodeVersionValue(model.getCodeVersion());
      view.setCodeTagsList(model.getCodeTags());
    }
    
  }

  class ImportButtonAction implements ActionListener {
  
    public void actionPerformed(ActionEvent e) {
      model.importCode(workspacePath + File.separator + view.getSelectedProject());
    }
    
  }
  
}
