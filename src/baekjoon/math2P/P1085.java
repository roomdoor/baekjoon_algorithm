package math2P;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1085 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());


        int up = h - y;
        int down = y;
        int right = w - x;
        int left = x;

        int vertical = Math.min(up, down);
        int horizontal = Math.min(right, left);

        System.out.println(Math.min(vertical, horizontal));


    }
}
