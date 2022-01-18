package unionFInd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1976 {
    public static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        int m = Integer.parseInt(bf.readLine());

        map = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            map[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if (a == 1) {
                    union(i, j);
                }
            }
        }

        int[] route = new int[m];
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < m; i++) {
            route[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(isChecked(route));

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

    public static String isChecked(int[] route) {
        for (int i = 0; i < route.length - 1; i++) {
            if (find(route[i]) != find(route[i + 1])) {
                return "NO";
            }
        }
        return "YES";
    }
}
