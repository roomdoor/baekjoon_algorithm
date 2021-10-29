package Queuep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class P5430 {

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(bf.readLine());

        for (int i = 0; i < testCase; i++) {

            String answer = "";
            String method = bf.readLine();
            boolean isChecked = true;
            int n = Integer.parseInt(bf.readLine());

            StringBuilder arrNum = new StringBuilder(bf.readLine());
            arrNum.deleteCharAt(0);
            arrNum.deleteCharAt(arrNum.length() - 1);

            String realArrNum = arrNum.toString();
            String[] number = realArrNum.split(",");
            Deque<String> deque = new LinkedList<>();
            for (int j = 0; j < n; j++) {
                deque.offerLast(number[j]);
            }


            for (int j = 0; j < method.length(); j++) {
                switch (method.charAt(j)) {
                    case 'R':
                        if (isChecked) isChecked = false;
                        else isChecked = true;
                        break;

                    case 'D':
                        if (deque.isEmpty()) {
                            answer = "error";
                            break;
                        } else if (isChecked) deque.pollFirst();
                        else deque.pollLast();
                        break;
                }
            }

            if (answer.equals("error")) sb.append(answer);
            else if (isChecked) {
                sb.append("[");
                for (int j = 0; !deque.isEmpty(); j++) {
                    if (deque.size() != 1) sb.append(deque.pollFirst()).append(",");
                    else sb.append(deque.pollFirst());
                }
                sb.append("]");
            } else {
                sb.append("[");
                for (int j = 0; !deque.isEmpty(); j++) {
                    if (deque.size() != 1) sb.append(deque.pollLast()).append(",");
                    else sb.append(deque.pollLast());
                }
                sb.append("]");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
