package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_24480_practice {
    static int visitOrder = 1;
    static int[] visitOrderArr;
    static boolean[] visitedArr;
    static ArrayList<SortedSet<Integer>> dfsGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nV = Integer.parseInt(st.nextToken());
        int nE = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());

        visitOrderArr = new int[nV+1];
        visitedArr = new boolean[nV+1];
        dfsGraph = new ArrayList<>(nV+1);

        for (int i = 0; i <= nV; i++) {
            dfsGraph.add(new TreeSet<>(Collections.reverseOrder()));
        }


        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            dfsGraph.get(x).add(y);
            dfsGraph.get(y).add(x);
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

        for (int nextVector : dfsGraph.get(currentVector)) {
            if (visitedArr[nextVector] == false) dfs(nextVector);
        }
    }
}
