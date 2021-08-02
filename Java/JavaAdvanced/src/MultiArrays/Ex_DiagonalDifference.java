package MultiArrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Ex_DiagonalDifference {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] line = Arrays.stream(scan.nextLine().split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = line[j];
            }
        }
        int primarySum = 0;
        for (int i = 0; i < matrix.length; i++) {
            primarySum += matrix[i][i];
        }
        int secondarySum = 0;
        for (int i = matrix.length - 1; i >= 0; i--) {
            int col = matrix[0].length - 1 - i;
            secondarySum += matrix[i][col];
        }
        System.out.println(Math.abs(primarySum - secondarySum));
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
