package graph_algo.bfs;

import java.math.BigInteger;
import java.util.Scanner;

public class Factorial {

    // Complete the extraLongFactorials function below.
    static void extraLongFactorials(int n) {

        BigInteger factorial = BigInteger.valueOf(1);

        for(int i=n;i>1;i--)
        {
            factorial  = factorial.multiply(BigInteger.valueOf(i));
        }

        System.out.println(factorial);

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        extraLongFactorials(3);

        scanner.close();
    }
}

