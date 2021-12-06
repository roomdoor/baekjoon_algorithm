package dynamicAndShortextPathReverse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Objects;
import java.util.Stack;

public class P9252r {
    public static Integer[][] arrLCS;
    public static int[] trace;
    public static String[] nArr;
    public static String[] mArr;
    public static String[] stringCS;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        
        String n = bf.readLine();
        nArr = new String[n.length()];
        for (int i = 0; i < n.length(); i++) {
            nArr[i] = String.valueOf(n.charAt(i));
        }
        
        String m = bf.readLine();
        mArr = new String[m.length()];
        for (int i = 0; i < m.length(); i++) {
            mArr[i] = String.valueOf(m.charAt(i));
        }

        stringCS = new String[n.length()];
        trace = new int[n.length()];
        arrLCS = new Integer[n.length()][m.length()];
        StringBuilder sb = new StringBuilder();

        int result = LCS(n.length() - 1, m.length() - 1);

        sb.append(result).append("\n");

        for (int i = 1; i < result +1; i++) {
            sb.append(stringCS[i]);
        }
        sb.append("\n");

        Stack<Character> CS = new Stack<>();
        for (int i = trace.length - 1; i >= 0; i--) {
            if (trace[i] == result) {
                CS.push(n.charAt(i));
                result--;
            }
        }

        int length = CS.size();

        for (int i = 0; i < length; i++) {
            sb.append(CS.pop());
        }
        System.out.println(Arrays.toString(trace));
        System.out.println(Arrays.deepToString(arrLCS));
        System.out.println(sb.toString());

    }

    public static int LCS(int x, int y) {
        if (x < 0 || y < 0) {
            return 0;
        }

        if (arrLCS[x][y] == null) {
            arrLCS[x][y] = 0;
            if (Objects.equals(nArr[x], mArr[y])) {
                arrLCS[x][y] = LCS(x - 1, y - 1) + 1;
                trace[x] = arrLCS[x][y];
                if (stringCS[x] == null) {
                    stringCS[x] = nArr[x];
                }
            } else {
                arrLCS[x][y] = Math.max(LCS(x - 1, y), LCS(x, y - 1));
            }
        }
        return arrLCS[x][y];
    }
}
