package MultiArrays;

import java.util.Arrays;
import java.util.Scanner;

public class SquareMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[size][size];
        for (int row = 0; row < size; row++) {
            matrix[row] = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
        int row = 0;
        int col = 0;
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[row++][col++] + " ");
        }
        row = size - 1;
        col = 0;
        System.out.println();
        for (int i = 0; i < size; i++) {
            System.out.print(matrix[row--][col++] + " ");
        }
    }
}
