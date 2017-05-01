package blog;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Handles message display GUI.
 */
public class MessageView extends JPanel {
    private MessageController controller;
    private BlogMessage message;
    private JEditorPane text;
    private JPanel panelPane;
    private JTextArea commentField;
    
    MessageView(MessageController controller) {
      super();
      this.controller = controller;
      setLayout(new GridBagLayout());  
      
      setupComponents();
    }
    
    MessageView(MessageController controller, BlogMessage message) {
      this(controller);
      setMessage(message);
    }
    
    public void setMessage(BlogMessage message) {
      this.message = message;
      message.getDocument().getStyleSheet().addRule("body {font-family:Arial;background-color:rgb(238,238,238);color:rgb(33,33,33);}");
      text.setDocument(message.getDocument());
      repaint();
    }
    
    private void setupComponents() {
      GridBagConstraints c = new GridBagConstraints();
      
      text = new JEditorPane();
      text.setContentType("text/html");
      text.setEditable(false);
      text.setBackground(new Color(238,238,238));
      
      JButton returnButton = new JButton("< Return");
      returnButton.addActionListener(new ActionListener() {
        
        public void actionPerformed(ActionEvent e) {
          controller.clickedReturnButton();
        }
      });
      c.gridy = 0;
      c.weighty = 0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(returnButton, c);
      
      JScrollPane scrollPane = new JScrollPane(text);
      c.gridx = 0;
      c.gridy = 1;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.BOTH;
      add(scrollPane, c);
      
      JLabel commentLabel = new JLabel("Comments");
      c.gridy = 2;
      c.weighty = 0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(commentLabel, c);
      
      panelPane = new JPanel();
      panelPane.setLayout(new BoxLayout(panelPane, BoxLayout.PAGE_AXIS));
      
      JScrollPane scrollPane2 = new JScrollPane(panelPane);
      c.gridx = 0;
      c.gridy = 3;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 0.30;
      c.fill = GridBagConstraints.BOTH;
      add(scrollPane2, c);
      
      JLabel commentFieldLabel = new JLabel("Write a comment");
      c.gridy = 4;
      c.weighty = 0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(commentFieldLabel, c);
      
      commentField = new JTextArea();
      c.gridy = 5;
      c.weighty = 0.20;
      c.fill = GridBagConstraints.BOTH;
      add(commentField, c);
      
      JButton commentButton = new JButton("Submit");
      commentButton.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
          controller.clickedCommentButton(getComment());
        }
      });
      c.gridy = 6;
      c.weighty = 0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(commentButton, c);
      
    }
    
    public void updateCommentPanels(ArrayList<CommentPanel> commentPanels) {
      panelPane.removeAll();
      for (CommentPanel commentPanel : commentPanels) {
        panelPane.add(commentPanel);
      }
      panelPane.revalidate();
      panelPane.repaint();
    }
    
    private String getComment() {
      return commentField.getText();
    }
}
