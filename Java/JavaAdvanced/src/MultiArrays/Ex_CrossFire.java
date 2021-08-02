package MultiArrays;

import java.util.*;

public class Ex_CrossFire {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scan.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        List<List<Integer>> matrix = new ArrayList<>();
        int counter = 1;
        for (int i = 0; i < rows; i++) {
            List<Integer> numbers = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                numbers.add(counter++);
            }
            matrix.add(numbers);
        }
        String command = "";
        while (!(command = scan.nextLine()).equals("Nuke it from orbit")) {
            int[] tokens = Arrays.stream(command.split("\\s+"))
                    .mapToInt(Integer::parseInt).toArray();
            int targetRow = tokens[0];
            int targetCol = tokens[1];
            int radius = tokens[2];
            for (int row = targetRow - radius; row <= targetRow + radius; row++) {
                if (isValid(row, targetCol, matrix)) {
                    matrix.get(row).set(targetCol, 0);
                }
            }
            for (int col = targetCol - radius; col <= targetCol + radius; col++) {
                if (isValid(targetRow, col, matrix)) {
                    matrix.get(targetRow).set(col, 0);
                }
            }
            for (int i = 0; i < matrix.size(); i++) {
                matrix.get(i).removeAll(List.of(0));
                if (matrix.get(i).size() == 0) {
                    matrix.remove(i);
                    i--;
                }
            }
        }
        printMatrix(matrix);
    }

    private static boolean isValid(int row, int col, List<List<Integer>> matrix) {
        return (row >= 0 && row < matrix.size()) && (col >= 0 && col < matrix.get(row).size());
    }

    private static void printMatrix(List<List<Integer>> matrix) {
        for (int row = 0; row < matrix.size(); row++) {
            for (int col = 0; col < matrix.get(row).size(); col++) {
                System.out.print(matrix.get(row).get(col) + " ");
            }
            System.out.println();
        }
    }
}
