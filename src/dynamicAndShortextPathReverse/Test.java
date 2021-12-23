package dynamicAndShortextPathReverse;

import java.util.*;

public class Test {
    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
//
//        int x = scanner.nextInt();
//        int count = 0;
//        while (count < 10) {
//            if (x < 20) continue;
//            x++;
//            count++;
//        }
//
//        System.out.println(x + " " + count);


        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> newDeque = new ArrayDeque<>();

        for (int i = 0; i < 5; i++) {
            deque.add(i);
        }


        deque.pollLast();
        System.out.println(deque.toString());
        System.out.println(newDeque.toString());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            arr.add(i);
        }
        ArrayList<Integer> newArr = new ArrayList<>();
        newArr = (ArrayList<Integer>) arr.clone();

        System.out.println("-------------------------------");
        arr.remove(1);
        System.out.println(arr.toString());
        System.out.println(newArr.toString());


    }
}
