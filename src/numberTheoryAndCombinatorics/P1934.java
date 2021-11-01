package numberTheoryAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1934 {

    public static int gcf(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcf(b, a % b);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a < b) {
                int temp = a;
                a = b;
                b = temp;
            }

            sb.append(a * b / gcf(a, b)).append("\n");
        }

        System.out.println(sb.toString());
    }
}
