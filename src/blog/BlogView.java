package blog;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class BlogView extends View {
    private MainController controller;
    private JPanel contentPane;
    
    public BlogView(MainController controller) {
      super("Blog");
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      this.setSize(800, 400);

      JButton editorButton = new JButton("New Blog Message");
      editorButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          controller.toggleEditor(true);
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

      JButton searchButton = new JButton("Search");
      editorButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          //searchByKeyword();
        }
      });
      c.gridx = 1;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(searchButton, c);
      
      JButton timeButton = new JButton("Time Control");
      timeButton.addActionListener(new ActionListener() {

        public void actionPerformed(ActionEvent e) {
          controller.toggleTime(true);
        }
      });
      c.gridx = 2;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 0;
      c.fill = GridBagConstraints.HORIZONTAL;
      add(timeButton, c);

      contentPane = new JPanel();
      contentPane.setBackground(Color.BLACK);
      contentPane.setLayout(new GridBagLayout());
      c.gridx = 0;
      c.gridy = 1;
      c.gridwidth = 3;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.BOTH;
      add(contentPane, c);
      
      ArrayList<Blog> blogs =  controller.getBlogs();
      for (int i = 0; i < blogs.size(); i++) {
        c.gridy = i;
        contentPane.add(new BlogPanel(blogs.get(i).getOwner().getUsername()), c);
      }
    }
}
