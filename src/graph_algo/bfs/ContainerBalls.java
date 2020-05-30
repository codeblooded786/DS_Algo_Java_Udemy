package graph_algo.bfs;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ContainerBalls {

    // Complete the organizingContainers function below.
    static String organizingContainers(int[][] container) {

        int containerSize[] = new int[container.length];
        int ballCount[] = new int[container.length];


        for (int i = 0; i < container.length; i++) {
            for (int j = 0; j < container.length; j++) {
                containerSize[i] += container[i][j];
                ballCount[i]+=container[j][i];
            }
        }

        for (int i =0;i<container.length;i++)
        {
            System.out.print(containerSize[i]+" "+ballCount[i]+" ");
            System.out.println();
        }

        Arrays.sort(containerSize);
        Arrays.sort(ballCount);
        if (Arrays.equals(containerSize,ballCount))
            return "Possible";

        return "Impossible";
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = 2;
        int n = 2;
        //    scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        int[][] container = {{1,  1},
                {1, 1}};


        String result = organizingContainers(container);

        System.out.println(result);


    }
}



