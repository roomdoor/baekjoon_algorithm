package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class P9252 {
    public static int[][] arr;
    public static String n;
    public static String m;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = bf.readLine();
        m = bf.readLine();
        int nLength = n.length();
        int mLength = m.length();

        arr = new int[nLength + 1][mLength + 1];
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= nLength; i++) {
            for (int j = 1; j <= mLength; j++) {
                if (n.charAt(i - 1) == m.charAt(j - 1)) {
                    arr[i][j] += arr[i - 1][j - 1] + 1;
                } else {
                    arr[i][j] = Math.max(arr[i - 1][j], arr[i][j - 1]);
                }
            }
        }

        int result = arr[nLength][mLength];
        sb.append(result).append("\n");

        Stack<Character> stack = new Stack<>();
        int x = nLength;
        int y = mLength;
        if (result != 0) {
            while (x >= 1 && y >= 1) {
                if (arr[x][y] == arr[x - 1][y]) {
                    x--;
                } else if (arr[x][y] == arr[x][y - 1]) {
                    y--;
                } else {
                    x--;
                    y--;
                    stack.push(n.charAt(x));
                }
            }
            int length = stack.size();
            for (int i = 0; i <length ; i++) {
                sb.append(stack.pop());
            }
        }

        System.out.println(sb.toString());
    }
}