package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q_mid_3 {

    public static void main(String[] args) throws IOException {
        // 배열 우측 회전
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int[][][] arrs = new int[4][n][n];
            arrs[0] = arr;

            for (int i = 1; i < 4; i++) {
                arrs[i] = rotateRight(arrs[i-1]);
            }

            // 출력
            String[] lines = new String[n];
            for (int i = 0; i < n; i++) {
                lines[i] = "";
            }

            for (int r = 0; r < n; r++) {
                for (int i = 1; i < 4; i++) {
                    for (int c = 0; c < n; c++) {
                        lines[r] += arrs[i][r][c];
                    }
                    lines[r] += " ";
                }
            }

            sb.append("#" + (t+1) + "\n");
            for (String line : lines) {
                sb.append(line + "\n");
            }
        }
        System.out.println(sb);
    }

    private static int[][] rotateRight(int[][] arr) {
        int n = arr.length;
        int[][] res = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res[j][n-1-i] = arr[i][j];
            }
        }
        return res;
    }
}
