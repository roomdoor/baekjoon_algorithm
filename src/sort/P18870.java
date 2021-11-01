package sort;

//문제
//        수직선 위에 N개의 좌표 X1, X2, ..., XN이 있다. 이 좌표에 좌표 압축을 적용하려고 한다.
//
//        Xi를 좌표 압축한 결과 X'i의 값은 Xi > Xj를 만족하는 서로 다른 좌표의 개수와 같아야 한다.
//
//        X1, X2, ..., XN에 좌표 압축을 적용한 결과 X'1, X'2, ..., X'N를 출력해보자.
//
//        입력
//        첫째 줄에 N이 주어진다.
//
//        둘째 줄에는 공백 한 칸으로 구분된 X1, X2, ..., XN이 주어진다.
//
//        출력
//        첫째 줄에 X'1, X'2, ..., X'N을 공백 한 칸으로 구분해서 출력한다.
//
//        제한
//        1 ≤ N ≤ 1,000,000
//        -109 ≤ Xi ≤ 109

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class P18870 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int count = 0;



        for (int i = 0; i < n; i++) {
            arr[i] = bf.read();
        }

        int[] temp = arr.clone();
        Arrays.sort(arr);

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if(!hashMap.containsKey(arr[i])){
               hashMap.put(arr[i], count++);
            }
        }

        for (int i = 0; i < n; i++) {
            sb.append(hashMap.get(temp[i])).append(" ");
        }

        System.out.println(sb.toString());


    }
}
