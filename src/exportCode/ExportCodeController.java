package exportCode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ExportCodeController {

  private ExportCodeView view;
  private ExportCodeModel model;
  private String workspacePath;
  
  public ExportCodeController(ExportCodeModel model, ExportCodeView view) {
    this.model = model;
    this.view = view;
    
    this.view.setCodesListAction(new CodesNameListAction());
    this.view.setProjectsNameBoxAction(new ProjectsNameJComboBoxAction());
    this.view.setTagNameFieldAction(new PreventSpacesInJTextFieldAction());
    this.view.setAddTagButtonAction(new TagButtonAction());
    this.view.setExportButtonAction(new ExportButtonAction());
    this.view.setRemoveTagButtonAction(new RemoveTagButtonAction());
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
      view.setViewAreaContent(model.getCodeBody(workspacePath));
    }
    
  }
  
  class ProjectsNameJComboBoxAction implements ActionListener {

    private void browse(String name) {
      File folder = new File(workspacePath + File.separator + name);
      File[] listOfFiles = folder.listFiles();
      for(int i = 0; i < listOfFiles.length; i++) {
        if(listOfFiles[i].isFile()) {
          if(listOfFiles[i].getName().charAt(0) != '.')
            view.addCodeName(name + File.separator + listOfFiles[i].getName());
        } else if(listOfFiles[i].isDirectory()) {
          if(listOfFiles[i].getName().charAt(0) != '.')
            browse(name + File.separator + listOfFiles[i].getName());
        }
      }    
    }
    
    public void actionPerformed(ActionEvent e) {
      view.clearCodesNameList();
      view.clearCodeTagsList();
      browse(view.getSelectedProject());
    }
    
  }
  
  class RemoveTagButtonAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      view.removeCodeTagAt(view.getIndexOfSelectedTag());
    }
    
  }
  
  class TagButtonAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      view.addCodeTag(view.getCodeTag());
    }
    
  }
  
  class ExportButtonAction implements ActionListener {

    public void actionPerformed(ActionEvent e) {
      model.setCodeTags(view.getAllTags());
      model.uploadCode();
    }
    
  }
  
  class PreventSpacesInJTextFieldAction implements KeyListener {

    public void keyTyped(KeyEvent e) {
      if(e.getKeyChar() == KeyEvent.VK_SPACE) e.consume();      
    }
    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }

  }
  
}
