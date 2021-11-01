package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9461 {

    public static long[] waveArr = new long[101];

    public static long makeWaveArr(int n) {

        if (n <= 3) {
            waveArr[n] = 1;
            return waveArr[n];
        }

        if (waveArr[n - 2] != 0 && waveArr[n - 3] != 0) {
            waveArr[n] = waveArr[n - 2] + waveArr[n - 3];
            return waveArr[n];
        }

        waveArr[n] = makeWaveArr(n - 2) + makeWaveArr(n - 3);
        return waveArr[n];
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());

        for (int i = 0; i < n; i++) {
            System.out.println(makeWaveArr(Integer.parseInt(bf.readLine())));
        }
    }
}
