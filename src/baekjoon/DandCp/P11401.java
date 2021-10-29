package DandCp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11401 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        if (K < N) {
            int temp = K;
            K = N;
            N = temp;
        }

        System.out.println(bc(K, N) % 1000000007);

    }

    public static Integer[][] arr = new Integer[1][1];

    public static int bc(int a, int b) {
        if (a == b || b == 0) {
            return 1;
        }

        if (arr[a][b] != null) {
            return arr[a][b];
        }
        return arr[a][b] = (bc(a - 1, b - 1) + bc(a - 1, b)) % 1000000007;
    }

}
