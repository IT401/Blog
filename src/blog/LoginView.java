package blog;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginView extends View {
  private AuthController controller;
  private JButton registerButton, loginButton;
  private JTextField usernameField;
  private JPasswordField passwordField;

  public LoginView(AuthController controller) {
     super("Blog");
     this.controller = controller;
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setSize(400, 200);

     GridBagConstraints c = new GridBagConstraints();

     JLabel usernameLabel = new JLabel("Username");
     c.gridx = 0;
     c.gridy = 0;
     c.gridheight = 1;
     c.gridwidth = 1;
     c.weightx = 1.0;
     c.fill = GridBagConstraints.HORIZONTAL;
     this.add(usernameLabel, c);

     usernameField = new JTextField();
     c.gridy = 1;
     this.add(usernameField, c);

     JLabel passwordLabel = new JLabel("Password");
     c.gridy = 2;
     this.add(passwordLabel, c);

     passwordField = new JPasswordField();
     c.gridy = 3;
     this.add(passwordField, c);

     loginButton = new JButton("Login");
     loginButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
         if (controller.login(getUsername(), getPassword())) {
          toggle(false);
         }
       }
     });

     c.gridy = 4;
     this.add(loginButton, c);

     registerButton = new JButton("Register");
     registerButton.addActionListener(new ActionListener() {
       public void actionPerformed(ActionEvent e) {
         if (controller.register(getUsername(), getPassword())) {
          toggle(false);
         }
       }
     });
     c.gridy = 5;
     this.add(registerButton, c);

     toggle(true);
   }

    public String getUsername() {
      return usernameField.getText();
    }

    public String getPassword() {
      return new String(passwordField.getPassword());
    }
}
