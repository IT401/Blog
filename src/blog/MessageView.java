package blog;

public class MessageView extends View {
    MainController controller;
    BlogMessage message;
    
    MessageView(MainController controller) {
      super("");
      setSize(800, 400);
      toggle(false);
    }
    
    MessageView(MainController controller, BlogMessage message) {
      super(message.getTitle());
      setSize(800, 400);  
      toggle(false);
    }
    
    public void setMessage(BlogMessage message) {
      this.message = message;
      setTitle(message.getTitle());
      repaint();
    }
}
