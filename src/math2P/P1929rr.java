package math2P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1929rr {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[] isChecked = new boolean[n + 2];
        isChecked[0] = true;
        isChecked[1] = true;

        for (int i = 2; i <= n; i++) {
            for (int j = i * 2; j <= n; j += i) {
                isChecked[j] = true;
            }
        }

        for (int i = m; i <= n; i++) {
            if(!isChecked[i])
                sb.append(i).append("\n");
        }

        System.out.println(sb.toString());
    }
}
