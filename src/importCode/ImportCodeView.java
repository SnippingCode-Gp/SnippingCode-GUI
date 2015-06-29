package importCode;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class ImportCodeView extends JFrame {
  private JList<String> codesNameList;
  private DefaultListModel<String> codesNameData;
  private JTextArea viewCodeArea;
  private DefaultListModel<String> codeTagsData;
  private JList<String> codeTagsList;
  private JButton importButton;
  private JLabel codeVersionValue;

  public ImportCodeView() {
    super("Import Code");
    this.setSize(600, 600);
    this.setResizable(false);
//    this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    this.viewCodeArea =  new JTextArea();
    this.viewCodeArea.setEditable(false);
    this.codesNameData = new DefaultListModel<String>();
    this.codesNameList = new JList<String>(codesNameData);
    this.codeTagsData = new DefaultListModel<String>();
    this.codeTagsList = new JList<String>(codeTagsData);
    this.codeTagsList.setFixedCellWidth(300);
    this.importButton = new JButton("Import");
    this.codeVersionValue = new JLabel("");


    JScrollPane codesNamePane = new JScrollPane(this.codesNameList);
    JScrollPane codeTagsPane = new JScrollPane(this.codeTagsList);
    JScrollPane viewCodePane = new JScrollPane(this.viewCodeArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
    JPanel viewPanel = new JPanel();
    JPanel infoPanel = new JPanel();
    JPanel mainPanel = new JPanel();
    JLabel tagsLabel = new JLabel("Tags: ");
    JLabel codeNameTitleLabel = new JLabel("Code Name");
    JLabel codeBodyTitleLabel = new JLabel("Code Body");
    JLabel codeVersionLabel = new JLabel("Version: ");
    SpringLayout infoPanelLayout = new SpringLayout();
    SpringLayout mainPanelLayout = new SpringLayout();


    codesNamePane.setMinimumSize(new Dimension(100, 300));
    viewCodePane.setMinimumSize(new Dimension(200, 300));
    splitPane.setDividerLocation(150);
    splitPane.add(codesNamePane);
    splitPane.add(viewCodePane);
    viewPanel.setLayout(new GridLayout(1,  2));
    viewPanel.add(splitPane);
    viewPanel.setPreferredSize(new Dimension(590, 375));


    infoPanelLayout.putConstraint(SpringLayout.EAST, codeTagsPane, 0, SpringLayout.EAST, infoPanel);
    infoPanelLayout.putConstraint(SpringLayout.NORTH, codeTagsPane, 10, SpringLayout.NORTH, infoPanel);
    infoPanelLayout.putConstraint(SpringLayout.EAST, tagsLabel, 0, SpringLayout.WEST, codeTagsPane);
    infoPanelLayout.putConstraint(SpringLayout.NORTH, tagsLabel, 10, SpringLayout.NORTH, infoPanel);

    infoPanelLayout.putConstraint(SpringLayout.WEST, codeVersionLabel, 5, SpringLayout.WEST, infoPanel);
    infoPanelLayout.putConstraint(SpringLayout.NORTH, codeVersionLabel, 10, SpringLayout.NORTH, infoPanel);
    infoPanelLayout.putConstraint(SpringLayout.WEST, codeVersionValue, 0, SpringLayout.EAST, codeVersionLabel);
    infoPanelLayout.putConstraint(SpringLayout.NORTH, codeVersionValue, 10, SpringLayout.NORTH, infoPanel);

    infoPanel.add(codeVersionLabel);
    infoPanel.add(this.codeVersionValue);
    infoPanel.add(codeTagsPane);
    infoPanel.add(tagsLabel);
    infoPanel.setLayout(infoPanelLayout);
    infoPanel.setPreferredSize(new Dimension(585, 150));


    mainPanelLayout.putConstraint(SpringLayout.WEST, codeNameTitleLabel, 10, SpringLayout.WEST, mainPanel);
    mainPanelLayout.putConstraint(SpringLayout.NORTH, codeNameTitleLabel, 5, SpringLayout.NORTH, mainPanel);
    mainPanelLayout.putConstraint(SpringLayout.EAST, codeBodyTitleLabel, -10, SpringLayout.EAST, mainPanel);
    mainPanelLayout.putConstraint(SpringLayout.NORTH, codeBodyTitleLabel, 5, SpringLayout.NORTH, mainPanel);
    mainPanelLayout.putConstraint(SpringLayout.NORTH, viewPanel, 25, SpringLayout.NORTH, mainPanel);
    mainPanelLayout.putConstraint(SpringLayout.WEST, viewPanel, 5, SpringLayout.WEST, mainPanel);
    mainPanelLayout.putConstraint(SpringLayout.NORTH, infoPanel, 5, SpringLayout.SOUTH, viewPanel);
    mainPanelLayout.putConstraint(SpringLayout.WEST, infoPanel, 5, SpringLayout.WEST, viewPanel);
    mainPanelLayout.putConstraint(SpringLayout.WEST, importButton, 10, SpringLayout.WEST, mainPanel);
    mainPanelLayout.putConstraint(SpringLayout.SOUTH, importButton, -10, SpringLayout.SOUTH, mainPanel);

    mainPanel.add(codeNameTitleLabel);
    mainPanel.add(codeBodyTitleLabel);
    mainPanel.add(viewPanel);
    mainPanel.add(infoPanel);
    mainPanel.add(this.importButton);
    mainPanel.setLayout(mainPanelLayout);


    this.add(mainPanel);
  }

  public String getSelectedValueFromCodesList() {
    return this.codesNameList.getSelectedValue();
  }

  public void setViewAreaContent(String content) {
    this.viewCodeArea.setText(content);
  }

  public void setCodeVersionValue(String value) {
    this.codeVersionValue.setText(value);
  }

  public void setCodesListAction(ListSelectionListener listener) {
    this.codesNameList.addListSelectionListener(listener);
  }

  public void setImportButtonAction(ActionListener listener) {
    this.importButton.addActionListener(listener);
  }

  public void setCodesNameList(String[] codesName) {
    for(int i = 0; i < codesName.length; ++i)
      this.codesNameData.addElement(codesName[i]);
  }

  public void setCodeTagsList(String[] tags) {
    this.codeTagsData.clear();
    for(int i = 0; i < tags.length; ++i)
      this.codeTagsData.addElement(tags[i]);
  }

  public void errorMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
  }

}
