package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(bf.readLine());
        int N = Integer.parseInt(st.nextToken());
        int num = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        int max = 0;

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

//        ArrayList<Integer> arrSum = new ArrayList<>();

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N; j++) {
                for (int k = j + 1; k < N; k++) {
                    int e = arr[i] + arr[j] + arr[k];
                    if(e >= max && e <= num){
                        max = e;
                    }
                }
            }
        }
        System.out.println(max);
//
//        int result = arrSum.stream().filter(c -> c <= num).mapToInt(c ->c).max().getAsInt();
//        System.out.println(result);

    }
}

