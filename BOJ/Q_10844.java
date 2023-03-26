package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10844 {
    static long[][] dp;
    static long mod = 1_000_000_000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new long[11][n+1];

        for (int i = 1; i <= 9; i++) {
            dp[i][1] = 1;
        }

        System.out.println(findNum(n));
    }
    private static long findNum(int n) {
        for (int depth = 2; depth <= n; depth++) {
            dp[0][depth] = dp[1][depth-1];
            for (int x = 1; x <= 9; x++) {
                dp[x][depth] = (dp[x-1][depth-1] + dp[x+1][depth-1]) % mod;
                // x가 9일 때, dp[10][depth-1] 은 (초기화하지 않았기에) 기본값인 0이 되므로, 별도의 처리가 필요 없음
            }
        }

        long sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum += dp[i][n] % mod;
        }
        return sum % mod;
    }

}
