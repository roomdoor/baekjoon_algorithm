package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class P9252 {
    public static int[][] arr;
    public static int[] num;
    public static String n;
    public static String m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = bf.readLine();
        m = bf.readLine();

        num = new int[n.length()];
        arr = new int[n.length() + 1][m.length() + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n.length(); i++) {
            for (int j = 1; j <= m.length(); j++) {
                if (n.charAt(i - 1) == m.charAt(j - 1)) {
                    arr[i][j] += arr[i - 1][j - 1] + 1;
                    num[i - 1] = arr[i][j];
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        int result = arr[n.length()][m.length()];
        sb.append(result).append("\n");
        if (result != 0) {
            Stack<Character> CS = new Stack<>();
            for (int i = num.length - 1; i >= 0; i--) {
                if (num[i] == result) {
                    CS.push(n.charAt(i));
                    result--;
                }
            }
            int length = CS.size();
            for (int i = 0; i < length; i++) {
                sb.append(CS.pop());
            }
        }


        System.out.println(sb.toString());
        System.out.println(Arrays.toString(num));
    }
}
