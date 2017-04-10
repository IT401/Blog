package blog;

import java.awt.GridBagLayout;
import javax.swing.JFrame;

public class View extends JFrame {
    public View(String title) {
        super(title);
        this.setLayout(new GridBagLayout());
    }

    public void toggle(boolean isVisible) {
        this.setVisible(isVisible);
    }
}
