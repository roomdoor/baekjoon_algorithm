package treeP;

import java.util.ArrayList;

public class ExceptionTest {
    public static void main(String[] args) {

        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            arr.add(i);
        }
//        System.out.println(arr.get(3));   //IndexOutOfBoundsException

        int[] arrr = new int[3];
//        System.out.println(arrr[3]);      //ArrayIndexOutOfBoundsException
    }
}
