package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2263 {
    public static int[] inOrder;
    public static int[] postOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        inOrder = new int[n];
        postOrder = new int[n];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextT:1:1oken());
        }

    }
}
