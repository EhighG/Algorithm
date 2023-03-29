package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2156 {

    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cups = new int[n+1];
        dp = new int[n+1];

        for (int i = 1; i < cups.length; i++) {
            cups[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = cups[1];
        if (n == 1) {
            System.out.println(cups[1]);
            return;
        }
        dp[2] = cups[2] + cups[1];

        System.out.println(findAmount(cups));
    }

    private static int findAmount(int[] cups) {
        for (int i = 3; i < cups.length; i++) {
            dp[i] = Math.max(dp[i-3]+cups[i-1]+cups[i], Math.max(dp[i-2]+cups[i], dp[i-1]));
        }
        return dp[dp.length-1];
    }
}
