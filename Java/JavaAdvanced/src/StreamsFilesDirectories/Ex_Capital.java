package StreamsFilesDirectories;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ex_Capital {
    public static void main(String[] args) {

        try {
            FileWriter fileWriter = new FileWriter(new File("E:\\SOFTUNI\\Java\\JavaAdvanced\\out.txt"));
            List<String> strings = Files.readAllLines(Path.of("E:\\SOFTUNI\\Java\\JavaAdvanced\\input.txt"));
            for (String string : strings) {
                fileWriter.write(string.toUpperCase() + "\n");
                fileWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}