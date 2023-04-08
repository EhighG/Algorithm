package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1932 {

    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] triangle = new int[n+1][];
        dp = new int[n+1][];

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            triangle[i] = new int[i+1];
            dp[i] = new int[i+1];
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][1] = triangle[1][1];

        System.out.println(solve(triangle));
    }

    private static int solve(int[][] triangle) {
        for (int i = 2; i < triangle.length; i++) {
            int x = i-1;
            // 양 끝
            dp[i][1] = dp[x][1] + triangle[i][1];
            dp[i][i] = dp[x][x] + triangle[i][i];

            // 가운데
            for (int j = 2; j < i; j++) {
                dp[i][j] = Math.max(dp[x][j-1], dp[x][j]) + triangle[i][j];
            }
        }
        return max(dp[dp.length-1]);
    }

    private static int max(int[] arr) {
        int max = -1;
        for (int i : arr) {
            if (i > max) max = i;
        }
        return max;
    }
}
