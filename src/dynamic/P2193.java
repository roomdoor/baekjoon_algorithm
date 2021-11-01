package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2193 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        long[][] arr = new long[n + 1][2];
        arr[1][0] = 0;
        arr[1][1] = 1;

        for (int i = 2; i < n + 1; i++) {

            if (arr[i - 1][1] != 0) {
                arr[i][0] += arr[i - 1][0] + arr[i - 1][1];
                arr[i][1] += arr[i - 1][0];
            } else if (arr[i - 1][1] == 0) {
                arr[i][0] += arr[i - 1][0] + arr[i - 1][1];
                arr[i][1] += arr[i - 1][0] + arr[i - 1][1];
            }
        }

        System.out.println(arr[n][0] + arr[n][1]);

    }
}
