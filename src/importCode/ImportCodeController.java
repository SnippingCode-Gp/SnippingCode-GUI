package importCode;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ImportCodeController {
  
  private ImportCodeView view;
  private ImportCodeModel model;

  public ImportCodeController(ImportCodeModel model, ImportCodeView view) {
    this.view = view;
    this.model = model;

    this.view.setCodesListAction(new CodesNameListAction());
    this.view.setImportButtonAction(new ImportButtonAction());
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
      
    }
    
  }
  
}
