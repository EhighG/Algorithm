package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2606 {

    static LinkedList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int nV = Integer.parseInt(br.readLine());
        int nE = Integer.parseInt(br.readLine());
        graph = new LinkedList[nV + 1];
        visited = new boolean[nV + 1];

        for (int i = 1; i <= nV; i++) {
            graph[i] = new LinkedList<Integer>();
        }
        while (nE --> 0) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x].add(y);
            graph[y].add(x);
        }

        bfs();
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<Integer>();
        int cnt = 0;
        int currentVector = 1;
        visited[currentVector] = true;
        queue.add(currentVector);

        while (!queue.isEmpty()) {
            currentVector = queue.poll();

            for (int adjVector : graph[currentVector]) {
                if (!visited[adjVector]) {
                    visited[adjVector] = true;
                    cnt++;
                    queue.add(adjVector);
                }
            }
        }
        System.out.println(cnt);
    }
}
