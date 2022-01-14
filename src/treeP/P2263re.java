package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2263re {
    public static int[] inOrder;
    public static int[] postOrder;
    public static int[] position;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        inOrder = new int[n];
        postOrder = new int[n];
        position = new int[n + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            inOrder[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            postOrder[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            position[inOrder[i]] = i;
        }

        makePreOrder(0, n - 1, 0, n - 1);

        System.out.println(sb.toString());
    }

    public static void makePreOrder(int IS, int IE, int PS, int PE) {
        if (IS <= IE && PS <= PE) {
            int root = postOrder[PE];
            sb.append(root).append(" ");

            root = position[root];

            makePreOrder(IS, root - 1, PS, PS + root - IS - 1);
            makePreOrder(root + 1, IE, PS + root - IS, PE - 1);
        }
    }
}