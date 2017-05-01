package blog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * Handles message panel GUI.
 */
public class MessagePanelView extends JPanel {
  private MessagePanelController controller;
  private JPanel panelPane;
  
  MessagePanelView(MessagePanelController controller) {
    super();
    this.controller = controller;
    setLayout(new GridBagLayout());
    
    setupComponents();
  }
  
  private void setupComponents() {
    GridBagConstraints c = new GridBagConstraints();
    
    panelPane = new JPanel();
    panelPane.setLayout(new BoxLayout(panelPane, BoxLayout.PAGE_AXIS));
    
    JScrollPane scrollPane = new JScrollPane(panelPane);
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 1;
    c.gridheight = 1;
    c.weightx = 1.0;
    c.weighty = 1.0;
    c.fill = GridBagConstraints.BOTH;
    add(scrollPane, c);
  }
  
  public void updateBlogPanels(ArrayList<MessagePanel> messagePanels) {
    panelPane.removeAll();
    for (MessagePanel messagePanel : messagePanels) {
      panelPane.add(messagePanel);
    }
    panelPane.revalidate();
    panelPane.repaint();
  }
}
