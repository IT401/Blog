package blog;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.text.html.HTMLDocument;

public class MainController {
    private Date time;
    
    private BlogController blogController;
    private EditorController editorController;
    private AuthController authController;
    private TimeController timeController;
    private MessageController messageController;
    
    private UserModel userModel;
    private BlogModel blogModel;

    public MainController() {
      // setup models
      userModel = new UserModel();
      blogModel = new BlogModel();
      blogModel.readBlogs(userModel.getUsers());
      
      // setup controllers
      timeController = new TimeController(this);
      authController = new AuthController(this, userModel);
      blogController = new BlogController(this, blogModel);
      editorController = new EditorController(this);
      messageController = new MessageController(this);
    }

    public void showMessage(BlogMessage message) {
      messageController.setMessage(message);
      messageController.showView();
    }
    
    public void showEditor() {
      editorController.showView();
    }
    
    public void showTime() {
      timeController.showView();
    }
    
    public void showBlog() {
      blogController.showView();
    }
    
    public Date getDate() {
      return timeController.getDate();
    }
    
    public void dateChanged(Date date) {
      blogController.updatePanelDates(date);
    }
}
