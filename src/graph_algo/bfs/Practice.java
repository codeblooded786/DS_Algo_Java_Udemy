package graph_algo.bfs;


import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MONTHS;

public class Practice {

    // Complete the compareTriplets function below.
    /*static List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {

        //List<Integer> list = new ArrayList<>(Collections.nCopies(2, 0));
        List<Integer> list = new ArrayList<>();
        Integer x = 0, y = 0;

        for (int i = 0; i < a.size(); i++) {
            if (a.get(i) > b.get(i))
                x += 1;
            if (b.get(i) > a.get(i))
                y += 1;
        }

        list.add(x);
        list.add(y);

     //   System.out.println(list.get(0)+" "+list.get(1));

        return list;

    }*/

    static String timeConversion(String s) {

        if (s.charAt(8) == 'A') {
            Integer hour = Integer.parseInt(s.substring(0, 2));

            if (hour == 12) {

                System.out.println("00" + s.substring(2, 8));
                return "00" + s.substring(2, 8);
            }
            System.out.println(s.substring(0, 8));
            return s.substring(0, 8);
        } else {
            Integer hour = Integer.parseInt(s.substring(0, 2));
            if (hour != 12)
                hour = Integer.parseInt(s.substring(0, 2)) + 12;

            System.out.println(hour + s.substring(2, 8));

            return hour + s.substring(2, 8);

        }


    }

    static String kangaroo(int x1, int v1, int x2, int v2) {

        int flag = 0;
        int i = Math.abs(x1 - x2);

        while (i > 0) {
            x1 += v1;
            x2 += v2;
            if (x1 == x2) {
                flag = 1;
                break;
            }
            i--;
        }
        return flag == 1 ? "YES" : "NO";


    }

    static int migratoryBirds(List<Integer> arr) {

        Map<Integer, Integer> matrix = new HashMap<Integer, Integer>();

        for (Integer i : arr) {
            if (!matrix.containsKey(i)) {
                matrix.put(i, 1);
            } else {
                Integer count = matrix.get(i);
                matrix.put(i, count + 1);
            }
        }

        /*matrix.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue()).*/
        Map<Integer, Integer> mymap = new LinkedHashMap<>();
        mymap = matrix.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));

        for (Map.Entry<Integer, Integer> entry : mymap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Map.Entry<Integer, Integer> entry = mymap.entrySet().iterator().next();
        Integer key = entry.getKey();
        Integer value = entry.getValue();

        return key;

        //return (int) mymap.values().toArray()[0];


    }

    static int countingValleys(int n, String s) {

        int seaLevel = 0;
        int valley = 0, mountain = 0;
        for (int i = 0; i < s.length(); ) {
            while (s.charAt(i) == 'U') {
                seaLevel++;
                i++;
            }

            if (s.charAt(i) == 'D')
                seaLevel--;


        }

        return 1;
    }

    public static int pickingNumbers(List<Integer> a) {
        // Write your code here

        Collections.sort(a);
        Map<Integer, Integer> matrix = new HashMap<Integer, Integer>();

        Integer maximum = -1;

        for (Integer x : a) {
            if (x > maximum)
                maximum = x;
            if (!matrix.containsKey(x)) {
                matrix.put(x, 1);
            } else {
                matrix.put(x, matrix.get(x) + 1);
            }
        }

        maximum = matrix.values().stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).get(0);

        Map<Integer, Integer> mymap = new HashMap<Integer, Integer>();

        mymap = matrix.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));


        Iterator<Map.Entry<Integer, Integer>> itr = mymap.entrySet().iterator();

        Map.Entry<Integer, Integer> entry2 = itr.next();

        int key = entry2.getKey();

        int value = entry2.getValue();

        int max = -1;

        while (itr.hasNext()) {

            Map.Entry<Integer, Integer> entry = itr.next();

            if (Math.abs(key - entry.getKey()) == 1 && max < value + entry.getValue()) {
                max = value + entry.getValue();
            }

            key = entry.getKey();
            value = entry.getValue();

        }

        return maximum > max ? maximum : max;

    }

    static int hurdleRace(int k, int[] height) {

        Integer brr[] = Arrays.stream(height).boxed().toArray(Integer[]::new);

        List<Integer> list = Arrays.asList(brr);

        Integer maximum;

        maximum = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList()).get(0);

        return k > maximum ? 0 : maximum - k;


    }

    static int designerPdfViewer(int[] h, String word) {

        int max = -1;


        for (int i = 0; i < word.length(); i++) {
            /*char c=word.charAt(i);

            int ascii = (int)c-97;*/

            if (max < h[word.charAt(i) - 'a']) {
                max = h[word.charAt(i) - 'a'];
            }

        }

        return word.length() * max;

    }

    static int viralAdvertising(int n) {

        int base = 5;
        int liked = (int) Math.floor(base / 2);
        int shared = (int) Math.floor(base / 2);
        int count = 2;

        while (n-- > 0) {
            shared = liked * 3;
            liked = (int) Math.floor(shared / 2);
            count += liked;
        }

        return count;

    }

    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {


        /*LocalDate returnDate = LocalDate.of(y1,m1,d1);
        LocalDate dueDate = LocalDate.of(y2,m2,d2);*/
        LocalDate returnDate = LocalDate.of(2014,5,5);
        LocalDate dueDate = LocalDate.of(2014,2,23);

        if (dueDate.isAfter(returnDate))
            return 0;

        if(returnDate.getYear()>dueDate.getYear())
            return 10000;

        if(returnDate.getMonthValue()>dueDate.getMonthValue())
           // return ((returnDate.getMonthValue()-dueDate.getMonthValue())*500);
            return (int) (MONTHS.between(dueDate, returnDate)*500);


        if(returnDate.getDayOfMonth()>dueDate.getDayOfMonth())
            return (int) (DAYS.between(dueDate, returnDate)*15);

        return 0;

    }



    public static void main(String[] args) throws IOException {


        // String result = timeConversion("12:40:22AM");
        // String ans = kangaroo(0,3,4,2);

//        Integer brr[] = {4, 6, 5, 3, 3, 1};
//
//        List<Integer> arr = Arrays.asList(brr);
//
//        int ans = pickingNumbers(arr);

        int h[] = {1, 3, 1, 3, 1, 4, 1, 3, 2, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 7};

        //int result = designerPdfViewer(h, "zaba");

        int result = libraryFine(1,2,3,4,5,6);

        // int ans = migratoryBirds(arr);


        System.out.println(result);

       /* List<Integer> a = new ArrayList<>(Arrays.asList(17, 28, 30));

        List<Integer> b = Arrays.asList(99, 16, 8);

        List<Integer> result = compareTriplets(a, b);*/


    }
}
