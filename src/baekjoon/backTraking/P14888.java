package backTraking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14888 {

    public static long max = -1000000000;
    public static long min = +1000000000;
    public static int[] number;
    public static int[] operator;

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bf.readLine());
        number = new int[n];
        operator = new int[4];

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        solveMaxMin(number[0], 1);
        System.out.println(max + "\n" + min);
    }

    public static void solveMaxMin(int num, int idx) {

        if (idx == number.length) {
            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {

                    case 0 : solveMaxMin(num + number[idx], idx + 1); break;

                    case 1 :  solveMaxMin(num - number[idx], idx + 1); break;

                    case 2 : solveMaxMin(num * number[idx], idx + 1); break;

                    case 3 : solveMaxMin(num / number[idx], idx + 1); break;
                }
                operator[i]++;
            }
        }
    }
}
