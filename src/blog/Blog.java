/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import java.util.ArrayList;

/**
 *
 * @author Liudas
 */
public class Blog {
    private ArrayList<BlogMessage> messages = new ArrayList<BlogMessage>();
    private User owner;

    public BlogMessage getMessage(int id) {
        if (id < 0) {
            throw new ArrayIndexOutOfBoundsException("Message ID can't be less than 0");
        }
        return messages.get(id);
    }

    public ArrayList<BlogMessage> getMessages() {
        return messages;
    }

    public void addMessage(BlogMessage message) {
        messages.add(message);
    }

    public void removeMessage(int id) {
        if (id < 0) {
            throw new ArrayIndexOutOfBoundsException("Message ID can't be less than 0");
        }
        messages.remove(id);
    }

    /**
     * @return the user
     */
    public User getOwner() {
        return owner;
    }

    /**
     * @param user the user to set
     */
    public void setOwner(User owner) {
        this.owner = owner;
    }


}
