package BT2th4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Document {
    private List<String> lines;

    public Document() {
        lines = new ArrayList<>();
    }

    public Stream<String> streamLines() {
        return lines.stream();
    }

    public void addLine(String line) {
        lines.add(line);
    }

    public void removeLine(int index) {
        lines.remove(index);
    }

    // Phương thức để lưu dữ liệu vào tệp
    public void saveToFile(File file) {
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(file)))) {
            lines.forEach(writer::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Phương thức để tải dữ liệu từ tệp
    public void loadFromFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
