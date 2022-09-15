package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_24444_success {

    static boolean[] visited;
    static LinkedList<Integer>[] adjList;
    static int[] visitOrderArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 초기화
        int nV, nE, startV;
        nV = Integer.parseInt(st.nextToken());
        nE = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(st.nextToken());

        visited = new boolean[nV + 1];
        visitOrderArr = new int[nV + 1];
        adjList = new LinkedList[nV + 1];
        for (int i = 1; i <= nV; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            adjList[x].add(y);
            adjList[y].add(x);
        }

        for (int i = 1; i <= nV; i++) Collections.sort(adjList[i]);

        bfs(startV);

        for (int i = 1; i <= nV; i++) {
            sb.append(visitOrderArr[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int currentVector) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int visitOrder = 1;
        visited[currentVector] = true;
        queue.add(currentVector);

        while (!queue.isEmpty()) {
            currentVector = queue.poll();
            visitOrderArr[currentVector] = visitOrder++;
            for (int adjVector : adjList[currentVector]) {
                if (!visited[adjVector]) {
                    visited[adjVector] = true;
                    queue.add(adjVector);
                }
            }
        }
    }
}
