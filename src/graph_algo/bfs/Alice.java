package graph_algo.bfs;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Alice {
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        SortedSet<Integer> scoresSet = new TreeSet<>(Collections.reverseOrder());
        scoresSet.addAll(Arrays.stream(scores).boxed().collect(Collectors.toList()));
        int ranklist[] = new int[alice.length];
        List<Integer> scoreList = new ArrayList<>(scoresSet);

        int k = 0;
        /*for (Integer i : scoresSet) {
            System.out.println("scores " + i);
        }
        for (int i=0;i<alice.length;i++)
            System.out.println(alice[i]);*/

        for (int i = 0; i < alice.length; i++) {
           // int flag = 0;
            for (int j = 0; j < scoresSet.size(); j++) {
                if (alice[i] < scoreList.get(scoreList.size()-1))
                {
                    ranklist[k] = scoresSet.size()+1;
                    break;
                }
                if (alice[i] >= scoreList.get(j)) {
                    ranklist[k] = j + 1;
                    break;
                }
            }
            /*if (flag == 0)
                ranklist[k] = scoresSet.size() + 1;*/
            k++;
        }
        return ranklist;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int[] scores = {100, 100, 50, 40, 40, 20, 10};
        int[] alice = {5, 25, 50, 120};
        int[] result = climbingLeaderboard(scores, alice);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }

    }
}
