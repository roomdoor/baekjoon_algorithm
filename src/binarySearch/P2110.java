package binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2110 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        home = new int[N];

        for (int i = 0; i < N; i++) {
            home[i] = Integer.parseInt(bf.readLine());
        }

        Arrays.sort(home);

        BS(1, home[home.length - 1] - home[0], C);

        System.out.println(answer);
    }

    public static int[] home;
    public static int answer = -1;

    public static void BS(int min, int max, int C) {
        if (min > max)
            return;

        int mid = (min + max) / 2;
        int count = isPossible(mid);

        if (count >= C) {
            answer = Math.max(answer, mid);
            BS(mid + 1, max, C);
        } else {
            BS(min, mid - 1, C);
        }


    }

    public static int isPossible(int mid) {
        int homeFlag = home[0];
        int count = 1;

        for (int i = 1; i < home.length; i++) {
            if (homeFlag + mid <= home[i]) {
                count++;
                homeFlag = home[i];
            }
        }
        return count;
    }
}
