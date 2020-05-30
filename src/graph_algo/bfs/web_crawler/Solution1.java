package graph_algo.bfs.web_crawler;

/**
 * @project GraphAlgorithms
 * Created by @author Rahul Dev Gupta on 30/05/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */



import java.util.Scanner;

public class Solution1
{

    public static void main(String args[])
    {
        Scanner kb = new Scanner(System.in);
        int t=kb.nextInt();
        int n;

        while(t-->0)

        {
            n=kb.nextInt();
            int x,y,distance=0;

            for(int i=0;i<n;i++)
            {
                x=kb.nextInt();
                y=kb.nextInt();

                if(x==y)
                    distance+=x;
            }
            System.out.println(distance);

        }

    }
}