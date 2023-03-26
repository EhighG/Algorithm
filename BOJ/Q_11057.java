package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11057 {

    static int[][] dp;
    static int mod = 10007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp = new int[n+2][10]; // n+1 -> n+2
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        System.out.println(findNum(n));
    }

    private static int findNum(int n) {
        for (int length = 2; length < n + 2; length++) { // n+1 -> n+2
            for (int i = 0; i < 10; i++) {
                for (int j = i; j < 10; j++) {
                    dp[length][i] += dp[length-1][j] % mod;
                }
            }
        }
//        int sum = 0;
//        for (int i = 0; i < 10; i++) {
//            sum += dp[n][i];
//        }
//        return sum % mod;
        return dp[n+1][0] % mod; // 여기선 큰 차이는 없겠지만, dp[n+1][0] = sum(dp[n][0~9]) 를 활용할 수도 있다.
    }
}
