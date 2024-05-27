package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2533_G3_사회망서비스_강이규 {

    static int N;
    static List<Integer>[] adjList;
    static boolean[] visited;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        init();
        if (N == 2) {
            System.out.println(1);
            return;
        }
        for (int i = 1; i <= N; i++) {
            if (adjList[i].size() > 1) {
                dfs(i);
                System.out.println(Math.min(dp[i][0], dp[i][1]));
                break;
            }
        }
    }

    private static void dfs(int cur) {
        visited[cur] = true;
        for (int adj: adjList[cur]) {
            if (visited[adj]) {
                continue;
            }
            dfs(adj);
            dp[cur][0] += dp[adj][1];
            dp[cur][1] += Math.min(dp[adj][0], dp[adj][1]);
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dp = new int[N+1][2];
        adjList = new ArrayList[N+1];
        visited = new boolean[N+1];
        for (int i = 1; i <= N; i++) {
            adjList[i] = new ArrayList<>();
            dp[i][1] = 1;
        }

        StringTokenizer st;
        for (int i = 1; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjList[a].add(b);
            adjList[b].add(a);
        }
    }
}
