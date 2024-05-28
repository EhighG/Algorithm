package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_9466_G3_텀프로젝트_강이규 {

    static int N;
    static int[] arr;
    static Set<Integer> selected;
    static Set<Integer> curSet;
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            init();

            for (int i = 1; i <= N; i++) {
                if (!visited[i]) {
                    curSet = new HashSet<>();
                    dfs(i);
                }
            }
            sb.append(N - selected.size()).append("\n");
        }
        System.out.print(sb);
    }

    private static int dfs(int cur) {
        curSet.add(cur);
        visited[cur] = true;
        int next = arr[cur];
        // 이미 다른 팀인 경우 - cur가 그 팀이지만 포함되지 않은 경우는 없음
        if (selected.contains(next)) return -1;
        // 혼자 팀인 경우
        if (next == cur) {
            visited[next] = true;
            selected.add(next);
            return -1;
        }
        // 사이클 발생한 경우
        if (curSet.contains(next)) {
            selected.add(cur);
            return next;
        }
        if (visited[next]) return -1;
        int res = dfs(next);
        if (res != -1) {
            selected.add(cur);
            return res != cur ? res : -1;
        }
        return -1;
    }

    private static void init() throws IOException {
        N = Integer.parseInt(br.readLine());
        selected = new HashSet<>();

        arr = new int[N+1];
        visited = new boolean[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }
}
