package blog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class CommentPanel extends JPanel {
    GridBagConstraints c = new GridBagConstraints();
    Comment comment;
    JTextField userField;
    JTextArea textField;
    
    CommentPanel(Comment comment) {
      super();
      this.comment = comment;
      
      setLayout(new GridBagLayout());
      setBackground(new Color(238,238,238));
      setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.black));
      setPreferredSize(new Dimension(0, 50));
      setMaximumSize(new Dimension((int)getMaximumSize().getWidth(), 60));

      
      userField = new JTextField(comment.getUser().getUsername()) {
        @Override 
        public void setBorder(Border border) {} // stop from setting native border
      };
      userField.setEditable(false);
      userField.setOpaque(false);

      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.insets = new Insets(0, 5, 0, 5);
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(userField, c);
      
      textField = new JTextArea(comment.getText()) {
        @Override 
        public void setBorder(Border border) {} // stop from setting native border
      };
      textField.setEditable(false);
      textField.setOpaque(false);
      c.gridy = 1;
      add(textField, c);
    }
    
    public Comment getComment() {
      return comment;
    }
}
