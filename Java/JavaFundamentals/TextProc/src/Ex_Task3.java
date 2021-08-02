import java.util.Scanner;

public class Ex_Task3 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String path = scan.nextLine();
        int slashIndex = path.lastIndexOf('\\');
        int pointIndex = path.lastIndexOf('.');
        String name = path.substring(slashIndex + 1, pointIndex);
        String extension = path.substring(pointIndex + 1);
        System.out.println(String.format("File name: %s", name));
        System.out.println(String.format("File extension: %s", extension));
    }
}
