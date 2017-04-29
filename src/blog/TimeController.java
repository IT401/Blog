package blog;

import java.util.Date;

public class TimeController {
    private MainController main;
    private TimeView view;
    private Date date = new Date(1493485753660L);

    public TimeController(MainController controller) {
        main = controller;
        view = new TimeView(this);
        view.updateDateField(date.toString());
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void clickedAddButton() {
      date.setTime(date.getTime() + 86400000); // move date forwards one day
      view.updateDateField(date.toString());
      main.dateChanged(date);
    }

    public void clickedSubButton() {
      date.setTime(date.getTime() - 86400000); // mode date backwards one day
      view.updateDateField(date.toString());
      main.dateChanged(date);
    }
    
    public void showView() {
      view.toggle(true);
    }

}
