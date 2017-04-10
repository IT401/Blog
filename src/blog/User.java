package blog;

public class User {
    private String username;
    private String pass;

    public User(String username, String pass) {
      this.username = username;
      this.pass = pass;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
      return username + " " + pass;
    }
}
