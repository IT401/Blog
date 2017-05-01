package blog;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class MessageView extends JPanel {
    private MessageController controller;
    private BlogMessage message;
    private JEditorPane text;
    private JScrollPane scrollPane;
    
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
      
      scrollPane = new JScrollPane(text);
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.BOTH;
      add(scrollPane, c);
      
      JButton returnButton = new JButton("< Return");
      returnButton.addActionListener(new ActionListener() {
  
        public void actionPerformed(ActionEvent e) {
          controller.clickedReturnButton();
        }
      });
      c.gridy = 2;
      c.weighty = 0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(returnButton, c);
    }
}
