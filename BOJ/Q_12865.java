package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_12865 {

    static int N, K;
    static int[][] input;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        dp();
        System.out.println(dp[N][K]);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        input = new int[N+1][2];
        dp = new int[N+1][K+1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            input[i][0] = w;
            input[i][1] = v;
        }
    }

    private static void dp() {
        for (int i = 1; i <= N; i++) { // 물품
            int w = input[i][0];
            int v = input[i][1];
            for (int j = 1; j <= K; j++) { // 중량
                dp[i][j] = dp[i-1][j]; // 선택 불가능
                if (j - w >= 0) // 선택 가능
                    dp[i][j] = Math.max(dp[i-1][j-w] + v, dp[i][j]);
            }
        }
    }
}
