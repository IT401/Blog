package blog;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainController {
    private JFrame window;
    
    private NavigationController navigationController;
    private MessagePanelController messagePanelController;
    private EditorController editorController;
    private AuthController authController;
    private TimeController timeController;
    private MessageController messageController;
    
    private UserModel userModel;
    private BlogModel blogModel;

    public MainController() {
      window = new JFrame("Blog App");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setSize(800, 400);
      window.setLayout(new GridBagLayout());
      window.setVisible(true);
      
      // setup models
      userModel = new UserModel();
      blogModel = new BlogModel();
      blogModel.readBlogs(userModel.getUsers());
      
      // setup controllers
      authController = new AuthController(this, userModel);
      navigationController = new NavigationController(this);
      timeController = new TimeController(this);  
      messagePanelController = new MessagePanelController(this, blogModel);
      messageController = new MessageController(this);
      editorController = new EditorController(this, blogModel);
      
      attachViews();
    }
    
    public void attachViews() {
      GridBagConstraints c = new GridBagConstraints();
      
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 1.0;
      c.weighty = 1.0;
      c.fill = GridBagConstraints.BOTH;
      window.add(authController.getView(), c);
      
      c.gridx = 0;
      c.gridy = 0;
      c.gridwidth = 1;
      c.gridheight = 1;
      c.weightx = 0.25;
      c.weighty = 0.90;
      c.fill = GridBagConstraints.BOTH;
      window.add(navigationController.getView(), c);
      navigationController.showView(false);
      
      c.gridy = 1;
      c.weighty = 0.10;
      c.gridheight = 1;
      window.add(timeController.getView(), c);
      timeController.showView(false);
      
      c.gridy = 0;
      c.gridx = 1;
      c.gridwidth = 1;
      c.gridheight = 2;
      c.weightx = 1.0;
      window.add(messagePanelController.getView(), c);
      messagePanelController.showView(false);
      
      window.add(messageController.getView(), c);
      messageController.showView(false);
      
      window.add(editorController.getView(), c);
      editorController.showView(false);
    }
    
    public User getActiveUser() {
      return authController.getActiveUser();
    }

    public void showMessage(BlogMessage message) {
      messageController.setMessage(message);
      messageController.showView(true);
      messagePanelController.showView(false);
      editorController.showView(false);
    }
    
    public void showFilteredMessagePanels(String keyword) {
      messagePanelController.filterMessagePanels(keyword);
      showMessagePanels();
    }
    
    public void showAllMessagePanels() {
      messagePanelController.setupMessagePanels();
      showMessagePanels();
    }
    
    public void showOwnMessagePanels() {
      messagePanelController.setupMessagePanels(authController.getActiveUser());
      showMessagePanels();
    }
    
    public void showMessagePanels() {
      messagePanelController.showView(true);
      messageController.showView(false);
      editorController.showView(false);
    }
    
    public void showEditor() {
      editorController.showView(true);
      messageController.showView(false);
      messagePanelController.showView(false);
    }
    
    public void showBlog() {
      navigationController.showView(true);
      timeController.showView(true);
      messagePanelController.showView(true);
      authController.showView(false);
    }
    
    public Date getDate() {
      return timeController.getDate();
    }
    
    public void dateChanged(Date date) {
      messagePanelController.updatePanelDates(date);
    }
}
