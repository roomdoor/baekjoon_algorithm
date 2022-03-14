package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class P1931re {
    public static int[][] conferenceTime;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        conferenceTime = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            conferenceTime[i][0] = Integer.parseInt(st.nextToken());
            conferenceTime[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(conferenceTime, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                } else {
                    return o1[1] - o2[1];
                }
            }
        });

        int count = 1;
        int preEndTime = conferenceTime[0][1];

        for (int i = 1; i < n; i++) {
            if (preEndTime <= conferenceTime[i][0]) {
                count++;
                preEndTime = conferenceTime[i][1];
            }
        }

        System.out.println(count);
    }
}
