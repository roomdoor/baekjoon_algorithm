package unionFInd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1717 {
    public static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            map[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int o = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (o == 0) {
                union(a, b);
            } else if (o == 1) {
                sb.append(isChecked(a, b)).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    public static int find(int a) {
        if (a == map[a]) {
            return a;
        } else {
            return map[a] = find(map[a]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                map[b] = a;
            } else {
                map[a] = b;
            }
        }
    }

    public static String isChecked(int a, int b) {
        a = find(a);
        b = find(b);

        if (a == b) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
