package BT2th4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.File;

public class TextEditorView {
    private JFrame frame;
    private JTextArea textArea;
    private JButton saveButton;

    public TextEditorView() {
        frame = new JFrame("Text Editor");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        textArea = new JTextArea();
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        saveButton = new JButton("Save");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public File showSaveDialog() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public File showOpenDialog() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(frame, message);
    }
}
