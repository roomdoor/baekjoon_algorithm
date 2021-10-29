package stringArray;

//문제
//        알파벳 대소문자로 된 단어가 주어지면, 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 단, 대문자와 소문자를 구분하지 않는다.
//
//        입력
//        첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
//
//        출력
//        첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.

import java.util.Scanner;

public class P1157 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String S = sc.next();
        int[] alphabet = new int[26];
        int max = -1;
        char num = 0;

        for (int i = 0; i < S.length(); i++) {
            int alp = (int) S.charAt(i);
            if (alp < 97) {
                alphabet[alp - 65]++;
            } else alphabet[alp - 97]++;
        }

        //String s = sc.next().toLowerCase(); 모든 문자열 소문자로 바꾸워 주는 것

        for (int i = 0; i < 26; i++) {
            if (alphabet[i] > max) {
                max = alphabet[i];
                num = (char) (i + 65);
            }
        }

        for (int i = num - 64; i < 26; i++) {
            if (alphabet[i] == max) {
                num = 63;
                break;
            }
        }
        System.out.println(num);
    }
}

