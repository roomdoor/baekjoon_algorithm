package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P13305 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] distance = new int[n - 1];
        int[] price = new int[n];
        int oil = 0;
        long minPrice = 0;

        StringTokenizer st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {

            if (oil == 0) {

                minPrice += (long) distance[i] * price[i];
                oil += distance[i];

                for (int j = i + 1; price[i] < price[j] && j < n - 1; j++) {
                    minPrice += (long) distance[j] * price[i];
                    oil += distance[j];
                }
            }

            oil -= distance[i];
        }

        System.out.println(minPrice);

    }
}
