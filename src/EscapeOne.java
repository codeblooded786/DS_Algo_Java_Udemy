import java.util.Scanner;

/**
 * @project GraphAlgorithms
 * Created by @author Rahul Dev Gupta on 30/05/20
 * Time Complexity: O()    |   Auxiliary Space: O()
 */
public class EscapeOne {

    public static boolean checkOne(int brr[]) {
        for (int i = 0; i < brr.length; i++) {
            if (brr[i] == 1)
                return true;
        }
        return false;
    }

    public static int findNearestNonZero(int crr[],int index)
    {
        int flag=0;
        int forwardIndex=-1;
        int backwardIndex=-1;
        for (int i=index;i<crr.length;i++)
        {
            if (crr[i]!=0)
            {
                forwardIndex=i;
                flag=1;
                break;
            }
        }
        int forwardDistance = forwardIndex-index;
        for (int i = crr.length-1;i>index;i++)
        {
            if (crr[i]!=0)
            {
                backwardIndex=i;
                flag=1;
                break;
            }
        }

        int backwardDistance = (crr.length-backwardIndex)+index;

        if (flag==0)
            return -1;

        if (forwardDistance<=backwardDistance)
            return 1;
        return 0;

    }

    public static void main(String args[]) {

        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        int n = 0;
        int arr[] = new int[1];
        while (t-- > 0) {
            n = kb.nextInt();
            arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = kb.nextInt();
            }


            int count = 0;

            for (int i = 0; i < n-1; i++) {
                if (arr[i] == 1) {
                    if (findNearestNonZero(arr,i)==1);
                    {
                        arr[i]=0;
                        arr[i+1]=arr[i+1]+1;
                        count++;
                    }
                    if (findNearestNonZero(arr,i)==0)
                    {
                        arr[i]=0;
                        if (i-1==-1)
                        {
                            arr[arr.length-1]=arr[arr.length-1]+1;
                        }
                    }


                }

                if (checkOne(arr) == false) {
                    break;
                }

            }
            System.out.println(count);
        }
    }
}
