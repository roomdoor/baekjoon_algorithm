package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P14888re {
    public static int answer = Integer.MAX_VALUE;
    public static int[][] status;
    public static boolean[] isChecked;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        status = new int[n + 1][n + 1];
        isChecked = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 1; j <= n; j++) {
                status[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        backTracking(n, 0, 1);
        System.out.println(answer);

    }

    public static void backTracking(int n, int depth, int before) {
        if (depth == n / 2) {
            int startTeamScore = 0;
            int linkTeamScore = 0;
            for (int i = 1; i <= n; i++) {
                if (isChecked[i]) {
                    for (int j = i + 1; j <= n; j++) {
                        if (isChecked[j]) {
                            startTeamScore += status[i][j] + status[j][i];
                        }
                    }
                } else {
                    for (int j = i + 1; j <= n; j++) {
                        if (!isChecked[j]) {
                            linkTeamScore += status[i][j] + status[j][i];
                        }
                    }
                }
            }

            int valance = Math.abs(startTeamScore - linkTeamScore);
            int temp = answer;
            answer = Math.min(answer, valance);
//            ArrayList<Integer> arr = new ArrayList<>();
//            ArrayList<Integer> arr1 = new ArrayList<>();
//
//            for (int i = 1; i <= n; i++) {
//                if (isChecked[i]) {
//                    arr.add(i);
//                } else {
//                    arr1.add(i);
//                }
//            }
//            System.out.println("startTeam : " + arr.toString() + " " + startTeamScore);
//            System.out.println("linkTeam : " + arr1.toString() + " " + linkTeamScore);
//            System.out.println();
//            System.out.println(valance);
//            System.out.println();

            return;
        }

        for (int i = before; i <= n; i++) {
            if (isChecked[i]) continue;
            isChecked[i] = true;
            backTracking(n, depth + 1, i);
            isChecked[i] = false;
        }
    }
}
