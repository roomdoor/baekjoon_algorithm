package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11054 {

    public static int[] arr;
    public static Integer[] DPDouwn;
    public static Integer[] DPUp;


    public static int dpUP(int depth) {

        if (DPUp[depth] == null) {
            DPUp[depth] = 1;


            for (int i = depth - 1; 0 <= i; i--) {
                if (arr[depth] > arr[i]) {
                    DPUp[depth] = Math.max(dpUP(i) + 1, DPUp[depth]);
                }
            }
        }
        return DPUp[depth];
    }

    public static int dpDown(int depth) {

        if (DPDouwn[depth] == null) {
            DPDouwn[depth] = 1;

            for (int i = depth + 1; i < arr.length; i++) {
                if (arr[depth] > arr[i]) {
                    DPDouwn[depth] = Math.max(dpDown(i) + 1, DPDouwn[depth]);
                }
            }
        }
        return DPDouwn[depth];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        DPUp = new Integer[n];
        DPDouwn = new Integer[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            dpDown(i);
            dpUP(i);
        }


        int max = -1;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, DPUp[i] + DPDouwn[i]);
        }

        System.out.println(max - 1);

    }
}
