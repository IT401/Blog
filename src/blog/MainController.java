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
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author Liudas
 */
public class MainController {
    private JFrame window;
    private JPanel contentPane;
    private EditorController editorController;
    private AuthController authController;

    public MainController() {
      // setup main window
      window = new JFrame("Blog");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setSize(800, 400);
      window.setLayout(new GridBagLayout());

      GridBagConstraints c = new GridBagConstraints();

      // something for time control here?

      // setup login window
      authController = new AuthController(this);
      editorController = new EditorController(this);

      // get user blog around here
      // stubs for blog
      User owner = new User("Stub", "stub");
      Blog blog = new Blog(new ArrayList<BlogMessage>(), owner);
      //blog.addMessage(new BlogMessage());

      //setup header
      JButton editorButton = new JButton("New Blog Message");
      editorButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          editorController.toggle(true);
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
          //searchByKeyword();
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
      c.gridx = 0;
      c.gridy = 1;
      c.gridwidth = 2;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.BOTH;
      window.add(contentPane, c);

      window.setVisible(false);
    }

    public void loggedIn() {
      window.setVisible(true);
    }

    // this method should be in a custom search controller?
    public ArrayList<BlogMessage> searchByKeyword(ArrayList<BlogMessage> messages, String keyword) {
      ArrayList<BlogMessage> foundMessages = new ArrayList<BlogMessage>();
      HTMLDocument document;
      String text;

      for (BlogMessage message : messages) {
        document = message.getDocument();
        try {
          text = document.getText(0, document.getLength());
          if(text.matches(keyword)) {
            foundMessages.add(message);
          }
        } catch(Exception e) {

        }
      }
      return foundMessages;
    }
}
