package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_24445 {

    static LinkedList<Integer>[] adjList;
    static int[] visitOrderArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nV, nE, startV;
        nV = Integer.parseInt(st.nextToken());
        nE = Integer.parseInt(st.nextToken());
        startV = Integer.parseInt(st.nextToken());

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

        for (int i = 1; i <= nV; i++) Collections.sort(adjList[i], Comparator.reverseOrder());

        bfs(startV);

        for (int i = 1; i <= nV; i++) {
            sb.append(visitOrderArr[i]).append("\n");
        }

        System.out.println(sb);
    }

    static void bfs(int currentVector) {
        Queue<Integer> queue = new LinkedList<Integer>();
        int visitOrder = 1;
        visitOrderArr[currentVector] = visitOrder++;
        queue.add(currentVector);

        while (!queue.isEmpty()) {
            currentVector = queue.poll();

            int size = adjList[currentVector].size()-1;
            for (int adjVector : adjList[currentVector]) {
                if (visitOrderArr[adjVector] == 0) {
                    visitOrderArr[adjVector] = visitOrder++;
                    queue.add(adjVector);
                }
            }
        }
    }
}
