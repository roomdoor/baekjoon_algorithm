package dfsAndBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] isChecked = new int[200002];

        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{n, 0});

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int point = temp[0];
            int time = temp[1];
            isChecked[point] = time;

            if (point == m) {
                System.out.println(time);
                break;
            }

            if (point > 0 && isChecked[point - 1] == 0)
                queue.add(new int[]{point - 1, time + 1});


            if (point < m) {
                if (isChecked[point + 1] == 0)
                    queue.add(new int[]{point + 1, time + 1});

                if (isChecked[point * 2] == 0)
                    queue.add(new int[]{point * 2, time + 1});
            }
        }
    }
}
