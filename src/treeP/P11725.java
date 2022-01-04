package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());


        }
    }

    private static class Node {
        int node;
        Node left;

        public Node(int node, Node left) {
            this.node = node;
            this.left = left;
        }
    }
}
