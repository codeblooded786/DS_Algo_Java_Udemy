package graph_algo.bfs;

/**
 * @project GraphAlgorithms
 * Created by @author Rahul Dev Gupta on 04/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */

import java.io.IOException;
import java.util.Scanner;
import java.util.stream.IntStream;

public class SequenceEquation {

    // Complete the permutationEquation function below.
    static int[] permutationEquation(int[] p) {

        int x[] = new int[p.length];

        for (int i = 1; i <= p.length; i++) {
            x[i - 1] = findIndex(p, i) + 1;
        }
        /*for (int y:x)
            System.out.println(y);*/

        int result[] = new int[x.length];

        for (int i = 1; i <= x.length; i++) {
            result[i - 1] = x[findIndex(p, i)];
        }

        return result;


    }

    public static int findIndex(int arr[], int t) {
        int len = arr.length;
        return IntStream.range(0, len)
                .filter(i -> t == arr[i])
                .findFirst() // first occurrence
                .orElse(-1); // No element found
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {


        int p[] = {5, 2, 1, 3, 4};

        int[] result = permutationEquation(p);

        for (int i = 0; i < p.length; i++)
            System.out.println(result[i]);
    }
}