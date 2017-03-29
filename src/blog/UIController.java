/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.Document;

/**
 *
 * @author Liudas
 */
public class UIController {
    private JFrame window;
    private JPanel contentPane, editorPane;
    private JEditorPane editor;

    public UIController() {
      // setup main window
      window = new JFrame("Blog");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setSize(800, 400);
      window.setLayout(new GridBagLayout());

      GridBagConstraints c = new GridBagConstraints();

      /*for (int i = 0; i < 10; i++) {
          panelarr[i] = new BlogMessagePanel(new BlogMessage("Bigger amout of text here Bigger amout of text here Bigger amout of text here "));
          panelarr[i].setBackground(Color.BLACK);
          // set BlogMessages to go one after another
          c.gridx = 0;
          c.gridy = i;
          c.gridwidth = 1;
          // set weights to let messages expand upon window expansion
          c.weightx = 1.0;
          c.weighty = 1.0;
          c.fill = GridBagConstraints.HORIZONTAL;
          window.add(panelarr[i], c);
      }*/
      //setup header
      JButton editorButton = new JButton("New Blog Message");
      editorButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          showEditor();
        }
      });
      c.gridx = 0;
      c.gridy = 0;
      c.weightx = 0.5;
      c.fill = GridBagConstraints.HORIZONTAL;
      window.add(editorButton, c);

      JButton searchButton = new JButton("Search");
      editorButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          showSearch();
        }
      });
      c.gridx = 1;
      c.gridy = 0;
      c.weightx = 0.5;
      c.fill = GridBagConstraints.HORIZONTAL;
      window.add(searchButton, c);

      // setup main content pane
      contentPane = new JPanel();
      contentPane.setLayout(new GridBagLayout());
      contentPane.setBackground(Color.BLACK);
      c.gridx = 0;
      c.gridy = 1;
      c.gridwidth = 2;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.BOTH;
      window.add(contentPane, c);

      //NOTE: rewrite editor pane as a custom window
      // setup editor pane
      editorPane = new JPanel();
      editorPane.setLayout(new GridBagLayout());
      editorPane.setBackground(Color.RED);
      editorPane.setVisible(false);
      editor = new JEditorPane();
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 2;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.BOTH;
      editorPane.add(editor, c);
      c.gridy = 1;
      window.add(editorPane, c);

      window.setVisible(true);
    }

    public void showEditor() {
      // set visibility to editorpane
      contentPane.setVisible(false);
      editorPane.setVisible(true);
    }

    public Document getDocument() {
      return editor.getDocument();
    }

    public void showContent() {
      editorPane.setVisible(false);
      contentPane.setVisible(true);
    }

    public void showSearch() {

    }
}
