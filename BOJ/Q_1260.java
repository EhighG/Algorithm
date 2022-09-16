package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1260 {
    static boolean[] visited;
    static LinkedList<Integer>[] adjList;
    static StringBuilder sb = new StringBuilder();
    // arrayList = 

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nV = Integer.parseInt(st.nextToken());
        int nE = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());

        visited = new boolean[nV + 1];
        adjList = new LinkedList[nV + 1];

        for (int i = 1; i <= nV; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        while (nE --> 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList[x].add(y);
            adjList[y].add(x);
        }

        for (int i = 1; i <= nV; i++) Collections.sort(adjList[i]);

        dfs(startV);

        visited = new boolean[nV + 1]; // garbage collection : 해당 데이터를 가리키는 참조가 하나도 없어지면 자동으로
        sb.append("\n");

        bfs(startV);

        System.out.println(sb);


    }
    static void dfs(int currentV) {
        visited[currentV] = true;
        sb.append(currentV).append(" ");

        for (int adjVector : adjList[currentV]) {
            if (!visited[adjVector]) dfs(adjVector);
        }
    }

    static void bfs(int startV) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[startV] = true;
        sb.append(startV).append(" ");
        queue.add(startV);

        while (!queue.isEmpty()) {
            int currentVector = queue.poll();
            visited[currentVector] = true;
            for (int adjVector : adjList[currentVector]) {
                if (!visited[adjVector]) {
                    visited[adjVector] = true;
                    sb.append(adjVector).append(" ");
                    queue.add(adjVector);
                }
            }
        }
    }
}
