package Exam;

import java.util.Scanner;

public class Snake {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int sizeOfTheMatrix = Integer.parseInt(input.nextLine());
        char[][] matrix = new char[sizeOfTheMatrix][];
        int foodQuantity = 0;
        writeMatrix(matrix, input);

        int[] snakePosition = findSnake(matrix);
        int[] foodBorrow2 = findBorrow2(matrix);
        boolean enoughFood = false;
        boolean gameStop = false;

        while (true) {
            String command = input.nextLine();

            switch (command) {
                case "up":
                    matrix[snakePosition[0]][snakePosition[1]] = '.';
                    snakePosition[0] -= 1;

                    if (isInBounds(snakePosition[0], snakePosition[1], matrix)) {
                        if (matrix[snakePosition[0]][snakePosition[1]] == 'B') {
                            matrix[snakePosition[0]][snakePosition[1]] = '.';
                            snakePosition[0] = foodBorrow2[0];
                            snakePosition[1] = foodBorrow2[1];  
                        } else if (matrix[snakePosition[0]][snakePosition[1]] == '*') {
                            foodQuantity++;
                        }
                    } else {
                        gameStop = true;
                    }
                    break;
                case "down":
                    matrix[snakePosition[0]][snakePosition[1]] = '.';
                    snakePosition[0] += 1;

                    if (isInBounds(snakePosition[0], snakePosition[1], matrix)) {
                        if (matrix[snakePosition[0]][snakePosition[1]] == 'B') {
                            matrix[snakePosition[0]][snakePosition[1]] = '.';
                            snakePosition[0] = foodBorrow2[0];
                            snakePosition[1] = foodBorrow2[1];
                        } else if (matrix[snakePosition[0]][snakePosition[1]] == '*') {
                            foodQuantity++;
                        }
                    } else {
                        gameStop = true;
                    }
                    break;
                case "left":
                    matrix[snakePosition[0]][snakePosition[1]] = '.';
                    snakePosition[1] -= 1;

                    if (isInBounds(snakePosition[0], snakePosition[1], matrix)) {
                        if (matrix[snakePosition[0]][snakePosition[1]] == 'B') {
                            matrix[snakePosition[0]][snakePosition[1]] = '.';
                            snakePosition[0] = foodBorrow2[0];
                            snakePosition[1] = foodBorrow2[1];
                        } else if (matrix[snakePosition[0]][snakePosition[1]] == '*') {
                            foodQuantity++;
                        }
                    } else {
                        gameStop = true;
                    }
                    break;
                case "right":
                    matrix[snakePosition[0]][snakePosition[1]] = '.';
                    snakePosition[1] += 1;

                    if (isInBounds(snakePosition[0], snakePosition[1], matrix)) {
                        if (matrix[snakePosition[0]][snakePosition[1]] == 'B') {
                            matrix[snakePosition[0]][snakePosition[1]] = '.';
                            snakePosition[0] = foodBorrow2[0];
                            snakePosition[1] = foodBorrow2[1];
                        } else if (matrix[snakePosition[0]][snakePosition[1]] == '*') {
                            foodQuantity++;
                        }
                    } else {
                        gameStop = true;
                    }
                    break;
            }

            if (gameStop) {
                break;
            }

            matrix[snakePosition[0]][snakePosition[1]] = 'S';

            if (foodQuantity == 10) {
                enoughFood = true;
                break;
            }


        }

        if (gameStop) {
            System.out.println("Game over!");
        }

        if (enoughFood) {
            System.out.println("You won! You fed the snake.");
        }
        System.out.println("Polymorphism.animalsExt.Food eaten: " + foodQuantity);
        printMatrix(matrix);

    }

    public static void writeMatrix(char[][] matrix, Scanner input) {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = input.nextLine().toCharArray();
        }
    }

    public static void printMatrix(char matrix[][]) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }

    }

    public static int[] findSnake(char[][] matrix) {
        int[] snakePosition = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'S') {
                    snakePosition[0] = i;
                    snakePosition[1] = j;
                }
            }
        }
        return snakePosition;
    }


    public static int[] findBorrow2(char[][] matrix) {
        int[] borrows = new int[2];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    borrows[0] = i;
                    borrows[1] = j;

                }
            }
        }
        return borrows;
    }


    public static boolean isInBounds(int row, int col, char[][] matrix) {
        return row >= 0 && row < matrix.length && col >= 0 && col < matrix[row].length;
    }
}
