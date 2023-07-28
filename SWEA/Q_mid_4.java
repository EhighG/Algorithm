package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_mid_4 {

    static int a = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            a++;
            String res = solve(br);
            sb.append("#" + (t+1) + " " + res + "\n");
        }
        System.out.println(sb);
    }

    private static String solve(BufferedReader br) throws IOException {
//        br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[][] arr = new int[9][9];

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 체크. 가로, 세로, 칸
        int[] horCnt;
        int[] verCnt;
        // 가로, 세로
        for (int i = 0; i < 9; i++) {
            horCnt = new int[10];
            verCnt = new int[10];
            for (int j = 0; j < 9; j++) {
                int horNum = arr[i][j];
                int verNum = arr[j][i];
                if (horCnt[horNum]++ > 0) return "0";
                if (verCnt[verNum]++ > 0) return "0";
            }
        }
        // 칸
        int[] start = {0,0};
        for (int i=0; i < 9; i++) { // 전체
            int[] cnt = new int[10];
            int[] cur = {start[0], start[1]};
            for (int j = 0; j < 9; j++) { // sub 칸

                int num = arr[cur[0]][cur[1]];
                if (cnt[num]++ > 0) return "0";

                // last
                if (j == 2 || j == 5) {
                    cur[0]++;
                    cur[1] = start[1];
                } else cur[1]++;
            }

            // last
            if (i == 2 || i == 5) {
                start[0] += 3;
                start[1] = 0;
            } else {
                start[1] += 3;
            }
        }
        return "1";
    }
}
