package blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.text.html.HTMLDocument;

public class MessagePanelController {
  private MainController main;
  private MessagePanelView view;
  private BlogModel model;
  private ArrayList<MessagePanel> panels = new ArrayList<MessagePanel>();
  
  MessagePanelController(MainController main, BlogModel model) {
    this.main = main;
    this.model = model;
    view = new MessagePanelView(this);
    
    setupMessagePanels();
  }
  
  public void setupMessagePanels(ArrayList<BlogMessage> messages) {
    panels = new ArrayList<MessagePanel>();
    for (BlogMessage message : messages) {
      panels.add(new MessagePanel(message, calculateTime(message.getDate(), main.getDate()), this));
    }
    view.updateBlogPanels(panels);
  }
  
  public void setupMessagePanels(User user) {
    for (Blog blog : model.getBlogs()) {
      if (blog.getOwner().getUsername().compareTo(user.getUsername()) == 0) {
        setupMessagePanels(blog.getMessages());
        break;
      }
    }
  }
  
  public void setupMessagePanels() {
    setupMessagePanels(model.getBlogMessages());
  }
  
  public void filterMessagePanels(String keyword) {
    setupMessagePanels(searchByKeyword(model.getBlogMessages(), keyword));
  }
  
  public void clickedBlogPanel(BlogMessage message) {
    main.showMessage(message);
  }
  
  public void updatePanelDates(Date date) {
    for (MessagePanel panel : panels) {
      panel.setTime(calculateTime(panel.getMessage().getDate(), main.getDate()));
    }
  }
  
  public MessagePanelView getView() {
    return view;
  }
  
  public void showView(boolean show) {
    view.setVisible(show);
  }
  
  private ArrayList<BlogMessage> searchByKeyword(ArrayList<BlogMessage> messages, String keyword) {
    ArrayList<BlogMessage> foundMessages = new ArrayList<BlogMessage>();
    HTMLDocument document;
    String text;

    for (BlogMessage message : messages) {
      document = message.getDocument();
      try {
        text = document.getText(0, document.getLength());

        if(text.contains(keyword)) {
          foundMessages.add(message);
        }
      } catch(Exception e) {

      }
    }
    return foundMessages;
  }
  
  private String calculateTime(Date creationDate, Date current) {
    long time = current.getTime() - creationDate.getTime();
    if (time < 60000) {
      return TimeUnit.MILLISECONDS.toSeconds(time) + " seconds ago";
    } else if (time < 3600000) {
      return TimeUnit.MILLISECONDS.toMinutes(time) + " minutes ago";
    } else if (time < 86400000) {
      return TimeUnit.MILLISECONDS.toHours(time) + " hours ago";
    } else {
      return TimeUnit.MILLISECONDS.toDays(time) + " days ago";
    }  
  }
  
}
