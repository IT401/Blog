package blog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class BlogModel {
  ArrayList<Blog> blogs = new ArrayList<Blog>();
  private BufferedWriter writer;
    
  /**
   * Reads every users blog messages.
   * @param users An ArrayList of users.
   */
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
    
    /**
     * Adds a new blog message and saves it in the file system.
     * @param title Title of the blog message.
     * @param document HTMLDocument with message content.
     * @param user A user to whom the blog message belongs to.
     */
    public void addBlogMessage(String title, HTMLDocument document, Date date, User user) {
      Blog blog = getBlog(user);
      HTMLEditorKit htmlKit = new HTMLEditorKit();
      try {
        Element body = document.getElement(document.getDefaultRootElement(), StyleConstants.NameAttribute, HTML.Tag.BODY);
        document.insertAfterStart(body, "<h1>"+title+"</h1>");
        
        File file = new File("test/blogs/"+user.getId()+"/"+(blog.getMessages().size()+1)+"/message.txt");
        file.getParentFile().mkdirs();
        (new File("test/blogs/"+user.getId()+"/"+(blog.getMessages().size()+1)+"/comments.txt")).createNewFile();
        
        writer = new BufferedWriter(new FileWriter(file, true));
        htmlKit.write(writer, document, 0, document.getLength());
        writer.close();
        Files.setAttribute(file.toPath(), "basic:creationTime", FileTime.fromMillis(date.getTime()), NOFOLLOW_LINKS);
      } catch (Exception e) {
        System.out.println(e);
      }
      BlogMessage message = new BlogMessage(blog.getMessages().size()+1, document, title, user, date);
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
    
    public void addBlog(User user) {
      blogs.add(new Blog(user));
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
