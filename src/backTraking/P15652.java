package backTraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15652 {
    public static int[] arr;
    public static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();
    public static int temp;


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
        if (depth == m) {
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = temp; i < n; i++) {
            if (!isVisited[i]) {
                temp = i;
                arr[depth] = i + 1;
                dfs(n, m, depth + 1);

            }
        }
    }
}
