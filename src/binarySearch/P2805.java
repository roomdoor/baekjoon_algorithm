package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        tree = new int[N];
        int MAX = 0;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());

            if (tree[i] > MAX) MAX = tree[i];
        }

        BS(0, MAX, M);

        System.out.println(answer);
    }

    public static int[] tree;
    public static int answer = 0;

    public static void BS(int min, int max, int M) {
        if (min >= max) {
            answer = min - 1;
            return;
        }

        int mid = (min + max) / 2;
        long sum = 0;

        for (int treeHeight : tree)
            if (treeHeight > mid) sum += treeHeight - mid;

        if (sum < M)
            BS(min, mid, M);

        else
            BS(mid + 1, max, M);

    }
}
