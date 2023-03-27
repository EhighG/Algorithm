package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2193 {
    static long [][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new long[n+1][2];
        dp[1][1] = 1;

        System.out.println(findNum(n));
    }

    private static long findNum(int n) {
        for (int L = 2, l = L-1; L < n+1; L++, l++) {
            dp[L][0] = (dp[L][1] = dp[l][0]) + dp[l][1];
        }
        return dp[n][0] + dp[n][1];
    }
}
