/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Liudas
 */
public class BlogMessagePanel extends JPanel {
    private JTextPane textArea;
    private BlogMessage message;

    public BlogMessagePanel(BlogMessage message) {
        this.message = message;
        this.textArea = new JTextPane(message.getDocument());
        this.textArea.setEditable(false);
        this.add(this.textArea);
    }
}
