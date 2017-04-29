package blog;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.swing.text.html.HTMLDocument;

public class BlogController {
  private MainController main;
  private BlogModel model;
  private BlogView view;
  private ArrayList<MessagePanel> panels = new ArrayList<MessagePanel>();

	public BlogController(MainController main, BlogModel model) {
		this.main = main;
		this.model = model;
		view = new BlogView(this);
    
    setupMessagePanels();
	}
  
  public void setupMessagePanels(ArrayList<BlogMessage> messages) {
    for (BlogMessage message : messages) {
      panels.add(new MessagePanel(message, calculateTime(message.getDate(), main.getDate()), this));
    }
    view.updateBlogPanels(panels);
  }
  
  public void setupMessagePanels() {
    setupMessagePanels(model.getBlogMessages());
  }
  
  public void clickedBlogPanel(BlogMessage message) {
    main.showMessage(message);
  }
  
  public void clickedTimeButton() {
    main.showTime();
  }
  
  public void clickedEditorButton() {
    main.showEditor();
  }
  
  public void clickedSearchButton(String keyword) {
    if (!"".equals(keyword)) {
      setupMessagePanels(searchByKeyword(model.getBlogMessages(), keyword));
    }
  }
  
  public void updatePanelDates(Date date) {
    for (MessagePanel panel : panels) {
      panel.setTime(calculateTime(panel.getMessage().getDate(), main.getDate()));
    }
  }
  
  public void showView() {
    view.toggle(true);
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
}
