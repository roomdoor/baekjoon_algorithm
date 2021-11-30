package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1450 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n / 2; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n - n / 2; i++) {
            arr2[i] = Integer.parseInt(st.nextToken());
        }

        int[] test = new int[]{1, 2, 3};
        ArrayList<Long> testList = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
        boolean[] testVisited = new boolean[3];
        RC(0,test,testVisited,testList, 0, i);
        }
        System.out.println(testList.toString());
//        System.out.println(twoPoint(arr,c));

    }

    public static int twoPoint(int[] arr, int c) {
        int answer = 0;

        ArrayList<Integer> num1 = new ArrayList<>();
        ArrayList<Integer> num2 = new ArrayList<>();

        return answer;
    }

    public static void RC(int DP, int[] arr, boolean[] isVisited, ArrayList<Long> num, long sum, int n) {
        if (DP == n) {
            num.add(sum);
            return;
        }

        for (int i = DP; i < arr.length; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                System.out.println(arr[i]);
                RC(DP + 1, arr, isVisited, num, sum, n);
                isVisited[i] = false;
            }
        }
    }
}
