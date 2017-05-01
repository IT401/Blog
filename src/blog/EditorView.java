package blog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.text.html.HTMLDocument;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;

/**
 * Handles new blog message editor GUI.
 * @author Liudas Dzisevicius
 */
public class EditorView extends JPanel {
  private EditorController controller;
  private JEditorPane editor;
  private JButton saveButton;
  private JButton imageButton;
  private JTextField titleField;
  private final JFileChooser chooser = new JFileChooser();
  
  EditorView(EditorController controller) {
    super();
    this.controller = controller;
    setLayout(new GridBagLayout());
    
    setupComponents();  
  }
  
  public HTMLDocument getDocument() {
    return (HTMLDocument)editor.getDocument();
  }
  
  public String getTitle() {
    return titleField.getText();
  }
  
  private void setupComponents() {
    GridBagConstraints c = new GridBagConstraints();
    
    JLabel titleLabel = new JLabel("Title");
    c.gridx = 0;
    c.gridy = 0;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.weightx = 1.0;
    c.fill = GridBagConstraints.HORIZONTAL;
    add(titleLabel, c);
    
    titleField = new JTextField();
    c.gridx = 0;
    c.gridy = 1;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.weightx = 1.0;
    c.fill = GridBagConstraints.HORIZONTAL;
    add(titleField, c);
    
    JLabel editorLabel = new JLabel("Content");
    c.gridx = 0;
    c.gridy = 2;
    c.gridheight = 1;
    c.gridwidth = 1;
    c.weightx = 1.0;
    c.fill = GridBagConstraints.HORIZONTAL;
    add(editorLabel, c);
    
    editor = new JEditorPane();
    editor.setContentType("text/html");
    c.gridx = 0;
    c.gridy = 3;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.fill = GridBagConstraints.BOTH;
    add(editor, c);
    
    imageButton = new JButton("Upload an image");
    imageButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        try {
          chooser.setFileFilter(new FileNameExtensionFilter("JPG, PNG or GIF images", "jpg", "gif", "png"));
          int returnVal = chooser.showOpenDialog(imageButton);
          if(returnVal == JFileChooser.APPROVE_OPTION) {
            HTMLDocument document = (HTMLDocument)editor.getDocument();
            Element p = document.getElement(document.getDefaultRootElement(), StyleConstants.NameAttribute, HTML.Tag.P);
            document.insertAfterEnd(p, "<img src='file:"+chooser.getSelectedFile().getPath().replace("\\","\\\\")+"'/>");
          }
        } catch (Exception ex) {
          System.out.println(ex);
        }
      }
    });
      
    c.gridx = 0;
    c.gridy = 4;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.weightx = 1.0;
    c.weighty = 0;
    c.fill = GridBagConstraints.HORIZONTAL;
    add(imageButton, c);

    saveButton = new JButton("Save");
    saveButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        controller.save(getTitle(), getDocument());
      }
    });
    c.gridx = 0;
    c.gridy = 5;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.weightx = 1.0;
    c.weighty = 0;
    c.fill = GridBagConstraints.HORIZONTAL;
    add(saveButton, c);
  }
 
}
