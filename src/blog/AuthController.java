package blog;

public class AuthController {
  private MainController main;
  private UserModel model;

  public AuthController(MainController controller, UserModel model) {
    main = controller;
    this.model = model;
  }

  public boolean register(String username, String password) {
    if ("".equals(username) || "".equals(password) || model.userExists(username)) {
      return false;
    }
    model.addUser(username, password);
    main.loggedIn();
    return true;
  }

  public boolean login(String username, String password) {
    // return user object or just bool?
    main.loggedIn();
    return true;
  }

}
