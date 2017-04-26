package blog;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;

public class BlogModel {
    ArrayList<Blog> blogs = new ArrayList<Blog>();
    
    BlogModel(UserModel userModel) {      
      for (int i = 0; i < userModel.getUserCount(); i++) {
        Blog blog = new Blog(userModel.getUser(i));
        
        File userFolder = new File("test/blogs/"+(i+1));
        String[] folders = userFolder.list();

        for (String folder : folders) {          
          try {
            String html = new String(Files.readAllBytes(Paths.get(userFolder.toString()+"/"+folder+"/message.txt")));
            BlogMessage message = new BlogMessage(html, new Date(Files.readAttributes(Paths.get(userFolder.toString()+"/"+folder+"/message.txt"), BasicFileAttributes.class).creationTime().toMillis()));
            blog.addMessage(message);
          } catch (IOException e) {
            System.out.println(e);
          }          
        }
        
        blogs.add(blog);       
      }
    }
    
    ArrayList<Blog> getBlogs() {
      return blogs;
    }
    
    ArrayList<BlogMessage> getBlogMessages() {
      ArrayList<BlogMessage> messages = new ArrayList<BlogMessage>();
      for (Blog blog : blogs) {
        messages.addAll(blog.getMessages());
      }
      return messages;
    }
    
}
