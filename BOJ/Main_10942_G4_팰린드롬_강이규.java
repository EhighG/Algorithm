package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10942_G4_팰린드롬_강이규 {

    static int N, M;
    static int[] arr;
    static int[][] dp;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        init();
        dp();
        printResult();
    }

    private static void printResult() throws IOException {
        StringBuilder sb = new StringBuilder();

        M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(dp[s][e] != -1 ? 1 : 0).append("\n");
        }
        System.out.println(sb);
    }

    private static void dp() {
        for (int i = 1; i <= N; i++) {
            for (int j = i; j <= N; j++) {
                if (i == j) {
                    dp[i][j] = arr[j];
                    continue;
                }
                if (dp[i][j-1] == -1 || Math.abs(arr[j] - dp[i][j-1]) != 1) {
                    dp[i][j] = -1;
                    continue;
                }
                dp[i][j] = arr[j];
            }
        }
    }

    private static void init() throws IOException {
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        dp = new int[N+1][N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
