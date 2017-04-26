package blog;

import java.awt.GridBagConstraints;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;

public class MessageView extends View {
    private MainController controller;
    private BlogMessage message;
    private JEditorPane text;
    private JScrollPane scrollPane;
    
    MessageView(MainController controller) {
      super("");
      setSize(800, 400);
      
      text = new JEditorPane();
      scrollPane = new JScrollPane(text);
      text.setContentType("text/html");
      text.setEditable(false);
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 2;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.BOTH;
      add(scrollPane, c);
      
      toggle(false);
    }
    
    MessageView(MainController controller, BlogMessage message) {
      this(controller);
      this.message = message;
      setTitle(message.getTitle());
      text.setDocument(message.getDocument());
    }
    
    public void setMessage(BlogMessage message) {
      this.message = message;
      setTitle(message.getTitle());
      text.setDocument(message.getDocument());
      repaint();
    }
}
