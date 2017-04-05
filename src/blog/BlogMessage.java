/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import java.util.ArrayList;
import java.util.Date;
import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author Liudas
 */
public class BlogMessage {
    private HTMLDocument document;
    private ArrayList<Comment> comments = new ArrayList<Comment>();
    private Date date;

    public BlogMessage() {}

    public BlogMessage(HTMLDocument document, Date date) {
      this.document = document;
      this.date = date;
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
}
