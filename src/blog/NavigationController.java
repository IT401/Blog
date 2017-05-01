package blog;

public class NavigationController {
  MainController main;
  NavigationView view;
  
  NavigationController(MainController main) {
    this.main = main;
    view = new NavigationView(this);
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
  
  public NavigationView getView() {
    return view;
  };
  
  public void showView(boolean show) {
    view.setVisible(show);
  }
}
