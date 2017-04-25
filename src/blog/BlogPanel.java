package blog;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class BlogPanel extends JPanel {
    GridBagConstraints c = new GridBagConstraints();
    BlogMessage message;
    JTextField titleField;
    JTextField userField;
    
    BlogPanel(BlogMessage message, String username, MainController controller) {
      super();
      setLayout(new GridBagLayout());
      setBackground(new Color(238,238,238));
      MouseListener backgroundChanger = new MouseListener() {
        @Override
        public void mouseEntered(MouseEvent e) {
          setBackground(new Color(224,224,224));
        }

        @Override
        public void mouseExited(MouseEvent e) {
          setBackground(new Color(238,238,238));
        }
        
        @Override
        public void mouseClicked(MouseEvent e) {
            controller.clickedBlogPanel(message);
        }
        @Override
        public void mousePressed(MouseEvent e) {}  
        @Override
        public void mouseReleased(MouseEvent e) {}
      };
      this.addMouseListener(backgroundChanger);
      
      titleField = new JTextField(message.getTitle()) {
        @Override 
        public void setBorder(Border border) {} // stop from setting native border
      };
      titleField.setEditable(false);
      titleField.setOpaque(false);
      titleField.addMouseListener(backgroundChanger);
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.insets = new Insets(0, 5, 0, 5);
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(titleField, c);
      
      userField = new JTextField(username) {
        @Override 
        public void setBorder(Border border) {} // stop from setting native border
      };
      userField.setEditable(false);
      userField.setHorizontalAlignment(JTextField.RIGHT);
      userField.setOpaque(false);
      userField.addMouseListener(backgroundChanger);
      c.gridy = 1;
      add(userField, c);
    }
}
