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
    model.addUser(model.getUserCount(), username, password); // replace id with hash
    main.loggedIn();
    return true;
  }

  public boolean login(String username, String password) {
    main.loggedIn();
    return true;
  }

}
