package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.DownloadModel;
import view.DownloadView;

public class DownloadController {
  
  private DownloadView view;
  private DownloadModel model;

  public DownloadController(DownloadModel model, DownloadView view) {
    this.view = view;
    this.model = model;

    this.view.setCodesListAction(new CodesNameListAction());
    this.view.setDownloadButtonAction(new DownloadButtonAction());
  }

  class CodesNameListAction implements ListSelectionListener {
    
    public void valueChanged(ListSelectionEvent e) {
      model.setCodeName(view.getSelectedValueFromCodesList());
      view.setViewAreaContent(model.getCode());
      view.setCodeVersionValue(model.getVersion());
      view.setCodeTagsList(model.getCodeTags());
    }
    
  }

  class DownloadButtonAction implements ActionListener {
  
    public void actionPerformed(ActionEvent e) {
      
    }
    
  }
  
}
