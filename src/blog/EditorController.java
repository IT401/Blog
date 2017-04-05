package blog;

import javax.swing.text.html.HTMLDocument;

public class EditorController {
    MainController main;

    public EditorController(MainController controller) {
      main = controller;
    }

    public boolean save(HTMLDocument document) {
      // save da fuckin document here
      return true;
    }
}
