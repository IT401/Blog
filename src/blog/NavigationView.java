package blog;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Handles navigation and search GUI.
 */
public class NavigationView extends JPanel {
    private NavigationController controller;
    private JButton editorButton;
    private JButton myMessagesButton;
    private JButton allMessagesButton;
    private JButton searchButton;
    private JTextField searchField;
    
    NavigationView(NavigationController controller, ArrayList<User> users) {
      super();
      this.controller = controller;
      setPreferredSize(new Dimension(50, 0));
      setLayout(new GridBagLayout());
      
      setupComponents(users);
    }
    
    private void setupComponents(ArrayList<User> users) {
      GridBagConstraints c = new GridBagConstraints();
      JPanel container = new JPanel();
      container.setLayout(new GridBagLayout());
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.anchor = GridBagConstraints.PAGE_START;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(container, c);
      
      editorButton = new JButton("New Blog Message");
      editorButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          controller.clickedEditorButton();
        }
      });
      container.add(editorButton, c);
      
      myMessagesButton = new JButton("My Messages");
      myMessagesButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          controller.clickedMyMessageButton();
        }
      });
      c.gridy = 1;
      container.add(myMessagesButton, c);
      
      allMessagesButton = new JButton("All Messages");
      allMessagesButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          controller.clickedAllMessageButton();
        }
      });
      c.gridy = 2;
      container.add(allMessagesButton, c);
      
      searchField = new JTextField();
      c.gridy = 3;
      c.insets = new Insets(25, 0, 0, 0);
      container.add(searchField, c);

      searchButton = new JButton("Search");
      searchButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          controller.clickedSearchButton(getKeyword());
        }
      });
      c.gridy = 4;
      c.insets = new Insets(0, 0, 0, 0);
      container.add(searchButton, c);
      
      JLabel userLabel = new JLabel("Search by user");
      c.gridy = 5;
      container.add(userLabel, c);
      
      JComboBox userBox = new JComboBox(users.toArray());
      userBox.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          JComboBox ub = (JComboBox)e.getSource();
          User user = (User)ub.getSelectedItem();
          controller.selectedUser(user);
        }
      });
      c.gridy = 6;
      container.add(userBox, c);
    }
    
    private String getKeyword() {
      return searchField.getText();
    }
}
