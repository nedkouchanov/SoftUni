package StreamsFilesDirectories;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class ListFiles {
    public static void main(String[] args) throws IOException {
        File file = new File("E:\\SOFTUNI\\Java\\JavaAdvanced\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\Files-and-Streams");
        File[] files = file.listFiles();
        for (File f : files) {
            if (!f.isDirectory()) {
                System.out.println(f.getName() + ": " + "[" + f.length() + "]");
            }
        }
    }
}
