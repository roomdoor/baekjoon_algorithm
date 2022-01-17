package unionFInd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1717 {
    public static ArrayList<ArrayList<Integer>> map = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= n; i++) {
            map.add(new ArrayList<>());
            map.get(i).add(i);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int o = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (o == 0) {
                for (int temp : map.get(a)) {
                    map.get(b).add(temp);
                }
                for (int temp : map.get(b)) {
                    map.get(a).add(temp);
                }
            } else {
                if () {
                    sb.append("YES").append("\n");
                } else {
                    sb.append("NO").append("\n");
                }
            }

        }
    }

    public static boolean isChecked(int a, int b) {
        map.get(a).stream().
    }
}
