package dynamic;

import javax.management.MXBean;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P11054re {
    public static int[] arr;
    public static int[] DPI;
    public static int[] DPD;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        arr = new int[n];
        DPI = new int[n];
        DPD = new int[n];

        for (int i = 0; i < n; i++) {
            DPI[i] = 1;
            DPD[i] = 1;
        }

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            makeDPD(n - 1 - i);
            makeDPI(i);
        }

        int Max = -1;

        for (int i = 0; i < n; i++) {
            Max = Math.max(Max, DPI[i] + DPD[i] - 1);
        }

        System.out.println(Max);
    }

    public static int makeDPI(int num) {
        for (int i = 0; i < num; i++) {
            if (arr[num] > arr[i]) {
                DPI[num] = Math.max(DPI[num], DPI[i] + 1);
            }
        }

        return DPI[num];
    }

    public static int makeDPD(int num) {
        for (int i = num; i < arr.length; i++) {
            if (arr[num] > arr[i]) {
                DPD[num] = Math.max(DPD[num], DPD[i] + 1);
            }
        }

        return DPD[num];
    }
}
