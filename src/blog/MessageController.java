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
    
    public void clickedReturnButton() {
      main.showMessagePanels();
    }
    
    public MessageView getView() {
      return view;
    }
    
    public void showView(boolean show) {
      view.setVisible(show);
    }
}
