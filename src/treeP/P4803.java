package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P4803 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;

        int n = 1;
        int m = 1;

        while (n != 0 && m != 0) {
            ArrayList<Node> tree = new ArrayList<>();
            StringTokenizer st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(bf.readLine());
                int one = Integer.parseInt(st.nextToken());
                int two = Integer.parseInt(st.nextToken());
                tree.add(new Node(one));
                tree.get(i).child.add(new Node(two));
            }


        }


        if (count == 0) {
            System.out.println("No trees.");
        } else if (count == 1) {
            System.out.println("There is one tree.");
        } else {
            System.out.println("A forest of " + count + " trees.");
        }
    }

    public static void treeCheck(int count, ArrayList<Node> tree) {

    }


    private static class Node {
        int num;
        ArrayList<Node> child = new ArrayList<>();

        public Node(int num) {
            this.num = num;
        }
    }

}
