package backTraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15649r {

    public static int[] arr;
    public static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        isVisited = new boolean[n];

        dfs(n, m, 0);

        System.out.println(sb.toString());

    }

    public static void dfs(int n, int m, int depth) {

        if (m == depth) {
            for (int number : arr)
                sb.append(number).append(" ");
            sb.append("\n");
            return;
        }

        if (depth != 0) {
            for (int i = arr[depth - 1] - 1; i < n; i++) {
                    arr[depth] = i + 1;
                    dfs(n, m, depth + 1);
            }
        } else {
            for (int i = 0; i < n; i++) {
                    arr[depth] = i + 1;
                    dfs(n, m, depth + 1);
            }
        }

    }
}