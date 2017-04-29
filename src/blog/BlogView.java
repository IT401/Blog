package blog;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BlogView extends View {
    private BlogController controller;
    private JPanel contentPane;
    private JTextField searchField;
    
    public BlogView(BlogController controller) {
      super("Blog");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(800, 400);

      JButton editorButton = new JButton("New Blog Message");
      editorButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          controller.clickedEditorButton();
        }
      });
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(editorButton, c);
      
      JButton timeButton = new JButton("Time Control");
      timeButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          controller.clickedTimeButton();
        }
      });
      c.gridx = 1;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(timeButton, c);
      
      searchField = new JTextField();
      c.gridx = 2;
      add(searchField, c);

      JButton searchButton = new JButton("Search");
      searchButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          controller.clickedSearchButton(getKeyword());
        }
      });
      c.gridx = 3;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(searchButton, c);
      
      contentPane = new JPanel();
      contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));
      
      JScrollPane scrollPane = new JScrollPane(contentPane);
      c.gridx = 0;
      c.gridy = 1;
      c.gridwidth = 4;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.BOTH;
      add(scrollPane, c);
    }
    
    public void updateBlogPanels(ArrayList<MessagePanel> messagePanels) {
      contentPane.removeAll();
      for (MessagePanel messagePanel : messagePanels) {
        contentPane.add(messagePanel);
      }
      contentPane.revalidate();
      contentPane.repaint();
    }
    
    private String getKeyword() {
      return searchField.getText();
    }
}
