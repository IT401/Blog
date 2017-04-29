package blog;

import javax.swing.JFileChooser;
import javax.swing.text.html.HTMLDocument;

public class EditorController {
    private MainController main;
    private EditorView view;

    public EditorController(MainController controller) {
      main = controller;
      view = new EditorView(this);
    }

    public boolean save(HTMLDocument document) {
      return true;
    }
    
    public boolean image() {
      return true;
    }
    
    public void showView() {
      view.toggle(true);
    }
}
