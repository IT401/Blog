package blog;

import java.util.Date;

public class TimeController {
    private MainController main;
    private Date date;

    public TimeController(MainController controller) {
        main = controller;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void increase() {

    }

    public void decrease() {

    }

}
