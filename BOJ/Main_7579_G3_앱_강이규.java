package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_7579_G3_앱_강이규 {

    static int N, M;
    static App[] apps;
    static int[][] dp;
    static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        init();
        recur();
        System.out.println(res);
    }

    private static void recur() {
        for (int j = 0; j < 10001; j++) {
            for (int i = 1; i <= N; i++) {
                App cur = apps[i];
                dp[i][j] = dp[i - 1][j];

                if (cur.c > j) continue;
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cur.c] + cur.m);
                if (dp[i][j] >= M) {
                    res = j;
                    return;
                }
            }
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        apps = new App[N+1];
        dp = new int[N+1][10001];

        st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int m = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st2.nextToken());
            apps[i] = new App(m, c);
        }
    }

    static class App {
        int m, c;
        App(int m, int c) {
            this.m = m;
            this.c = c;
        }
    }
}
