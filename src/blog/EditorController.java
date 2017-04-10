package blog;

import javax.swing.JFileChooser;
import javax.swing.text.html.HTMLDocument;

public class EditorController {
    MainController main;

    public EditorController(MainController controller) {
      main = controller;
    }

    public boolean save(HTMLDocument document) {
      return true;
    }
    public boolean image() {
      
      return true;
    }
}
