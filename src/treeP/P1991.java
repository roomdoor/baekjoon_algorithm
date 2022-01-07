package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class P1991 {
    public static ArrayList<ArrayList<Node>> treeMap;
    public static boolean[] isVisited;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        treeMap = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            treeMap.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());


            int parent = st.nextToken().charAt(0) - 65;
            int leftChild = translator(st.nextToken());
            int rightChild = translator(st.nextToken());

            treeMap.get(parent).add(new Node(leftChild, rightChild));
        }

        preorderTraversal(0);
        sb.append("\n");

        inorderTraversal(0);
        sb.append("\n");

        postorderTraversal(0);

        System.out.println(sb.toString());
    }

    public static void preorderTraversal(int idx) {
        if (idx == 27) {
            return;
        }
        sb.append((char) (idx + 65));

        for (Node child : treeMap.get(idx)) {
            preorderTraversal(child.left);
            preorderTraversal(child.right);
        }
    }

    public static void inorderTraversal(int idx) {
        for (Node child : treeMap.get(idx)) {
            if (child.left == 27) {
                sb.append((char) (idx + 65));
                if (child.right != 27) {
                    inorderTraversal(child.right);
                }
            } else {
                inorderTraversal(child.left);
                sb.append((char) (idx + 65));
                if (child.right != 27) {
                    inorderTraversal(child.right);
                }
            }
        }
    }

    public static void postorderTraversal(int idx) {
        for (Node node : treeMap.get(idx)) {
            if (node.left == 27) {
                if (node.right == 27) {
                    sb.append((char) (idx + 65));
                    return;
                } else {
                    postorderTraversal(node.right);
                    sb.append((char) (idx + 65));
                    return;
                }
            } else {
                postorderTraversal(node.left);
            }
            if (node.right == 27) {
                sb.append((char) (idx + 65));
                return;
            } else {
                postorderTraversal(node.right);
            }
            sb.append((char) (idx + 65));
        }
    }

    public static int translator(String alphabet) {
        if (Objects.equals(alphabet, ".")) {
            return 27;
        } else {
            return alphabet.charAt(0) - 65;
        }
    }

    private static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
