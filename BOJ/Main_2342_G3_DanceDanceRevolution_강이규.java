package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2342_G3_DanceDanceRevolution_강이규 {

    static int N;
    static int[] cmd;
    static int[][][] dp;
    static int[][] minInfo;

    static int[][] width = {
            {1, 2, 2, 2, 2},
            {0, 1, 3, 4, 3},
            {0, 3, 1, 3, 4},
            {0, 4, 3, 1, 3},
            {0, 3, 4, 3, 1}
    };

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(recur(0, 0, 0));
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        N = (line.length() - 1) / 2;
        cmd = new int[N];
        dp = new int[N][5][5];
        minInfo = new int[N][3];

        for (int i = 0; i < N; i++) {
            cmd[i] = line.charAt(i*2) - '0';
        }

    }

    private static int recur(int i, int l, int r) {
        if (i == N)
            return 0;
        if (dp[i][l][r] != 0)
            return dp[i][l][r];

        int cur = cmd[i];
        int min = Integer.MAX_VALUE;

        // 이미 있는 칸이라면
        if (l == cur || r == cur) {
            min = recur(i+1, l, r) + 1;
            minInfo[i] = new int[]{min, l, r};
        } else {
            // 왼발
            min = Math.min(min, recur(i+1, cur, r) + width[l][cur]);
            // 오른발
            min = Math.min(min, recur(i+1, l, cur) + width[r][cur]);
        }

        return dp[i][l][r] = min;
    }
}
