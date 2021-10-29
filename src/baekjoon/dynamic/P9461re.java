package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9461re {

    public static long[] arr = new long[101];

    public static long fivo(int n) {

        if (arr[n] == 0) {
            arr[n] = fivo(n - 2) + fivo(n - 3);
            return arr[n];
        }
        return arr[n];
    }


    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());

        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;

        for (int i = 0; i < n; i++) {
            sb.append(fivo(Integer.parseInt(bf.readLine()) - 1)).append("\n");
        }

        System.out.println(sb.toString());


    }
}
