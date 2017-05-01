package blog;

public class AuthController {
  private MainController main;
  private UserModel model;
  private LoginView view;
  private User activeUser;

  public AuthController(MainController main, UserModel model) {
    this.main = main;
    this.model = model;
    view = new LoginView(this);
  }
  
  public User getActiveUser() {
    return activeUser;
  }

  public boolean clickedRegisterButton(String username, String password) {
    if ("".equals(username) || "".equals(password) || model.userExists(username)) {
      return false;
    }
    User user = new User(model.getUserCount()+1, username, password);
    main.createdNewUser(user);
    model.addUser(user);
    activeUser = user;
    return true;
  }

  public boolean clickedLoginButton(String username, String password) {
    if ("".equals(username) || "".equals(password) || !model.userExists(username)) {
      return false;
    }
    User user = model.getUser(username);
    if (password.equals(user.getPass())) {
      activeUser = user;
      main.showBlog();
      return true;
    }
    return false;
  }
  
  public void showView(boolean show) {
    view.setVisible(show);
  }
  
  public LoginView getView() {
    return view;
  }

}
