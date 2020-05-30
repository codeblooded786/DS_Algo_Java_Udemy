package graph_algo.bfs;


import java.io.IOException;
import java.util.Scanner;

public class QueensAttack {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {

        int op = 0, queensPosy = 0, queensPosx = 0;

        int arr[][] = new int[n][n];

        queensPosx = getRow(r_q, n);
        queensPosy = getCol(c_q);

        arr[getRow(r_q, n)][getCol(c_q)] = -1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if ((i == getRow(r_q, n) || j == getCol(c_q))) {

                    arr[i][j] = 1;
                }
            }
        }

        /*for (int i=getRow(r_q,n)+1;i<n;i++)
        {
            for (int j =getCol(c_q)+1;j<n;j++)
            {
                arr[i][j]=1;
            }
        }*/

        int row = getRow(r_q, n) + 1;
        int col = getCol(c_q) + 1;

        while (true) {
            if (row == n || col == n)
                break;
            arr[row++][col++] = 1;

        }
        row = getRow(r_q, n) + 1;
        col = getCol(c_q) - 1;

        while (true) {
            if (row == n || col == -1)
                break;
            arr[row++][col--] = 1;

        }

        row = getRow(r_q, n) - 1;
        col = getCol(c_q) - 1;

        while (true) {
            if (row == -1 || col == -1)
                break;
            arr[row--][col--] = 1;
        }

        row = getRow(r_q, n) - 1;
        col = getCol(c_q) + 1;

        while (true) {
            if (row == -1 || col == n)
                break;
            arr[row--][col++] = 1;
        }

        arr[getRow(r_q, n)][getCol(c_q)] = 0;


        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        arr[queensPosx][queensPosy] = -1;

        for (int i = 0; i < obstacles.length; i++) {
            row = getRow(obstacles[i][0], n);
            col = getCol(obstacles[i][1]);
            System.out.println(checkRow(row, col, n, arr));
            System.out.println(checkCol(row, col, n, arr));
            /*System.out.println(checkPrimeDiagonal(row, col, n, arr));
            System.out.println(checkOtherDiagonal(row, col, n, arr));*/

            if (checkRow(row, col, n, arr)) {
                if (col < queensPosy) {
                    for (int p = 0; p <= col; p++)
                        arr[row][p] = 0;
                } else {
                    for (int q = col; q < n; q++) {
                        arr[row][q] = 0;
                    }
                }
            }

            if (checkCol(row, col, n, arr)) {
                if (row < queensPosx) {
                    for (int p = 0; p <= row; p++)
                        arr[p][col] = 0;
                } else {
                    for (int q = row; q < n; q++) {
                        arr[q][col] = 0;
                    }
                }
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] != -1)
                    op += arr[i][j];
            }
        }

        return op;
    }

    private static int getRow(int x, int n) {
        return n - x;
    }

    private static int getCol(int x) {
        return x - 1;
    }

    private static boolean checkRow(int x, int y, int n, int arr[][]) {

        for (int j = 0; j < n; j++) {
            if (arr[x][j] == -1)
                return true;
        }
        return false;
    }

    private static boolean checkCol(int x, int y, int n, int arr[][]) {

        for (int i = 0; i < n; i++) {
            if (arr[i][y] == -1) {
                return true;
            }
        }
        return false;
    }

    private static boolean checkPrimeDiagonal(int x, int y, int n, int arr[][]) {
        int row = x - 1;
        int col = y - 1;
        while (row != -1 && col != -1) {
            if (arr[row][col] == -1)
                return true;
        }
        row = x + 1;
        col = y + 1;

        while (row != n && col != n) {
            if (arr[row][col] == -1)
                return true;
        }

        return false;
    }

    private static boolean checkOtherDiagonal(int x, int y, int n, int arr[][]) {
        int row = x - 1;
        int col = y + 1;
        while (row != -1 && col != -1) {
            if (arr[row][col] == -1)
                return true;
        }
        row = x + 1;
        col = y - 1;

        while (row != n && col != n) {
            if (arr[row][col] == -1)
                return true;
        }

        return false;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[][] obstacles = {{5, 5}, {4, 2}, {2, 3}};

        int result = queensAttack(5, 3, 4, 3, obstacles);

        System.out.println(result);


    }
}

