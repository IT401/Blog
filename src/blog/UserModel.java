package blog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class UserModel {
  private File file;
  private ArrayList<User> users = new ArrayList<User>();
  private BufferedReader reader;
  private BufferedWriter writer;
  
  public UserModel() {
    String line;
    String[] splitLine;
    
    try {
      file = new File("test/users.txt");
      reader = new BufferedReader(new FileReader(file));

      while ((line = reader.readLine()) != null) {
        splitLine = line.split(" ");
        users.add(new User(Integer.parseInt(splitLine[0]), splitLine[1], splitLine[2]));
      }
      
      reader.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  
  public User getUser(int id) {
    return users.get(id);
  }
  
  public ArrayList<User> getUsers() {
    return users;
  }
  
  public void addUser(User user) {
    users.add(user);
    try {
      writer = new BufferedWriter(new FileWriter(file, true));
      writer.write(user.toString());
      writer.newLine();
      writer.close();
    } catch (Exception e) {
      System.out.println(e);
    }
  }
  
  public void addUser(int id, String username, String password) {
    addUser(new User(id, username, password));
  }
  
  public boolean userExists(String username) {
    for (User user : users) {
      if (user.getUsername().compareTo(username) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public boolean userExists(String username, String password) {
    for (User user : users) {
      if (user.getUsername().compareTo(username) == 0 && user.getPass().compareTo(password) == 0) {
        return true;
      }
    }
    return false;
  }
  
  public int getUserCount() {
    return users.size();
  }
  
  public void printUsers() {
    for (User u : users) {
      System.out.println(u);
    }
  }
}

