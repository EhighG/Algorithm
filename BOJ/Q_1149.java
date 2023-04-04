package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_1149 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        int[][] rgbCosts = new int[n+1][3];

        for (int i = 1; i < n + 1; i++) {
            // 1) 더 느림
//            rgbCosts[i] = Arrays.stream(br.readLine().split(" "))
//                    .mapToInt(Integer::parseInt)
//                    .toArray();
            // 2)
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                rgbCosts[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp = new int[n+1][3];
        dp[1] = rgbCosts[1]; // 얕은 복사 / dp[1]은 읽기 전용으로 써야 함에 유의하기

        System.out.println(solve(rgbCosts));
    }

    private static int solve(int[][] costs) {
        for (int i = 2; i < dp.length; i++) { // 집들의 idx
            for (int j = 0; j < 3; j++) { // 현재 집의 costs
                int min = 1000001;
                for (int k = 0; k < 3; k++) { // 이전 집의 costs
                    int cost = dp[i-1][k];
                    min = (j != k && cost < min) ? cost : min;
                }
                dp[i][j] = min + costs[i][j];
            }
//            int preR = dp[i-1][0], preG = dp[i-1][1], preB = dp[i-1][2];
//            dp[i][0] = Math.min(preG, preB) + costs[i][0];
//            dp[i][1] = Math.min(preR, preB) + costs[i][1];
//            dp[i][2] = Math.min(preR, preG) + costs[i][2];
        }
        int n = dp.length-1;
        return Math.min(Math.min(dp[n][0], dp[n][1]), dp[n][2]);
    }
}
