package blog;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

/**
 * Contains data of one blog message. 
 * Message content is saved inside and HTMLDocument for easier parsing.
 */
public class BlogMessage {
    private int id;
    private HTMLDocument document;
    private String title;
    private User owner;
    private Date date;
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    
    /**
     * Creates a blog message by converting plain content String to HTMLDocument.
     * @param id Unique identification integer.
     * @param html String containing the message content.
     * @param owner User object representing the owner of the message.
     * @param date Date that the message was created on.
     */
    public BlogMessage(int id, String html, User owner, Date date) {
      HTMLEditorKit htmlKit = new HTMLEditorKit();
      HTMLDocument document = (HTMLDocument) htmlKit.createDefaultDocument();
      try {
        htmlKit.read(new StringReader(html), document, 0);
        Element h1 = document.getElement(document.getDefaultRootElement(), StyleConstants.NameAttribute, HTML.Tag.H1);
        this.title = document.getText(h1.getStartOffset(), h1.getEndOffset() - h1.getStartOffset());
      } catch (Exception e) {
        System.out.println(e);
      }
      
      this.id = id;
      this.document = document;
      this.date = date;
      this.owner = owner;
    }
    
    /**
     * Creates a blog message by parsing an HTMLDocument.
     * @param id Identification integer.
     * @param document HTMLDocument containing the message content.
     * @param owner User object representing the owner of the message.
     * @param date Date that the message was created on.
     */
    public BlogMessage(int id, HTMLDocument document, User owner, Date date) {
      this.id = id;
      this.title = document.getElement(document.getDefaultRootElement(), StyleConstants.NameAttribute, HTML.Tag.H1).getName();
      this.document = document;
      this.date = date;
      this.owner = owner;
    }
    
    /**
     * Creates a blog message.
     * @param id Identification integer.
     * @param document HTMLDocument containing the message content.
     * @param title String with the message title.
     * @param owner User object representing the owner of the message.
     * @param date Date that the message was created on.
     */
    public BlogMessage(int id, HTMLDocument document, String title, User owner, Date date) {
      this.id = id;
      this.title = title;
      this.document = document;
      this.date = date;
      this.owner = owner;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void addComment(Comment comment) {
        comments.add(comment);
    }

    public void removeComment(int id) {
        if (id < 0) {
            throw new ArrayIndexOutOfBoundsException("Comment ID can't be less than 0");
        }
        comments.remove(id);
    }
    
    public String toString() {
      return id + " " + title + " " + date + " " + owner.getUsername();
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public HTMLDocument getDocument() {
        return this.document;
    }

    public void setDocument(HTMLDocument document) {
        this.document = document;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
