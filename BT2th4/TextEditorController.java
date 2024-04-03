package BT2th4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class TextEditorController {
    private Document document;
    private TextEditorView view;

    public TextEditorController(Document document, TextEditorView view) {
        this.document = document;
        this.view = view;

        view.addSaveButtonListener(e -> saveDocument());
    }

    private void saveDocument() {
        File file = view.showSaveDialog();
        if (file != null) {
            document.saveToFile(file);
            view.showMessage("File saved successfully.");
        }
    }

    public void openDocument() {
        File file = view.showOpenDialog();
        if (file != null) {
            document.loadFromFile(file);
            StringBuilder text = new StringBuilder();
            document.streamLines().forEach(text::append);
            view.setText(text.toString());
            view.showMessage("File opened successfully.");
        }
    }
}
