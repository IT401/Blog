package blog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Handles logging in and registering GUI.
 */
public class LoginView extends JPanel {
  private AuthController controller;
  private JButton registerButton, loginButton;
  private JTextField usernameField;
  private JPasswordField passwordField;

  public LoginView(AuthController controller) {
     super();
     this.controller = controller;
     setLayout(new GridBagLayout());
     setupComponents();
   }
   
   private void setupComponents() {
     GridBagConstraints c = new GridBagConstraints();
     
     JLabel usernameLabel = new JLabel("Username");
     c.gridx = 0;
     c.gridy = 0;
     c.gridheight = 1;
     c.gridwidth = 1;
     c.weightx = 1.0;
     c.fill = GridBagConstraints.HORIZONTAL;
     add(usernameLabel, c);

     usernameField = new JTextField();
     c.gridy = 1;
     add(usernameField, c);

     JLabel passwordLabel = new JLabel("Password");
     c.gridy = 2;
     add(passwordLabel, c);

     passwordField = new JPasswordField();
     c.gridy = 3;
     add(passwordField, c);

     loginButton = new JButton("Login");
     loginButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
         controller.clickedLoginButton(getUsername(), getPassword());
       }
     });

     c.gridy = 4;
     add(loginButton, c);

     registerButton = new JButton("Register");
     registerButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
         controller.clickedRegisterButton(getUsername(), getPassword());
       }
     });
     c.gridy = 5;
     add(registerButton, c);
   }

   private String getUsername() {
     return usernameField.getText();
   }

   private String getPassword() {
     return new String(passwordField.getPassword());
   }
}
