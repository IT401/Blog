/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import javax.swing.JButton;

/**
 *
 * @author Liudas
 */
public class TimeView {
    private TimeController controller;
    private JButton addButton, subButton;
    
    public TimeView(TimeController controller) {
        this.controller = controller;
    }
}
