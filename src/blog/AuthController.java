package blog;

public class AuthController {
  private MainController main;
  private UserModel model;
  private LoginView view;

  public AuthController(MainController main, UserModel model) {
    this.main = main;
    this.model = model;
    view = new LoginView(this);
  }

  public boolean clickedRegisterButton(String username, String password) {
    if ("".equals(username) || "".equals(password) || model.userExists(username)) {
      return false;
    }
    model.addUser(model.getUserCount(), username, password); // replace id with hash
    main.showBlog();
    return true;
  }

  public boolean clickedLoginButton(String username, String password) {
    main.showBlog();
    return true;
  }

}
