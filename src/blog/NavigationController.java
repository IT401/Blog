package blog;

/**
 * Handles navigation and search functionality.
 */
public class NavigationController {
  MainController main;
  NavigationView view;
  UserModel model;
  
  NavigationController(MainController main, UserModel model) {
    this.main = main;
    this.model = model;
    view = new NavigationView(this, model.getUsers());
  }
  
  public void clickedEditorButton() {
    main.showEditor();
  }
  
  public void clickedMyMessageButton() {
    main.showOwnMessagePanels();
  }
  
  public void clickedAllMessageButton() {
    main.showAllMessagePanels();
  }
  
  public void clickedSearchButton(String keyword) {
    if (!"".equals(keyword)) {
      main.showFilteredMessagePanels(keyword);
    }
  }
  
  public void selectedUser(User user) {
    main.showFilteredMessagePanels(user);
  }
  
  public NavigationView getView() {
    return view;
  };
  
  public void showView(boolean show) {
    view.setVisible(show);
  }
}
