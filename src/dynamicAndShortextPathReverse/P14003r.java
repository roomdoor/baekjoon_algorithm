package dynamicAndShortextPathReverse;

import java.io.*;
import java.util.*;

public class P14003r {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        list.add(Integer.MIN_VALUE);

        int[] arr = new int[N]; // 수열 저장
        int[] tmp = new int[N]; // 수열 위치 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        // 이분 탐색을 이용한 LIS 구하기
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            int num = arr[i];
            int start = 1;
            int end = list.size() - 1;

            if(num > list.get(list.size() - 1)){
                list.add(num);
                tmp[i] = list.size() - 1;
            }else{
                while(start < end){
                    int mid = (start + end) / 2;

                    if(list.get(mid) >= num) end = mid;
                    else start = mid + 1;
                }
                list.set(end, num);
                tmp[i] = end;
            }
        }

        sb.append(list.size() - 1 + "\n");
        Stack<Integer> stack = new Stack<>();

        int idx = list.size() - 1;

        for(int i = N - 1; i >= 0; i--) {
            if(tmp[i] == idx){
                idx--;
                stack.push(arr[i]);
            }
        }

        while(!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(Arrays.toString(tmp));

        bw.write(sb.toString());
        bw.flush();
        br.close();
        bw.close();
    }
}