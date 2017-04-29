package blog;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.text.Element;
import javax.swing.text.StyleConstants;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class BlogMessage {
    private HTMLDocument document;
    private String title;
    private User owner;
    private Date date;
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    
    public BlogMessage(String html, User owner, Date date) {
      HTMLEditorKit htmlKit = new HTMLEditorKit();
      HTMLDocument document = (HTMLDocument) htmlKit.createDefaultDocument();
      try {
        htmlKit.read(new StringReader(html), document, 0);
        Element h1 = document.getElement(document.getDefaultRootElement(), StyleConstants.NameAttribute, HTML.Tag.H1);
        this.title = document.getText(h1.getStartOffset(), h1.getEndOffset() - h1.getStartOffset());
      } catch (Exception e) {
        System.out.println(e);
      }
      
      this.document = document;
      this.date = date;
      this.owner = owner;
    }

    public BlogMessage(HTMLDocument document, User owner, Date date) {
      this.title = document.getElement(document.getDefaultRootElement(), StyleConstants.NameAttribute, HTML.Tag.H1).getName();
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
    
    /**
     * @return the document
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * @param document the document to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the document
     */
    public HTMLDocument getDocument() {
        return this.document;
    }

    /**
     * @param document the document to set
     */
    public void setDocument(HTMLDocument document) {
        this.document = document;
    }

    /**
     * @return the date
     */
    public Date getDate() {
        return this.date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * @return the owner
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @param owner the owner to set
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }
}
