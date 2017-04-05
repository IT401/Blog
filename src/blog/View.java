package blog;

import javax.swing.JFrame;

public class View extends JFrame {
    public View(String title) {
        super(title);
    }

    public void toggle(boolean isVisible) {
        this.setVisible(isVisible);
    }
}
