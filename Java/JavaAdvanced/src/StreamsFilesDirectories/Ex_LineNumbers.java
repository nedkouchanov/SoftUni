package StreamsFilesDirectories;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Ex_LineNumbers {
    public static void main(String[] args) {
        try{
            FileWriter fileWriter = new FileWriter((new File("E:\\SOFTUNI\\Java\\JavaAdvanced\\out.txt")));
            List<String> strings = Files.readAllLines(Path.of("E:\\SOFTUNI\\Java\\JavaAdvanced\\inputLineNumbers.txt"));
            for (int i = 0; i < strings.size(); i++) {
                fileWriter.write(String.format("%d. %s%n", i + 1, strings.get(i)));
                fileWriter.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
