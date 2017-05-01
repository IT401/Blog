package blog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Date;
import javax.swing.JFrame;

/**
 * Handles the main application window structure and communication between models and controllers.
 */
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
    private CommentModel commentModel;

    public MainController() {
      // setup main window 
      window = new JFrame("Blog App");
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      window.setSize(1000, 600);
      window.setLayout(new GridBagLayout());
      window.setVisible(true);
      
      // setup models
      userModel = new UserModel();
      blogModel = new BlogModel();
      blogModel.readBlogs(userModel.getUsers());
      commentModel = new CommentModel();
      commentModel.readComments(blogModel.getBlogMessages(), userModel);
      
      // setup controllers
      authController = new AuthController(this, userModel);
      navigationController = new NavigationController(this, userModel);
      timeController = new TimeController(this);  
      messagePanelController = new MessagePanelController(this, blogModel);
      messageController = new MessageController(this, commentModel);
      editorController = new EditorController(this, blogModel);
      
      attachViews();
    }
    
    /**
     * Attach different GUI parts to the main window using GridBag layout.
     */
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
    
    public void createdNewUser(User user) {
      blogModel.addBlog(user);
      showBlog();
    }
    
    /**
     * Returns currently logged in user.
     * @return Logged in User object.
     */
    public User getActiveUser() {
      return authController.getActiveUser();
    }
    
    /**
     * Sends given message to the controller and enables message display GUI.
     * @param message BlogMessage to be shown.
     */
    public void showMessage(BlogMessage message) {
      messageController.setMessage(message);
      messageController.showView(true);
      messagePanelController.showView(false);
      editorController.showView(false);
    }
    
    /**
     * Shows messages in message panel GUI according to a keyword.
     * @param keyword Search query string.
     */
    public void showFilteredMessagePanels(String keyword) {
      messagePanelController.filterMessagePanels(keyword);
      showMessagePanels();
    }
    
    /**
     * Shows messages in message panel GUI belonging to user.
     * @param keyword Search query string.
     */
    public void showFilteredMessagePanels(User user) {
      messagePanelController.setupMessagePanels(user);
      showMessagePanels();
    }
    
    /**
     * Shows all messages in message panel GUI.
     */
    public void showAllMessagePanels() {
      messagePanelController.setupMessagePanels();
      showMessagePanels();
    }
    
    /**
     * Shows current users messages in message panel GUI.
     */
    public void showOwnMessagePanels() {
      messagePanelController.setupMessagePanels(authController.getActiveUser());
      showMessagePanels();
    }
    
    /**
     * Enables message panel GUI.
     */
    public void showMessagePanels() {
      messagePanelController.showView(true);
      messageController.showView(false);
      editorController.showView(false);
    }
    
    /**
     * Enables editor GUI.
     */
    public void showEditor() {
      editorController.showView(true);
      messageController.showView(false);
      messagePanelController.showView(false);
    }
    
    /**
     * Enables main GUI elements after user has logged in/registered.
     */
    public void showBlog() {
      navigationController.showView(true);
      timeController.showView(true);
      messagePanelController.showView(true);
      authController.showView(false);
    }
    
    /**
     * Returns "current" date.
     * @return Date object.
     */
    public Date getDate() {
      return new Date(timeController.getDate().getTime());
    }
    
    /**
     * Is called when "current" date has been changed. Notifies other elements.
     * @param date 
     */
    public void dateChanged(Date date) {
      messagePanelController.updatePanelDates(date);
    }
}
