package blog;

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
        
        GridBagConstraints c = new GridBagConstraints();
        
        addButton = new JButton("+");
        addButton.addActionListener(new ActionListener() {
    
          public void actionPerformed(ActionEvent e) {
             controller.increase();
             updateDateField();
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
             controller.decrease();
             updateDateField();
          }
        });
        c.gridx = 2;
        add(subButton, c);
        
        dateField = new JTextField();
        dateField.setEditable(false);
        updateDateField();
        c.gridx = 1;
        add(dateField, c);
        pack();
    }
    
    private void updateDateField() {
      dateField.setText(controller.getDate().toString());
    }
}
