package stringArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2941 {
    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();

        int length = str.length();
        int count = 0;

        for (int i = 0; i < length; i++) {

            char ch = str.charAt(i);

            if (ch == 'c' && i < length - 1) {
                if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') {
                    i++;
                }
            }

            else if (ch == 'd') {
                if (i < length -1 && str.charAt(i + 1) == '-') {
                    i++;
                }
                else if (i < length - 2 && str.charAt(i +1) == 'z'){
                    if (str.charAt(i + 2) == '='){
                        i += 2;
                    }
                }
            }

            else if ((ch == 'l' || ch == 'n') && i < length - 1) {
                if (str.charAt(i + 1) == 'j') {
                    i++;
                }
            }

            else if ((ch == 's' || ch == 'z') && i < length - 1) {
                if (str.charAt(i + 1) == '=') {
                    i++;
                }
            }
            count++;
        }
        System.out.println(count);
    }
}