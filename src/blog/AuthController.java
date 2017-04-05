/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

/**
 *
 * @author Liudas
 */
public class AuthController {
  private MainController controller;
  private LoginView view;

  public AuthController(MainController controller) {
    this.controller = controller;
    view = new LoginView(this);
  }

  public boolean register(String username, String password) {
    // save user to 'database'
    return true;
  }

  public boolean login(String username, String password) {
    // return user object or just bool?
    controller.loggedIn();
    return true;
  }

}
