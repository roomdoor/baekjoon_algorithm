package DandCp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1629 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(DP(A, B, C));
    }

    public static long DP(int A, int exponent, int C) {
        if (exponent == 1) {
            return A % C;
        }

        long temp = DP(A, exponent / 2, C);

        if (exponent % 2 == 1) {
            return (temp * temp % C) * A % C;
        }

        return (temp * temp) % C;
    }
}
