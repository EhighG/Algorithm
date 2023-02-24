package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Q_24479_Copy {

    static int visitOrder = 1; // 방문 순서 저장에 사용됨.
    static int nV;
    static int[] visitOrderArr; // 방문 순서 저장
    static boolean[] visitedArr; // 방문 여부 저장
    static ArrayList<Integer>[] dfsGraph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        nV = parseInt(st.nextToken());
        int nE = parseInt(st.nextToken());
        int startV = parseInt(st.nextToken());

        visitOrderArr = new int[nV+1];
        visitedArr = new boolean[nV+1];
        dfsGraph = new ArrayList[nV+1];

        for (int i = 0; i <= nV; i++) {
            dfsGraph[i] = new ArrayList<>();
        }

        // 인접 노드 정보 저장
        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            int x = parseInt(st.nextToken());
            int y = parseInt(st.nextToken());

            dfsGraph[x].add(y);
            dfsGraph[y].add(x);
        }

        // 인접 노드가 순서대로 주어진다는 보장이 없다.
        for (int i = 0; i < nV; i++) {
            Collections.sort(dfsGraph[i]);
        }

        dfs(startV);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nV; i++) {
            sb.append(visitOrderArr[i]).append("\n");
        }

        System.out.println(sb.toString());

    }

    // 재귀 방식
    static void dfs(int curVector) {
        // 방문처리
        visitOrderArr[curVector] = visitOrder++;
        visitedArr[curVector] = true;

        for (int i = 0; i < dfsGraph[curVector].size(); i++) {
            int nextVector = dfsGraph[curVector].get(i);
            if (!visitedArr[nextVector]) dfs(nextVector); // 인접 노드 중, 방문하지 않은 노드를 방문
        }
    }
}
