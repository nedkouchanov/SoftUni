package StreamsFilesDirectories;

import java.io.*;
import java.nio.file.Files;
import java.util.Scanner;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        File file = new File("input.txt");
        byte[] bytes = Files.readAllBytes(file.toPath());
        Writer writer = new FileWriter("tex-as-bytes.txt");
        for (byte b : bytes) {
            String out = String.valueOf(b);
            if (b == 32) {
                out = " ";
            } else if (b == 10) {
                out = System.lineSeparator();
            }
            writer.write(out);
        }
        writer.flush();
    }
}
