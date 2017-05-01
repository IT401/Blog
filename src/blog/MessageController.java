package blog;

import java.util.ArrayList;

/**
 * Handles message display and comment panel functionality.
 */
public class MessageController {
    private MainController main;
    private CommentModel model;
    private MessageView view;
    private BlogMessage message;
    private ArrayList<CommentPanel> panels;

    public MessageController(MainController main, CommentModel model) {
      this.main = main;
      this.model = model;
      view = new MessageView(this);
    }
    
    public void setupCommentPanels() {
      panels = new ArrayList<CommentPanel>();
      if (message.getComments().size() != 0) {
        for (Comment comment : message.getComments()) {
          panels.add(new CommentPanel(comment));
        }
      }
      view.updateCommentPanels(panels);
    }
    
    public void setMessage(BlogMessage message) {
      this.message = message;
      view.setMessage(message);
      setupCommentPanels();
    }
    
    public void clickedReturnButton() {
      main.showMessagePanels();
    }
    
    public void clickedCommentButton(String text) {
      model.addComment(message, main.getActiveUser(), text);
      setupCommentPanels();
    }
    
    public MessageView getView() {
      return view;
    }
    
    public void showView(boolean show) {
      view.setVisible(show);
    }
}
