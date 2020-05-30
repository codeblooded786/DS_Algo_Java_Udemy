package graph_algo.bfs;

public class StockBuySell {

    public static int maximizeProfit(int arr[])
    {
        int buy;
        int flag=0;
        for (int i=0;i<arr.length;i++)
        {
            if (flag!=0 && arr[i]<arr[i+1])
            {
                buy=arr[i];
                flag=1;
            }

        }

        return 1;
    }


    public static void main(int args[]) {
        int price[] = {100, 180, 260, 310,
                40, 535, 695};

        int result = maximizeProfit(price);


    }

}
