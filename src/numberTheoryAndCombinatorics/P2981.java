package numberTheoryAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2981 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(arr);
        int GCF = arr[1] - arr[0];

        for (int i = 2; i < n; i++) {
            GCF = gcf(GCF, arr[i] - arr[i - 1]);
        }

        for (int i = 2; i <= GCF; i++) {
            if (GCF % i == 0) {
                sb.append(i + " ");
            }
        }
        System.out.println(sb.toString());

    }


    public static int gcf(int a, int b) {

        while (b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
}


