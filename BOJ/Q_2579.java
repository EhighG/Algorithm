package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2579 {

    static int[][] dp;
    static int[] dp2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        final int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n+1];
        int[] stairs2 = new int[n+2];

        for (int i = 1; i <= n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        System.arraycopy(stairs, 0, stairs2, 0, stairs.length);

        if (n == 1) {
            System.out.println(stairs[1]);
            return;
        }

        dp = new int[n+1][2];
        dp[1][0] = stairs[1];
        dp[2][0] = stairs[2];
        dp[2][1] = stairs[1] + stairs[2];

        System.out.println(solve(stairs));

        dp2 = new int[n+2];
        for (int i = 1; i <= 3; i++) {
            dp2[i] = stairs[i];
        }

        System.out.println(solve2(stairs2));
    }

    private static int solve(int[] stairs) {
        int n = stairs.length;
        for (int i = 3; i < n; i++) {
            dp[i][0] = Math.max(dp[i-2][0], dp[i-2][1]) + stairs[i];
            dp[i][1] = dp[i-1][0] + stairs[i];
        }
        return Math.max(dp[n-1][0], dp[n-1][1]);
    }

    private static int solve2(int[] stairs) { // or min(dp2[n-1], dp2[n-2])
        for (int i = 4; i < dp2.length; i++) {
            dp2[i] = Math.min(dp2[i-2], dp2[i-3]) + stairs[i];
        }
        int sum = 0;
        return sum - dp2[dp2.length-1];
    }

}
