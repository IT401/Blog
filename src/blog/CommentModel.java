package blog;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class CommentModel {
  private File file;
  private BufferedReader reader;
  private BufferedWriter writer;
  
  public void readComments(ArrayList<BlogMessage> messages, UserModel model) {
    for (BlogMessage message : messages) {
      String line;
      User user;
      
      try {
        file = new File("test/blogs/"+message.getOwner().getId()+"/"+message.getId()+"/comments.txt");
        reader = new BufferedReader(new FileReader(file));
  
        while ((line = reader.readLine()) != null) {
          user = model.getUser(line);
          line = reader.readLine();
          message.addComment(new Comment(user, line));
        }
        
        reader.close();
      } catch (Exception e) {
        System.out.println(e);
      }
    }
  }
  
  public void addComment(BlogMessage message, User user, String text) {
    try {
      File file = new File("test/blogs/"+message.getOwner().getId()+"/"+message.getId()+"/comments.txt");
      writer = new BufferedWriter(new FileWriter(file, true));
      writer.write(user.getUsername());
      writer.newLine();
      writer.write(text);
      writer.newLine();
      writer.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    message.addComment(new Comment(user, text));
  }
  
}
