package blog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.text.html.HTMLDocument;

public class EditorView extends View {
  private EditorController controller;
  private JEditorPane editor;
  private JButton saveButton;

  public EditorView(EditorController controller) {
    super("New Blog Message");
    this.controller = controller;
    this.setLayout(new GridBagLayout());
    this.setSize(800, 400);

    GridBagConstraints c = new GridBagConstraints();

    editor = new JEditorPane();
    editor.setContentType("text/html");
    editor.setText("<p>Random shit</p><img src='file:shiz.jpg' width=200 height=200 />");
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

  HTMLDocument getDocument() {
    return (HTMLDocument)editor.getDocument();
  }
}
