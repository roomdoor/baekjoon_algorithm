package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12852 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(bf.readLine());
        int[] DP = new int[num + 1];
        int[] trace = new int[num + 1];

        for (int i = 2; i <= num; i++) {
            DP[i] = DP[i - 1] + 1;
            trace[i] = i - 1;

            if (i % 2 == 0 && DP[i] > DP[i / 2] + 1) {
                DP[i] = DP[i / 2] + 1;
                trace[i] = i / 2;
            }

            if (i % 3 == 0 && DP[i] > DP[i / 3] + 1) {
                DP[i] = DP[i / 3] + 1;
                trace[i] = i / 3;
            }
        }


        System.out.println(DP[num]);

        sb.append(num).append(" ");
        while (num > 1) {
            sb.append(trace[num]).append(" ");
            num = trace[num];
        }
        System.out.println(sb.toString());
    }
}
