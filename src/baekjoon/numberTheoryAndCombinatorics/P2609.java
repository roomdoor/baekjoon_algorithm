package numberTheoryAndCombinatorics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2609 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int GCF = 1;
        boolean[] arr = new boolean[10001];

        for (int i = 2; i <= a; i++) {
            if (a % i == 0) {
                arr[i] = true;
            }
        }

        for (int i = a; i >= 2; i--) {
            if (arr[i]) {
                if (b % i == 0) {
                    GCF = i;
                    break;
                }
            }
        }

        System.out.println(GCF);
        System.out.println(a * b / GCF);

    }
}
