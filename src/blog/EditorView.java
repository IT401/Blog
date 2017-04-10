package blog;

import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.text.html.HTMLDocument;
import javax.imageio.ImageIO;

public class EditorView extends View {
  private EditorController controller;
  private JEditorPane editor;
  private JButton saveButton;
  private JButton imageButton;
  final JFileChooser fc = new JFileChooser();
  
  

  public EditorView(EditorController controller) {
    super("New Blog Message");
    this.controller = controller;
    this.setSize(800, 400);

    GridBagConstraints c = new GridBagConstraints();

    editor = new JEditorPane();
    editor.setContentType("text/html");
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.fill = GridBagConstraints.BOTH;
    this.add(editor, c);
    
    imageButton = new JButton("Upload an image");
    imageButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
        Image image = null;
        try {
        
        fc.addChoosableFileFilter(new ImageFilter());
        fc.setAcceptAllFileFilterUsed(false);
        fc.showOpenDialog(imageButton);
        File image1 = fc.getSelectedFile();  
        image = ImageIO.read(image1);
           } catch (IOException x) 
                        
            {}}
    });
    
    
    
    c.gridx = 0;
    c.gridy = 1;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.weightx = 1.0;
    c.weighty = 0;
    c.fill = GridBagConstraints.HORIZONTAL;
    this.add(imageButton, c);
    toggle(false);

    saveButton = new JButton("Save");
    saveButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
         if (controller.save(getDocument())) {
           toggle(false);
         }
      }
    });
    c.gridx = 0;
    c.gridy = 2;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.weightx = 1.0;
    c.weighty = 0;
    c.fill = GridBagConstraints.HORIZONTAL;
    this.add(saveButton, c);
    toggle(false);
    
  }
  HTMLDocument getDocument() {
    return (HTMLDocument)editor.getDocument();
  }
  
 
}
