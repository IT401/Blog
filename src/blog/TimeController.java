package blog;

import java.util.Date;

public class TimeController {
    private MainController main;
    private Date date = new Date(1491400351113L);

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
      date.setTime(date.getTime() + 86400000);
    }

    public void decrease() {
      date.setTime(date.getTime() - 86400000);
    }

}
