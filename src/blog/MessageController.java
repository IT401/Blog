package blog;

public class MessageController {
    private MainController main;
    private MessageView view;

  	public MessageController(MainController main) {
  		this.main = main;
      view = new MessageView(this);
  	}
    
    public void setMessage(BlogMessage message) {
      view.setMessage(message);
    }
    
    public void showView() {
      view.toggle(true);
    }
}
