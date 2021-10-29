package numberTheoryAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11051 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        if (a < b) {
            int temp = a;
            a = b;
            b = temp;
        }

        System.out.println(bc(a, b) % 10007);


    }

    public static Integer[][] arr = new Integer[1001][1001];

    public static int bc(int a, int b) {
        if (a == b || b == 0) {
            return 1;
        }

        if (arr[a][b] != null) {
            return arr[a][b];
        }
        return arr[a][b] = (bc(a - 1, b - 1) + bc(a - 1, b)) % 10007;
    }
}
