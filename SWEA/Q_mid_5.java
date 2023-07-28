package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_mid_5 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int maxSum = 0;
            int maxR = 0, maxC = 0;
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    int curSum = checkCount(i, j, m-1, map);
                    if (curSum > maxSum) {
                        maxSum = curSum;
                    }
                }
            }
            System.out.println("#" + (t+1) + " " + maxSum);
        }
    }

    private static int checkCount(int r, int c, int m, int[][] map) {
        int n = map.length;

        int[][] moves = {{-1, -1}, {-1, 1}, {1,-1}, {1,1}}; // 대각선
        int[][] moves2 = {{-1, 0}, {1, 0}, {0, -1}, {0,1}}; // 상하좌우

        int sum = map[r][c];
        int sum2 = map[r][c];
        // 방향별 체크
        for (int[] move : moves) {
            int curR = r+move[0], curC = c+move[1];
            int power = m;
            while (isValid(curR, curC, n) && power > 0) {
                sum += map[curR][curC];
                curR += move[0];
                curC += move[1];
                power--;
            }
        }
        // 체크 2
        for (int[] move : moves2) {
            int curR = r+move[0], curC = c+move[1];
            int power = m;
            while (isValid(curR, curC, n) && power > 0) {
                sum2 += map[curR][curC];
                curR += move[0];
                curC += move[1];
                power--;
            }
        }
        return Math.max(sum, sum2);
    }

    private static boolean isValid(int r, int c, int n) {
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}
