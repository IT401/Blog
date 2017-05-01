package blog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;

public class BlogModel {
  ArrayList<Blog> blogs = new ArrayList<Blog>();
  private BufferedWriter writer;
    
    public void readBlogs(ArrayList<User> users) {
      for (User user : users) {
        Blog blog = new Blog(user);
        
        File userFolder = new File("test/blogs/"+user.getId());
        String[] folders = userFolder.list();
        for (String folder : folders) {
          try {
            String html = new String(Files.readAllBytes(Paths.get(userFolder.toString()+"/"+folder+"/message.txt")));
            BlogMessage message = new BlogMessage(Integer.parseInt(folder), html, blog.getOwner(), new Date(Files.readAttributes(Paths.get(userFolder.toString()+"/"+folder+"/message.txt"), BasicFileAttributes.class).creationTime().toMillis()));
            blog.addMessage(message);
          } catch (IOException e) {
            System.out.println(e);
          } 
        }
        
        blogs.add(blog); 
      }  
    }
    
    public void addBlogMessage(String title, HTMLDocument document, User user) {
      Blog blog = getBlog(user);
      try {
        Element body = document.getElement(document.getDefaultRootElement(), StyleConstants.NameAttribute, HTML.Tag.BODY);
        document.insertAfterStart(body, "<h1>"+title+"</h1>");
        Element h1 = document.getElement(document.getDefaultRootElement(), StyleConstants.NameAttribute, HTML.Tag.H1);
        String content = document.getText(h1.getEndOffset(), body.getEndOffset() - h1.getEndOffset());
        
        File file = new File("test/blogs/"+user.getId()+"/"+(blog.getMessages().size()+1)+"/message.txt");
        file.getParentFile().mkdirs();
        
        writer = new BufferedWriter(new FileWriter(file, true));
        writer.write("<h1>"+title+"</h1>");
        writer.newLine();
        writer.write(content);
        writer.newLine();
        writer.close();
      } catch (Exception e) {
        System.out.println(e);
      }
      BlogMessage message = new BlogMessage(blog.getMessages().size()+1, document, title, user, new Date());
      blog.addMessage(message);
    }
    
    public Blog getBlog(User user) {
      for (Blog blog : blogs) {
        if (user.getUsername().equals(blog.getOwner().getUsername())) {
          return blog;
        }
      }
      return null;
    }   
    
    public ArrayList<Blog> getBlogs() {
      return blogs;
    } 
    
    public ArrayList<BlogMessage> getBlogMessages() {
      ArrayList<BlogMessage> messages = new ArrayList<BlogMessage>();
      
      for (Blog blog : blogs) {
        messages.addAll(blog.getMessages());
      }
      
      return messages;
    }
    
}
