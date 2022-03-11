package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2580 {
    public static int[][] sdoku = new int[9][9];                        // 스도쿠 판떄기
    public static ArrayList<int[]> emptyPoint = new ArrayList<>();      // 빈칸 좌표 저장 배열
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {         // main

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {                                   // 스도쿠 판때기 입력
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 9; j++) {
                sdoku[i][j] = Integer.parseInt(st.nextToken());
                if (sdoku[i][j] == 0) emptyPoint.add(new int[]{i, j});  // 빈칸 좌표 입력
            }
        }
        solveSdoku(0);                                            // 첫번째 빈칸부터 함수 돌림
    }


    public static void solveSdoku(int count) {                          // 스도쿠 푸는 함수

        if (count == emptyPoint.size()) {                               // 재귀 함수 끝, 출력
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(sdoku[i][j]).append(" ");
                }
                if (i != 8) sb.append("\n");
            }
            System.out.println(sb.toString());
            System.exit(0);
        }

        else {                                                        // 재귀 함수

            int row = emptyPoint.get(count)[0];                         // 빈칸 좌표 row 입력
            int col = emptyPoint.get(count)[1];                         // 빈칸 좌표 col 입력

            for (int i = 1; i <= 9; i++) {                              // 1 ~ 9 넣을 수 있는 숫자 경우 검사
                if (isPossible(row, col, i)) {
                    sdoku[row][col] = i;
                    solveSdoku(count + 1);                        // 중복 숫자 아닌 경우 다음 빈칸으로
                    sdoku[row][col] = 0;                                 // 1 ~ 9 모두 맞지 않는 경우 다시 빈칸을 0 으로
                }
            }
        }
    }


    public static boolean isPossible(int row, int col, int value) {     // 빈칸 숫자 중복 유뮤 판단 함수

        for (int i = 0; i < 9; i++) {                                   // 가로 세로 중복 유무 판단
            if (sdoku[row][i] == value) return false;
            if (sdoku[i][col] == value) return false;
        }

        for (int i = 0; i < 3; i++) {                                   // 9칸 내 중복 유무 판단
            for (int j = 0; j < 3; j++) {
                if (sdoku[(row / 3) * 3 + i][(col / 3) * 3 + j] == value)
                    return false;
            }
        }
        return true;                                                    // 모두 통과시 true
    }
}
