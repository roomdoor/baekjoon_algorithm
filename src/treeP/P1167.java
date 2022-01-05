package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1167 {
    public static ArrayList<ArrayList<Node>> linkMap = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int v = Integer.parseInt(bf.readLine());
        linkMap.add(new ArrayList<>());
        for (int i = 1; i <= v; i++) {
            linkMap.add(new ArrayList<>());
            StringTokenizer st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            while (s != -1) {
                int dis = Integer.parseInt(st.nextToken());
                linkMap.get(n).add(new Node(n, s, dis));
                s = Integer.parseInt(st.nextToken());
            }
        }

    }



    private static class Node implements Comparable<Node> {
        int a;
        int b;
        int dis;

        public Node(int a, int b, int dis) {
            this.a = a;
            this.b = b;
            this.dis = dis;
        }

        @Override
        public int compareTo(Node o) {
            return o.dis - this.dis;
        }
    }
}
