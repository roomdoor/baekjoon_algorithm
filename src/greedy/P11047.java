package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11047 {

    public static int[] arr;
    public static Integer[] Greedy;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int won = Integer.parseInt(st.nextToken());
        int count = 0;

        arr = new int[n];
        Greedy = new Integer[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(bf.readLine());
        }


        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] <= won) {
                count += won / arr[i];
                won = won % arr[i];
            }
        }

        System.out.println(count);
    }
}
