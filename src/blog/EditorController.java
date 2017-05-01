package blog;

import javax.swing.JFileChooser;
import javax.swing.text.html.HTMLDocument;

public class EditorController {
    private MainController main;
    private BlogModel model;
    private EditorView view;

    public EditorController(MainController main, BlogModel model) {
      this.main = main;
      this.model = model;
      view = new EditorView(this);
    }
    
    public void showView(boolean show) {
      view.setVisible(show);
    }
    
    public EditorView getView() {
      return view;
    }

    public boolean save(String title, HTMLDocument document) {
      model.addBlogMessage(title, document, main.getActiveUser());
      main.showAllMessagePanels();
      return true;
    }
    
    public boolean image() {
      return true;
    }
}
