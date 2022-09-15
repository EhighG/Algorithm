package BOJ;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_24444_fail_timeOver {
    static ArrayList<SortedSet<Integer>> bfsGraph;
    static int visitOrder = 1;
    static int[] visitOrderArr;
    static boolean[] visitedArr;

    static ArrayList<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nV = Integer.parseInt(st.nextToken());
        int nE = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());

        bfsGraph = new ArrayList(nV+1);
        visitOrderArr = new int[nV+1];
        visitedArr = new boolean[nV+1];
        queue = new ArrayList<Integer>(nE);

        for (int i = 0; i < nV; i++) {
            bfsGraph.add(new TreeSet<Integer>());
        }
        // 간선 정보 입력
        int x, y;
        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            bfsGraph.get(x).add(y);
            bfsGraph.get(y).add(x);
        }

        queue.add(startV);
        bfs(startV);

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nV; i++) {
            sb.append(visitOrderArr[i]).append("\n");
        }

        System.out.println(sb);



    }
    static void bfs(int currentV) {
        visitedArr[currentV] = true;
        visitOrderArr[currentV] = visitOrder++;
        queue.remove(0);
        queue.addAll(bfsGraph.get(currentV)); // 오름차순 정렬된 상태로 addAll


        while (visitedArr[queue.get(0)]) {
            queue.remove(0);
            if (queue.isEmpty()) return;
        }

        bfs(queue.get(0));

    }
}