package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Q_24479 {
    static int visitOrder = 1;

    static int nV;
    static int[] visitOrderArr;
    static boolean[] visitedArr;
    static ArrayList<Integer>[] dfsGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = Integer.parseInt(st.nextToken());
        int nE = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());

        visitOrderArr = new int[nV+1];
        visitedArr = new boolean[nV+1];
        dfsGraph = new ArrayList[nV+1];

        for (int i = 0; i <= nV; i++) {
            dfsGraph[i] = (new ArrayList<Integer>());
        }


        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dfsGraph[x].add(y);
            dfsGraph[y].add(x);
        }

        for (int i = 0; i <= nV; i++) {
            Collections.sort(dfsGraph[i]);
        }

        dfs(startV);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nV ; i++) {
            sb.append(visitOrderArr[i]).append("\n");
        }

        System.out.println(sb);


    }

    static void dfs(int currentVector) {
        visitOrderArr[currentVector] = visitOrder++;
        visitedArr[currentVector] = true;

        for(int nextVector : dfsGraph[currentVector]) { // 모든 노드가 아니라, 간선정보 입력으로 추가된 것들만 탐색하면 됨.
            if (visitedArr[nextVector] == false) dfs(nextVector);
        }
    }
}
