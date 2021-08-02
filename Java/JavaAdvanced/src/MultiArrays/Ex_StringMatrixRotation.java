package MultiArrays;

import java.util.Scanner;

public class Ex_StringMatrixRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int rotations = Integer.parseInt(scan.nextLine().split("[\\(\\)]")[1]);
        String line = "";
        String input = "";
        int maxLength = 0;
        while (!(input = scan.nextLine()).equals("END")) {
            line += input + "\n";
            if (input.length() > maxLength) {
                maxLength = input.length();
            }
        }
        String[] matrix = line.split("\n");
        String output = "";
        rotations %= 360;
        switch (rotations) {
            case 0:
                System.out.println(line);
                break;
            case 90:
                for (int i = 0; i < maxLength; i++) {
                    for (int j = matrix.length - 1; j >= 0; j--) {
                        try {
                            output += matrix[j].charAt(i);
                        } catch (Exception e) {
                            output += " ";
                        }
                    }
                    output += "\n";
                }
                System.out.println(output);
                break;
            case 180:
                System.out.println(new StringBuilder(line).reverse());
                break;
            case 270:
                for (int i = 0; i < maxLength; i++) {
                    for (int j = matrix.length - 1; j >= 0; j--) {
                        try {
                            output += matrix[j].charAt(i);
                        } catch (Exception e) {
                            output += " ";
                        }
                    }
                    output += "\n";
                }
                System.out.println(new StringBuilder(output).reverse());
                break;
        }
    }
}
