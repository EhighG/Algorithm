package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_5643 {

    static int N;
    static int M;
    static int[] inDegree;
    static int[] outDegree;
    static List<Integer>[] adjList;
    static List<Integer>[] adjListReverse;
    static Set<Integer>[] identified; // 여러 부모 노드 간 공통부분을 제외해야 하므로
    static Set<Integer>[] identifiedReverse;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());

        for (int t = 1; t <= T; t++) {

            // 입력받기
            N = Integer.parseInt(br.readLine().trim());
            M = Integer.parseInt(br.readLine().trim());

            // 초기화
            inDegree = new int[N];
            outDegree = new int[N];
            adjList = new ArrayList[N];
            adjListReverse = new ArrayList[N];
            identified = new HashSet[N];
            identifiedReverse = new HashSet[N];

            for (int i = 0; i < N; i++) {
                adjList[i] = new ArrayList<>();
                adjListReverse[i] = new ArrayList<>();
                identified[i] = new HashSet<>();
                identifiedReverse[i] = new HashSet<>();
                identified[i].add(i);
                identifiedReverse[i].add(i);
            }

            // 간선 입력
            for (int i = 0; i < M; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int shorter = Integer.parseInt(st.nextToken()) - 1;
                int taller = Integer.parseInt(st.nextToken()) - 1;

                adjList[shorter].add(taller);
                inDegree[taller]++;
                outDegree[shorter]++;
                adjListReverse[taller].add(shorter);
            }
            // 로직
            topologySort(false);
            topologySort(true);

            // 결과값 세기
            int result = 0;
            for (int i = 0; i < N; i++) {
                if (identified[i].size() + identifiedReverse[i].size() - 1 == N) // 모든 노드와의 관계가 식별됐으면
                    result++;
            }
            sb.append("#").append(t).append(" ").append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void topologySort(boolean reverse) {
        int[] srcDegree = reverse ? outDegree : inDegree;
        List<Integer>[] srcList = reverse ? adjListReverse : adjList;
        Set<Integer>[] srcIdentified = reverse ? identifiedReverse : identified;

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            if (srcDegree[i] == 0) {
                q.offer(i);
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int adj : srcList[cur]) {
                srcIdentified[adj].addAll(srcIdentified[cur]);
                if (--srcDegree[adj] == 0) q.offer(adj);
            }
        }
    }
}
