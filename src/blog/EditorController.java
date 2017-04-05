/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blog;

import javax.swing.text.html.HTMLDocument;

/**
 *
 * @author Liudas
 */
public class EditorController {
    MainController controller;
    EditorView view;

    public EditorController(MainController controller) {
      this.controller = controller;
      view = new EditorView(this);
    }

    public boolean save(HTMLDocument document) {
      // save da fuckin document here
      return true;
    }

    public void toggle(boolean isVisible) {
      view.toggle(isVisible);
    }
}
