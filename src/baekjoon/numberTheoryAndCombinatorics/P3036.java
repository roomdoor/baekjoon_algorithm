package numberTheoryAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P3036 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];


        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < n; i++) {
            int GCF = gcf(arr[0], arr[i]);

            sb.append(arr[0] / GCF + "/" + arr[i] / GCF).append("\n");

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

