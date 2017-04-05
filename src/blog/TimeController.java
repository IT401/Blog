/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import java.util.Date;

/**
 *
 * @author Liudas
 */
public class TimeController {
    private MainController controller;
    private TimeView view;
    private Date date;

    public TimeController(MainController controller) {
        this.controller = controller;
        view = new TimeView(this);
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
