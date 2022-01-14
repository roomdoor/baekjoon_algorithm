package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class P5639 {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(sti(bf.readLine()));

        while (true) {
            String node = bf.readLine();
            if (Objects.equals(node, "") || node == null) break;
            Node next = new Node(sti(node));
            treeLink(root, next);
        }

        makePO(root);

        System.out.println(sb.toString());

    }

    public static void treeLink(Node now, Node next) {
        if (now.n > next.n) {
            if (now.left == null) {
                now.left = next;
            } else {
                treeLink(now.left, next);
            }
        } else {
            if (now.right == null) {
                now.right = next;
            } else {
                treeLink(now.right, next);
            }
        }
    }

    public static void makePO(Node root) {
        if (root.left != null) {
            makePO(root.left);
        }

        if (root.right != null) {
            makePO(root.right);
        }
        sb.append(root.n).append("\n");
    }

    private static class Node {
        int n;
        Node left;
        Node right;

        public Node(int n) {
            this.n = n;
        }
    }

    public static int sti(String s) {
        return Integer.parseInt(s);
    }
}
