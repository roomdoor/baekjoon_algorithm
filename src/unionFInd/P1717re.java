package unionFInd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1717re {
    public static int[] unionFind;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        unionFind = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            unionFind[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int checked = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (checked == 1) {
                sb.append(isChecked(a, b)).append("\n");
            } else {
                union(a, b);
            }
        }

        System.out.println(sb.toString());
    }

    public static int find(int a) {
        if (a == unionFind[a]) {
            return a;
        } else {
            return unionFind[a] = find(unionFind[a]);
        }
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a > b) {
                unionFind[a] = b;
            } else {
                unionFind[b] = a;
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
