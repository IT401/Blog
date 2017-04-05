/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author Liudas
 */
public class EditorView extends JFrame {
  private EditorController controller;
  private JEditorPane editor;
  private JButton saveButton;

  public EditorView(EditorController controller) {
    this.controller = controller;
    this.setLayout(new GridBagLayout());
    this.setSize(800, 400);

    GridBagConstraints c = new GridBagConstraints();

    editor = new JEditorPane();
    editor.setContentType("text/html");
    editor.setText("<p>Random shit</p><img width=\"200\" height=\"200\" src=\"file:C:\\Users\\Liudas\\Google Drive\\Projects\\OOP\\Blogsite\\Blog\\shiz.jpg\" />");
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.fill = GridBagConstraints.BOTH;
    this.add(editor, c);

    saveButton = new JButton("Save");
    saveButton.addActionListener(new ActionListener() {

      public void actionPerformed(ActionEvent e) {
         if (controller.save(getDocument())) {
           toggle(false);
         }
      }
    });
    c.gridx = 0;
    c.gridy = 1;
    c.gridwidth = 2;
    c.gridheight = 1;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.fill = GridBagConstraints.HORIZONTAL;
    this.add(saveButton, c);
    toggle(false);
  }

  public void toggle(boolean isVisible) {
    this.setVisible(isVisible);
  }

  HTMLDocument getDocument() {
    return (HTMLDocument)editor.getDocument();
  }
}
