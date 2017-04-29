package blog;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JTextField;

public class TimeView extends View {
    private TimeController controller;
    private JButton addButton, subButton;
    private JTextField dateField;

    public TimeView(TimeController controller) {
        super("Time Control");
        this.controller = controller;
        
        addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
    
          public void actionPerformed(ActionEvent e) {
             controller.clickedAddButton();
          }
        });
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.fill = GridBagConstraints.HORIZONTAL;
        add(addButton, c);
        
        subButton = new JButton("-");
        subButton.addActionListener(new ActionListener() {
    
          public void actionPerformed(ActionEvent e) {
             controller.clickedSubButton();
          }
        });
        c.gridx = 2;
        add(subButton, c);
        
        dateField = new JTextField();
        dateField.setEditable(false);
        dateField.setPreferredSize(new Dimension(200, 25));
        c.gridx = 1;
        add(dateField, c);
        pack();
    }
    
    public void updateDateField(String date) {
      dateField.setText(date);
    }
}
