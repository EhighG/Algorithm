package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_9465 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            // 입력받기
            int n = Integer.parseInt(br.readLine());
            int[][] stickers = new int[2][n+1];
            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j < n + 1; j++) {
                    stickers[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            // 실행
            dp = new int[2][n+1];
            dp[0][1] = stickers[0][1];
            dp[1][1] = stickers[1][1];

            System.out.println(getMaxValue(n, stickers));
        }
    }

    private static int getMaxValue(int n, int[][] stickers) {
        for (int x = 2; x < n + 1; x++) {
            for (int y = 0; y < 2; y++) {
                dp[y][x] = stickers[y][x] + Math.max(Math.max(dp[0][x-2], dp[1][x-2]), dp[1-y][x-1]);
            }
        }
        return Math.max(dp[0][n], dp[1][n]);
    }
}
