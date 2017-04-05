package blog;

public class AuthController {
  private MainController main;

  public AuthController(MainController controller) {
    main = controller;
  }

  public boolean register(String username, String password) {
    // save user to 'database'
    return true;
  }

  public boolean login(String username, String password) {
    // return user object or just bool?
    main.loggedIn();
    return true;
  }

}
