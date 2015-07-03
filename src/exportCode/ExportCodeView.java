package exportCode;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SpringLayout;
import javax.swing.event.ListSelectionListener;

@SuppressWarnings("serial")
public class ExportCodeView extends JFrame {
  private JList<String> codesNameList;
  private DefaultListModel<String> codesNameData;
  private JTextArea viewCodeArea;
  private DefaultListModel<String> codeTagsData;
  private JList<String> codeTagsList;
  private JButton exportButton;
  private JButton addTagButton;
  private JButton removeTagButton;
  private JTextField tagNameField;
  private JComboBox<String> projectsNameBox;
  
  public ExportCodeView() {
    super("Export");
    this.setSize(600, 600);
    this.setLocation(200, 100);
    this.setResizable(false);
//    this.setDefaultCloseOperation(EXIT_ON_CLOSE);


    this.viewCodeArea =  new JTextArea();
    this.viewCodeArea.setEditable(false);
    this.codesNameData = new DefaultListModel<String>();
    this.codesNameList = new JList<String>(codesNameData);
    this.codesNameList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    this.codeTagsData = new DefaultListModel<String>();
    this.codeTagsList = new JList<String>(codeTagsData);
    this.codeTagsList.setFixedCellWidth(300);
    this.exportButton = new JButton("Export");
    this.exportButton.setEnabled(false);
    this.addTagButton = new JButton("Add Tag");
    this.removeTagButton = new JButton("X");
    this.removeTagButton.setToolTipText("remove selected tag");
    this.removeTagButton.setMargin(new Insets(0, 0, 0, 0));
    this.tagNameField = new JTextField(15);
    this.projectsNameBox = new JComboBox<String>();
    this.projectsNameBox.setPreferredSize(new Dimension(150, 20));
    
    
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
    JLabel chooseProjectLabel = new JLabel("Choose Project: ");
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

    infoPanelLayout.putConstraint(SpringLayout.EAST, this.removeTagButton, -5, SpringLayout.WEST, codeTagsPane);
    infoPanelLayout.putConstraint(SpringLayout.NORTH, this.removeTagButton, 10, SpringLayout.SOUTH, tagsLabel);
    
    infoPanelLayout.putConstraint(SpringLayout.WEST, chooseProjectLabel, 10, SpringLayout.WEST, infoPanel);
    infoPanelLayout.putConstraint(SpringLayout.NORTH, chooseProjectLabel, 10, SpringLayout.NORTH, infoPanel);
    infoPanelLayout.putConstraint(SpringLayout.WEST, this.projectsNameBox, 10, SpringLayout.WEST, infoPanel);
    infoPanelLayout.putConstraint(SpringLayout.NORTH, this.projectsNameBox, 30, SpringLayout.NORTH, infoPanel);
    
    infoPanel.add(this.removeTagButton);
    infoPanel.add(chooseProjectLabel);
    infoPanel.add(this.projectsNameBox);
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
    mainPanelLayout.putConstraint(SpringLayout.WEST, this.exportButton, 10, SpringLayout.WEST, mainPanel);
    mainPanelLayout.putConstraint(SpringLayout.SOUTH, this.exportButton, -10, SpringLayout.SOUTH, mainPanel);

    mainPanelLayout.putConstraint(SpringLayout.EAST, this.addTagButton, -10, SpringLayout.EAST, mainPanel);
    mainPanelLayout.putConstraint(SpringLayout.SOUTH, this.addTagButton, -10, SpringLayout.SOUTH, mainPanel);

    mainPanelLayout.putConstraint(SpringLayout.EAST, this.tagNameField, -5, SpringLayout.WEST, addTagButton);
    mainPanelLayout.putConstraint(SpringLayout.SOUTH, this.tagNameField, -10, SpringLayout.SOUTH, mainPanel);

    mainPanel.add(codeNameTitleLabel);
    mainPanel.add(codeBodyTitleLabel);
    mainPanel.add(viewPanel);
    mainPanel.add(infoPanel);
    mainPanel.add(this.exportButton);
    mainPanel.add(this.addTagButton);
    mainPanel.add(this.tagNameField);
    mainPanel.setLayout(mainPanelLayout);


    this.add(mainPanel);
  }

  public String getSelectedValueFromCodesList() {
    if(!this.exportButton.isEnabled() && this.codesNameList.getSelectedValue() != null)
      this.exportButton.setEnabled(true);
    return this.codesNameList.getSelectedValue();
  }

  public int getIndexOfSelectedTag() {
    return this.codeTagsList.getSelectedIndex();
  }
  
  public String getSelectedProject() {
    return this.projectsNameBox.getSelectedItem().toString();
  }
  
  public String getCodeTag() {
    String codeTag = this.tagNameField.getText();
    this.tagNameField.setText("");
    return codeTag;
  }
  
  public Set<String> getAllTags() {
    Set<String> tagsSet = new HashSet<String>();
    for(int i = 0; i < this.codeTagsData.size(); ++i)
      tagsSet.add(this.codeTagsData.elementAt(i));
    return tagsSet;
  }
  
  public void setViewAreaContent(String content) {
    this.viewCodeArea.setText(content);
  }

  public void setCodesListAction(ListSelectionListener listener) {
    this.codesNameList.addListSelectionListener(listener);
  }

  public void setExportButtonAction(ActionListener listener) {
    this.exportButton.addActionListener(listener);
  }

  public void setRemoveTagButtonAction(ActionListener listener) {
    this.removeTagButton.addActionListener(listener);
  }
  
  public void setAddTagButtonAction(ActionListener listener) {
    this.addTagButton.addActionListener(listener);
  }

  public void setCodesNameList(String[] codesName) {
    this.codesNameData.clear();
    for(int i = 0; i < codesName.length; ++i)
      this.codesNameData.addElement(codesName[i]);
  }

  public void addCodeName(String codesName) {
    this.codesNameData.addElement(codesName);
  }
  
  public void addCodeTag(String tag) {
    this.codeTagsData.addElement(tag);
  }
  
  public void removeCodeTagAt(int index) {
    if(index >= 0 && index < this.codeTagsData.size())
      this.codeTagsData.removeElementAt(index);
  }

  public void clearCodesNameList() {
    if(this.exportButton.isEnabled()) this.exportButton.setEnabled(false);
    this.codesNameData.clear();
  }
  
  public void clearCodeTagsList() {
    this.codesNameData.clear();
  }
  
  public void setProjectsNameBox(List<String> projectsName) {
    for(int i = 0; i < projectsName.size(); ++i)
      this.projectsNameBox.addItem(projectsName.get(i));
  }
  
  public void setProjectsNameBoxAction(ActionListener listener) {
    this.projectsNameBox.addActionListener(listener);
  }
  
  public void setTagNameFieldAction(KeyListener listener) {
    this.tagNameField.addKeyListener(listener);
  }
  
  public void errorMessage(String message) {
    JOptionPane.showMessageDialog(this, message);
  }

}
