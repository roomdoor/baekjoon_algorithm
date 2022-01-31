package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2629 {
    public static int[] weight = new int[501];
    public static int[] isChecked = new int[501];
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            int w = Integer.parseInt(st.nextToken());
            weight[w] += 1;
        }

        int marble = Integer.parseInt(bf.readLine());
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < marble; i++) {
            int m = Integer.parseInt(st.nextToken());
            isChecked = new int[501];
            weightChecked(m, 0, n);
        }

        System.out.println(sb.toString());
    }

    public static void weightChecked(int left, int right, int n) {
        n -= 1;
        int gap = Math.abs(left - right);
        int temp = 0;
        int leftNew = left;
        int rightNew = right;

        if (gap <= 500) {
            if (left < right) {
                while (left == leftNew) {
                    if (gap + temp <= 500 && isChecked[gap + temp] < weight[gap + temp]) {
                        leftNew += gap + temp;
                        isChecked[gap + temp] += 1;
                    } else if (gap - temp > 0 && isChecked[gap - temp] < weight[gap - temp]) {
                        leftNew += gap + temp;
                        isChecked[gap - temp] += 1;
                    } else {
                        temp++;
                    }
                }
            } else {
                while (right == rightNew) {
                    if (gap + temp <= 500 && isChecked[gap + temp] < weight[gap + temp]) {
                        rightNew += gap + temp;
                        isChecked[gap + temp] += 1;
                    } else if (gap - temp > 0 && isChecked[gap - temp] < weight[gap - temp]) {
                        rightNew += gap + temp;
                        isChecked[gap - temp] += 1;
                    } else {
                        temp++;
                    }
                }
            }
        } else {
            int MaxW = 500;
            while (right == rightNew) {
                if (weight[MaxW] != 0) {
                    rightNew += MaxW;
                    isChecked[MaxW] += 1;
                } else {
                    MaxW--;
                }
            }
        }

        if (leftNew == rightNew) {
            sb.append("Y").append(" ");
        } else if (n == 0) {
            sb.append("N").append(" ");
        } else {
            weightChecked(leftNew, rightNew, n);
        }
    }
}
