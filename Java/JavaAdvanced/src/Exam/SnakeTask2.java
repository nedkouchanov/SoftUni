package Exam;

import java.util.Scanner;

public class SnakeTask2 {
    public static int snakeRow;
    public static int snakeCol;
    static boolean gameOver=false;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int snakeFeed = 0;
        boolean hasWon = false;
        boolean gameOver=false;
        int n = Integer.parseInt(scan.nextLine());
        char[][] field = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            if (line.contains("S")) {
                snakeRow = i;
                snakeCol = line.indexOf("f");
            }
            field[i] = line.toCharArray();
        }
while (!hasWon){
    String command = scan.nextLine();
    switch (command) {
        case "up":
            moveUp(field);
            break;
        case "down":
            moveDown(field);
            break;
        case "left":
            moveLeft(field);
            break;
        case "right":
            moveRight(field);
            break;
    }
}

        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    private static void moveRight(char[][] field) {
    }

    private static void moveLeft(char[][] field) {
    }

    private static void moveDown(char[][] field) {
    }

    private static void moveUp(char[][] field) {

            if(snakeRow-1<0){
                gameOver=true;
            }
    }
}
