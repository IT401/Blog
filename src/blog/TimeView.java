package blog;

import javax.swing.JButton;

public class TimeView extends View {
    private TimeController controller;
    private JButton addButton, subButton;

    public TimeView(TimeController controller) {
        super("Time Control");
        this.controller = controller;
    }
}
