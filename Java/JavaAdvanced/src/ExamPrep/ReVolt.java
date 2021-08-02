package ExamPrep;

import DefClasses.Google.Parent;

import java.util.Scanner;

public class ReVolt {
    public static int playerRow;
    public static int playerCol;
    public static int finishRow;
    public static int finishCol;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        int n = Integer.parseInt(scan.nextLine());
        int commandsCount = Integer.parseInt(scan.nextLine());
        char[][] field = new char[n][n];

        for (int i = 0; i < n; i++) {
            String line = scan.nextLine();
            if (line.contains("f")) {
                playerRow = i;
                playerCol = line.indexOf("f");
            }
            if (line.contains("F")) {
                finishRow = i;
                finishCol = line.indexOf("F");
            }
            field[i] = line.toCharArray();
        }
        boolean hasWon = false;
        while ((commandsCount-- > 0) && !hasWon) {

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
            hasWon = playerRow == finishRow
                    && playerCol == finishCol;
        }
        if (hasWon) {
            System.out.println("Encapsulation.Team.Player won!");
        } else {
            System.out.println("Encapsulation.Team.Player lost!");
        }
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    private static void moveLeft(char[][] field) {
        int prevCol = playerCol;
        if (playerCol - 1 < 0) {
            playerCol = field.length;
        }
        if (field[playerRow][playerCol - 1] != 'T') {
            if (playerCol == field.length) {
                prevCol = field.length - 1;
            }
            field[playerRow][prevCol] = '-';
            playerCol--;
            if (field[playerRow][playerCol] != 'B') {
                playerCol--;
            }
            field[playerRow][playerCol] = 'f';
        } else {
            playerCol = prevCol;
        }
    }

    private static void moveUp(char[][] field) {
        if (playerRow - 1 < 0) {
            playerRow = field.length;
        }
        if (field[playerRow - 1][playerCol] != 'T') {
            int prevRow = playerRow;
            if (playerRow == field.length) {
                prevRow = 0;
            }
            field[prevRow][playerCol] = '-';
            playerRow--;
            if (field[playerRow][playerCol] != 'B') {
                playerRow--;
            }
            field[playerRow][playerCol] = 'f';
        }
    }

    private static void moveRight(char[][] field) {
        if (playerCol + 1 == field.length) {
            playerCol = -1;
        }
        if (field[playerRow][playerCol + 1] != 'T') {
            int prevCol = playerCol;
            if (playerCol == -1) {
                prevCol = field.length - 1;
            }
            field[playerRow][prevCol] = '-';
            playerCol++;
            if (field[playerRow][playerCol] != 'B') {
                playerCol++;
            }
            field[playerRow][playerCol] = 'f';
        }
    }

    private static void moveDown(char[][] field) {
        if (playerRow + 1 == field.length) {
            playerRow = -1;
        }
        if (field[playerRow + 1][playerCol] != 'T') {
            int prevRow = playerRow;
            if (playerRow == -1) {
                prevRow = field.length - 1;
            }
            field[prevRow][playerCol] = '-';
            playerRow++;
            if (field[playerRow][playerCol] != 'B') {
                playerRow++;
            }
            field[playerRow][playerCol] = 'f';
        }
    }
}
