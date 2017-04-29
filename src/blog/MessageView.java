package blog;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import javax.swing.border.Border;

public class MessageView extends View {
    private MessageController controller;
    private BlogMessage message;
    private JEditorPane text;
    private JScrollPane scrollPane;
    
    MessageView(MessageController controller) {
      super("");
      setSize(800, 400);
      
      text = new JEditorPane() {
        @Override 
        public void setBorder(Border border) {} // stop from setting native border
      };
      scrollPane = new JScrollPane(text) {
        @Override 
        public void setBorder(Border border) {} // stop from setting native border
      };
      text.setContentType("text/html");
      text.setEditable(false);
      text.setBackground(new Color(238,238,238));
      c.gridx = 0;
      c.gridy = 0;
      c.insets = new Insets(0, 5, 0, 5);
      c.gridwidth = 2;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.BOTH;
      add(scrollPane, c);
      
      toggle(false);
    }
    
    MessageView(MessageController controller, BlogMessage message) {
      this(controller);
      setMessage(message);
    }
    
    public void setMessage(BlogMessage message) {
      this.message = message;
      setTitle(message.getTitle());
      message.getDocument().getStyleSheet().addRule("body {font-family:Arial;background-color:rgb(238,238,238);color:rgb(33,33,33);}");
      text.setDocument(message.getDocument());
      repaint();
    }
}
