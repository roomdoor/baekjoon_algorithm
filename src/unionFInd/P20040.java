package unionFInd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P20040 {
    public static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        map = new int[n];
        for (int i = 0; i < n; i++) {
            map[i] = i;
        }

        int anser = 0;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            if (union(a, b)) {
                anser = i;
                break;
            }
        }
        System.out.println(anser);
    }

    public static int find(int a) {
        if (a == map[a]) {
            return a;
        } else {
            return map[a] = find(map[a]);
        }
    }

    public static boolean union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            if (a < b) {
                map[b] = a;
            } else if (b < a) {
                map[a] = b;
            }
            return false;
        } else {
            return true;
        }
    }
}
