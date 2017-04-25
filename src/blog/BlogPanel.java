package blog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BlogPanel extends JPanel {
    GridBagConstraints c = new GridBagConstraints();
    JTextField titleField;
    
    BlogPanel(String title) {
      super();
      this.setLayout(new GridBagLayout());
      
      titleField = new JTextField(title);
      titleField.setEditable(false);
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(titleField, c);
    }
}
