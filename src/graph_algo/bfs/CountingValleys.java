package graph_algo.bfs;

/**
 * @project GraphAlgorithms
 * Created by @author Rahul Dev Gupta on 03/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class CountingValleys {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {

        int var = 0;
        boolean counted = false;
        int countValley = 0;

        for (int i = 0; i < n; i++) {

            if (s.charAt(i) == 'U') {
                var++;
            } else if (s.charAt(i) == 'D') {
                var--;
            }

            if (var < 0 && !counted) {
                countValley++;
                counted=true;
            }
            if (var == 0 && counted==true)
                counted = false;

        }
        return countValley;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int result = countingValleys(8, "UDDDUDUU");

        System.out.println(result);
    }
}

