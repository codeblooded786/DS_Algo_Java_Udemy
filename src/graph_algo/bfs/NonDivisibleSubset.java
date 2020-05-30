package graph_algo.bfs;


import java.io.IOException;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Result {

    /*
     * Complete the 'nonDivisibleSubset' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY s
     */

    public static int nonDivisibleSubset(int k, List<Integer> s) {
        // Write your code here

        if (k == 1)
            return 1;

        List<Integer> remainders = new ArrayList<>();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < s.size(); i++) {
            remainders.add(s.get(i) % k);
        }

        for (Integer i : remainders) {
            if (!map.containsKey(i)) {
                map.put(i, 1);
            } else {
                int x = map.get(i);
                map.put(i, x + 1);
            }
        }

        for (Integer i : remainders)
            System.out.print(i + " ");

        System.out.println();


        Map<Integer, Integer> mymap = new LinkedHashMap<>();

        mymap = map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        for (Map.Entry m : mymap.entrySet()) {
            System.out.println("key " + m.getKey() + "value " + m.getValue());
        }


        Map<Object, Object> newmap = new HashMap<>();

        int op = 0;

        for (Map.Entry m : mymap.entrySet()) {
            if (!newmap.containsKey(m.getKey())) {
                int reversekey = k - Integer.parseInt(m.getKey().toString());
                if (!newmap.containsKey(reversekey)) {
                    newmap.put(m.getKey(), m.getValue());
                }
            }
        }

        if (k % 2 == 0) {
            if (newmap.containsKey(k / 2) && Integer.parseInt(newmap.get(k / 2).toString()) > 1) {
                newmap.remove(k / 2);
                op+=1;
            }
        }

        if (newmap.containsKey(0) && Integer.parseInt(newmap.get(0).toString()) > 1) {
            newmap.remove(0);
            op+=1;
        }


        for (Map.Entry m : newmap.entrySet()) {
            //System.out.println("key "+m.getKey()+"value "+m.getValue());
            op = op + Integer.parseInt(m.getValue().toString());
        }


        System.out.println(op);


        return op;

    }

}

public class NonDivisibleSubset {
    public static void main(String[] args) throws IOException {

        Integer arr[] = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        List<Integer> s = new ArrayList(Arrays.asList(arr));

        int result = Result.nonDivisibleSubset(4, s);

    }
}
