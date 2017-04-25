package blog;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;

public class View extends JFrame {
    GridBagConstraints c;
    
    public View(String title) {
        super(title);
        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
    }

    public void toggle(boolean isVisible) {
        this.setVisible(isVisible);
    }
}
