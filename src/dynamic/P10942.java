package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10942 {
    public static int[] map;
    public static int[] odd;
    public static int[] even;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        map = new int[n + 1];
        odd = new int[n + 1];
        even = new int[n + 1];

        StringTokenizer st = new StringTokenizer(bf.readLine());

        for (int i = 1; i <= n; i++) {
            map[i] = Integer.parseInt(st.nextToken());
            odd[i] = -1;
            even[i] = -1;
        }

        int m = Integer.parseInt(bf.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            palindrome(a, b);
        }

        System.out.println(sb.toString());

    }

    public static void palindrome(int a, int b) {
        if ((a + b) % 2 == 0) {         // 홀수
            int mid = (a + b) / 2;      // 중간 index
            int gap = b - a;            // index 갯수
            int hGap = (b - a) / 2;            // index 갯수

            if (odd[mid] == -1 || odd[mid] < hGap) {
                if (odd[mid] == -1) {
                    odd[mid] = 0;
                }

                for (int i = odd[mid] + 1; i <= hGap; i++) {
                    if (map[mid - i] == map[mid + i]) {
                        odd[mid] += 1;
                    } else {
                        break;
                    }
                }
            }

            if (odd[mid] >= hGap) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }

        } else {

            int mid = (a + b) / 2;
            int gap = b - a;
            int hGap = (b - a + 1) / 2;

            if (even[mid] == -1 || even[mid] < hGap) {
                if (even[mid] == -1) {
                    even[mid] = 0;
                }

                for (int i = even[mid]; i < hGap; i++) {
                    if (map[mid - i] == map[mid + 1 + i]) {
                        even[mid] += 1;
                    } else {
                        break;
                    }
                }
            }

            if (even[mid] >= hGap) {
                sb.append(1).append("\n");
            } else {
                sb.append(0).append("\n");
            }
        }
    }
}
