package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11726 {
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        /*
        num(2xn) = num(2x(n-1)) + num(2x(n-2))
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        if (x <= 2) {
            System.out.println(x);
            return;
        }

        dp = new Integer[x+1];
        dp[1] = 1;
        dp[2] = 2;

        System.out.println(doTiling(x));

    }

    // Top-down
//    private static int doTiling(int x) {
//        if (x <= 2) return dp[x];
//        if (dp[x] == null) return dp[x] = (doTiling(x-1) + doTiling(x-2)) % 10007; // 이미 방문한 숫자일 때
//
//        return dp[x];
//    }

    // Bottom-up
    private static int doTiling(int x) {
        for (int i = 3; i <= x; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        return dp[x];
    }
}
