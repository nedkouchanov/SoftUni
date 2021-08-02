package MultiArrays;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumSub {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = readArray(scan);
        int rows = dimensions[0];
        int cols = dimensions[1];

        int[][] matrix = readMatrix(scan, rows, cols, "\\s+");

        int bestSum = Integer.MIN_VALUE;
        int resultRow = 0;
        int resultCol = 0;
        for (int row = 0; row < matrix.length - 1; row++) {
            for (int col = 0; col < matrix[row].length - 1; col++) {
                int sum = matrix[row][col] + matrix[row][col + 1] +
                        matrix[row + 1][col] + matrix[row + 1][col + 1];
                if (sum > bestSum) {
                    bestSum = sum;
                    resultRow = row;
                    resultCol = col;
                }
            }
        }
        System.out.print(matrix[resultRow][resultCol] +
                " " + matrix[resultRow][resultCol + 1]);
        System.out.println();
        System.out.print(matrix[resultRow + 1][resultCol] +
                " " + matrix[resultRow + 1][resultCol + 1]);
        System.out.println();
        System.out.println(bestSum);
    }

    private static int[][] readMatrix(Scanner scan, int rows, int cols, String pattern) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] arr = readArray(scan);
            matrix[row] = arr;
        }
        return matrix;
    }

    private static int[] readArray(Scanner scan) {
        return Arrays.stream(scan.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}