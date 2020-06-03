package graph_algo.bfs;

/**
 * @project GraphAlgorithms
 * Created by @author Rahul Dev Gupta on 03/06/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */

import java.io.IOException;
import java.util.*;

public class DrawingBook {

    /*
     * Complete the pageCount function below.
     */
    static int pageCount(int n, int p) {
        /*
         * Write your code here.
         */
        return n % 2 == 0 ? Math.min(n / p, (int) Math.ceil((n - p) / 2.0)) : Math.min(n / p, (n - p) / p);


    }

    public static int getTotalX(List<Integer> a, List<Integer> b) {

        List<Integer> result = new ArrayList<>();

        Collections.sort(a, Collections.reverseOrder());
        Collections.sort(b);

        for (int i = a.get(0); i <= b.get(0); i++) {
            int j;
            for (j = 0; j < a.size(); j++) {
                if (i % a.get(j) != 0) {
                    break;
                }
            }
            if (j == a.size())
                result.add(i);
        }

        List<Integer> finalList = new ArrayList<>();

        for (int i = 0; i < result.size(); i++)
            System.out.println(result.get(i));

        for (int i = 0; i < result.size(); i++) {
            int j;
            for (j = 0; j < b.size(); j++) {
                if (b.get(j) % result.get(i) != 0) {
                    break;
                }
            }
            if (j != b.size())
                result.remove(new Integer(result.get(i)));

        }
        // Write your code here

        // System.out.println(result.size());
        return result.size();

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");

        int p = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])*");*/

        //int result = pageCount(6, 5);

        int result = getTotalX(Arrays.asList(2, 3, 6), Arrays.asList(42, 84));

        System.out.println(result);

        /*bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();*/
    }
}
