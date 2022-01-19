package unionFInd;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class P4195 {
    public static int[] friendMap;
    public static int[] networkNum;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(bf.readLine());

        for (int i = 0; i < testCase; i++) {
            int F = Integer.parseInt(bf.readLine());
            friendMap = new int[F * 2];
            networkNum = new int[F * 2];

            for (int j = 0; j < F * 2; j++) {
                friendMap[j] = j;
                networkNum[j] = 1;
            }

            Map<String, Integer> personIdx = new HashMap<>();
            int idx = 0;
            for (int j = 0; j < F; j++) {
                StringTokenizer st = new StringTokenizer(bf.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                idx = mapPut(a, b, idx, personIdx);
                sb.append(union(personIdx.get(a), personIdx.get(b))).append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    public static int find(int a) {
        if (friendMap[a] == a) {
            return a;
        } else {
            return friendMap[a] = find(friendMap[a]);
        }
    }

    public static int union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a < b) {
            friendMap[b] = a;
            networkNum[a] += networkNum[b];
            networkNum[b] = 1;
            return networkNum[a];
        } else if (b < a) {
            friendMap[a] = b;
            networkNum[b] += networkNum[a];
            networkNum[a] = 1;
            return networkNum[b];
        }else
            return networkNum[a];
    }

    public static int mapPut(String a, String b, int idx, Map<String, Integer> map) {
        if (!map.containsKey(a)) {
            map.put(a, idx);
            idx++;
        }
        if (!map.containsKey(b)) {
            map.put(b, idx);
            idx++;
        }
        return idx;
    }
}
