package blog;

import java.util.ArrayList;
import javax.swing.text.html.HTMLDocument;

public class MainController {
    private BlogView blogView;
    private EditorView editorView;
    private LoginView loginView;
    private TimeView timeView;
    
    private EditorController editorController;
    private AuthController authController;
    private TimeController timeController;
    
    private UserModel userModel;

    public MainController() {
      // setup models
      userModel = new UserModel();
      
      // setup controllers
      authController = new AuthController(this, userModel);
      editorController = new EditorController(this);
      timeController = new TimeController(this);

      // setup views
      blogView = new BlogView(this);
      editorView = new EditorView(editorController);
      loginView = new LoginView(authController);
      timeView = new TimeView(timeController);
    }

    public void loggedIn() {
      blogView.toggle(true);
    }

    public void toggleEditor(boolean isVisible) {
      editorView.toggle(isVisible);
    }

    public void toggleLogin(boolean isVisible) {
      loginView.toggle(isVisible);
    }

    public void toggleBlog(boolean isVisible) {
      blogView.toggle(isVisible);
    }
    
    public void toggleTime(boolean isVisible) {
      timeView.toggle(isVisible);
    }

    // move method to a custom search controller
    public ArrayList<BlogMessage> searchByKeyword(ArrayList<BlogMessage> messages, String keyword) {
      ArrayList<BlogMessage> foundMessages = new ArrayList<BlogMessage>();
      HTMLDocument document;
      String text;

      for (BlogMessage message : messages) {
        document = message.getDocument();
        try {
          text = document.getText(0, document.getLength());
          if(text.matches(keyword)) {
            foundMessages.add(message);
          }
        } catch(Exception e) {

        }
      }
      return foundMessages;
    }
}
