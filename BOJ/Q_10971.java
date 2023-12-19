package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_10971 {

    static int N;
    static int[][] adjMatrix;
    static boolean[] visited;
    static long minSum = Long.MAX_VALUE;
    static int start;
    static int[] order;
    static int orderCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        adjMatrix = new int[N][N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            order = new int[N];
            orderCnt = 0;
            start = i;
            visited[start] = true;
            order[orderCnt++] = start;
            recur(i, 0, 0);
        }
        System.out.println(minSum);
    }

    private static void recur(int cur, long sum, int cnt) {
        if (cnt == N - 1) {
            int curCost = adjMatrix[cur][start];
            if (curCost == 0) return;
            if (sum + curCost < minSum) {
                minSum = Math.min(minSum, sum + curCost);
                System.out.println(Arrays.toString(order));
            }
            return;
        }

        for (int i = 0; i < N; i++) {
            if (visited[i]) continue;
            if (adjMatrix[cur][i] == 0) continue;

            visited[i] = true;
            order[orderCnt++] = i;
            recur(i, sum + adjMatrix[cur][i], cnt + 1);
            visited[i] = false;
            order[--orderCnt] = 0;
        }
    }
}