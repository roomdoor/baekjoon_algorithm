package treeP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Objects;
import java.util.StringTokenizer;

public class P1991re {
    public static int[][] treeMap;
    public static boolean[] isVisited;
    public static StringBuilder sb1 = new StringBuilder();
    public static StringBuilder sb2 = new StringBuilder();
    public static StringBuilder sb3 = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        treeMap = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            int parent = st.nextToken().charAt(0) - 65;
            int leftChild = st.nextToken().charAt(0) - 65;
            int rightChild = st.nextToken().charAt(0) - 65;

            treeMap[parent][0] = leftChild;
            treeMap[parent][1] = rightChild;
        }

        order(0);


        System.out.println(sb1.toString());
        System.out.println(sb2.toString());
        System.out.println(sb3.toString());

    }

    public static void order(int idx) {
        sb1.append((char) (idx + 65));
        if (treeMap[idx][0] > 0) {
            order(treeMap[idx][0]);
        }
        sb2.append((char) (idx + 65));

        if (treeMap[idx][1] > 0) {
            order(treeMap[idx][1]);
        }
        sb3.append((char) (idx + 65));
    }
}