package blog;

public class User {
    private int id;
    private String username;
    private String pass;

    public User(int id, String username, String pass) {
      this.id = id;
      this.username = username;
      this.pass = pass;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param username the id to set
     */
    public void setId(int id) {
        this.id = id;
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
      return id + " " + username + " " + pass;
    }
}
