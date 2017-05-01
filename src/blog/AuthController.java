package blog;

import javax.swing.JOptionPane;

public class AuthController {
  private MainController main;
  private UserModel model;
  private LoginView view;
  private User activeUser;
  
  /**
   * Authentication controller takes care of user login & register functionality.
   * @param main Main controller.
   * @param model User data control model.
   */
  public AuthController(MainController main, UserModel model) {
    this.main = main;
    this.model = model;
    view = new LoginView(this);
  }
  
  public User getActiveUser() {
    return activeUser;
  }

  public boolean clickedRegisterButton(String username, String password) {
    if ("".equals(username) || "".equals(password)) {
      JOptionPane.showMessageDialog(null, "Please, enter a username and a password.", "Authentication Error", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    if (model.userExists(username)) {
      JOptionPane.showMessageDialog(null, "This user alredy exists!", "Authentication Error", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    User user = new User(model.getUserCount()+1, username, password);
    main.createdNewUser(user);
    model.addUser(user);
    activeUser = user;
    return true;
  }

  public boolean clickedLoginButton(String username, String password) {
    if ("".equals(username) || "".equals(password)) {
      JOptionPane.showMessageDialog(null, "Please, enter a username and a password.", "Authentication Error", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    if (!model.userExists(username)) {
      JOptionPane.showMessageDialog(null, "This user doesn't exist!", "Authentication Error", JOptionPane.ERROR_MESSAGE);
      return false;
    }
    User user = model.getUser(username);
    if (password.equals(user.getPass())) {
      activeUser = user;
      main.showBlog();
      return true;
    } else {
      JOptionPane.showMessageDialog(null, "The password you entered doesn't match!", "Authentication Error", JOptionPane.ERROR_MESSAGE);
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
