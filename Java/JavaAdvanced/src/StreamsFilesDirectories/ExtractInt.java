package StreamsFilesDirectories;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class ExtractInt {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        PrintWriter writer = new PrintWriter("integers.txt");
        Scanner scan = new Scanner(file);

        while (scan.hasNext()) {
            if (scan.hasNextInt()) {
                int nextInt = scan.nextInt();
                writer.println(nextInt);
            } else {
                scan.next();
            }
        }
        writer.flush();
    }
}
