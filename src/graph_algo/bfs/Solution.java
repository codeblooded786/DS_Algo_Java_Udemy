package graph_algo.bfs;

import java.io.IOException;
import java.util.Scanner;

public class Solution {

    // Complete the formingMagicSquare function below.
    static int formingMagicSquare(int[][] arr) {

        boolean brr[][] = new boolean[3][3];

        int sumH[] = new int[3];
        int sumV[] = new int[3];
        int sumD[] = new int[2];
        int k = 0;
        int num = 0;

        for (int i = 0; i < 3; i++) {
            sumH[k] = arr[i][0] + arr[i][1] + arr[i][2];
            sumV[k] = arr[0][i] + arr[1][i] + arr[2][i];
            k++;
        }

        sumD[0] = arr[0][0] + arr[1][1] + arr[2][2];
        sumD[1] = arr[0][2] + arr[1][1] + arr[2][0];

        /*System.out.println(sumH[0] + " " + sumH[1] + " " + sumH[2]);
        System.out.println(sumV[0] + " " + sumV[1] + " " + sumV[2]);
        System.out.println(sumD[0] + " " + sumD[1]);*/

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boolean op = findRow(arr, sumH, sumV, sumD, i, j);
                brr[i][j] = op;
                System.out.print("i=" + i + "j=" + j + " " + op + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(brr[i][j]+" ");
            }
            System.out.println();
        }

        int countTrue=0,countValueH=0,x=0,y=0,value=0,cost=0;

        for (int i = 0; i < 3; i++) {
            countTrue=0;
            countValueH=0;
            for (int j = 0; j < 3; j++) {
                if (brr[i][j]==true)
                    countTrue++;
            }
            if (countTrue==1)
            {
                for (int l=0;l<3;l++)
                {
                    if (brr[i][l]==false)
                    {
                        countValueH+=arr[i][l];
                    }
                    if (brr[i][l]==true)
                    {
                        x=i;
                        y=l;
                    }
                }

                value=15-countValueH;
                if (value>arr[x][y])
                {
                    cost+=value-arr[x][y];
                }
                else
                    cost+=arr[x][y]-value;
                arr[x][y]=value;
                brr[x][y]=false;
            }

        }
        for (int i = 0; i < 3; i++) {
            countTrue=0;
            countValueH=0;
            for ( int j = 0; j < 3; j++) {
                if (brr[j][i]==true)
                    countTrue++;
            }
            if (countTrue==1)
            {
                for (int l=0;l<3;l++)
                {
                    if (brr[l][i]==false)
                    {
                        countValueH+=arr[l][i];
                    }
                    if (brr[l][i]==true)
                    {
                        x=l;
                        y=i;
                    }
                }

                value=15-countValueH;
                if (value>arr[x][y])
                {
                    cost+=value-arr[x][y];
                }
                else
                    cost+=arr[x][y]-value;
                arr[x][y]=value;
                brr[x][y]=false;
            }

        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(brr[i][j]+" " );

            }
            System.out.println();
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(cost);
        return 1;
    }

    private static boolean findRow(int s[][], int sumH[], int sumV[], int sumD[], int i, int j) {
        if (i == j || i + j == 2) {
            if (sumH[i] == 15 || sumV[j] == 15 || (i == j && sumD[0] == 15))
                return false;
            if (sumH[i] == 15 || sumV[j] == 15 || (i + j == 2 && sumD[1] == 15))
                return false;
        } else if (sumH[i] == 15 || sumV[j] == 15)
            return false;

        return true;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        //    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int[][] s = {{4, 5, 8}, {2, 4, 1}, {1, 9, 7}};

        int result = formingMagicSquare(s);
/*
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}
