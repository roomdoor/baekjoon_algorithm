package twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P1644 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        boolean[] sosuCheck = new boolean[n + 1];
        sosuCheck[0] = true;
        sosuCheck[1] = true;

        for (int i = 2; i * i <= n; i++) {
            for (int j = i * i; j <= n; j += i) {
                sosuCheck[j] = true;
            }
        }

        ArrayList<Integer> sosuList = new ArrayList<>();
        for (int i = 2; i < sosuCheck.length; i++) {
            if (!sosuCheck[i]) {
                sosuList.add(i);
            }
        }

        int count = 0;
        int start = 0;
        int end = 0;
        int sum = 2;

        while (start <= end && n > 1) {
            if (sum < n) {
                if (end < sosuList.size() - 1) {
                    end++;
                    sum += sosuList.get(end);
                } else break;
            } else {
                if (sum == n) {
                    count++;
                }
                sum -= sosuList.get(start);
                start++;
            }

        }

        System.out.println(count);
    }
}
