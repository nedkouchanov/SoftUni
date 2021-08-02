package StreamsFilesDirectories;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Ex_SumLines {
    public static void main(String[] args) {

        try {
            List<String> strings= Files.readAllLines(Path.of("E:\\SOFTUNI\\Java\\JavaAdvanced\\input.txt"));
            for (String string : strings) {
                long asciiSum=0;
                for (int i = 0; i < string.length(); i++) {
                    asciiSum+=string.charAt(i);
                }
                System.out.println(asciiSum);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
