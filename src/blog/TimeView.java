package blog;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Handles time control element GUI.
 */
public class TimeView extends JPanel {
    private TimeController controller;
    private JButton addButton, subButton;
    private JTextField dateField;

    public TimeView(TimeController controller) {
        super();
        this.controller = controller;
        setPreferredSize(new Dimension(50, 0));
        setLayout(new GridBagLayout());
        
        setupComponents();
    }
    
    public void updateDateField(String date) {
      dateField.setText(date);
    }
    
    private void setupComponents() {
      GridBagConstraints c = new GridBagConstraints();
      addButton = new JButton("+");
      addButton.addActionListener(new ActionListener() {
  
        public void actionPerformed(ActionEvent e) {
           controller.clickedAddButton();
        }
      });
      c.gridx = 1;
      c.gridy = 1;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(addButton, c);
      
      subButton = new JButton("-");
      subButton.addActionListener(new ActionListener() {
  
        public void actionPerformed(ActionEvent e) {
           controller.clickedSubButton();
        }
      });
      c.gridx = 0;
      c.gridy = 1;
      add(subButton, c);
      
      dateField = new JTextField();
      dateField.setEditable(false);
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 2;
      add(dateField, c);
    }
}
