package StreamsFilesDirectories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        Path path = Path.of("input.txt");
        byte[] bytes = Files.readAllBytes(path);

        for (byte b : bytes) {
            System.out.print(Integer.toBinaryString(b) + " ");
        }
    }
}
