package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_24479 {

    public static void main(String[] args) throws IOException {
        /*
        실패 - 메모리 초과!
        2차원 배열을 이용한 구현은 두 노드가 연결되어있는지 여부를 찾는 덴 빠르지만, n x n 크기의 배열을 가지므로 공간 효율성이 좋지 않다.
        문제에 언급된 정점의 수에 따라, 최대 100,001 x 100,001개의 공간이 필요하다.
        문제에서 요구하는 결과를 구하는 데 있어서도, 리스트로 만든 것이 더 용이하다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nV = Integer.parseInt(st.nextToken());
        int nE = Integer.parseInt(st.nextToken());
        int startV = Integer.parseInt(st.nextToken());

        DfsGraph graph = new DfsGraph(nV);

        // 인접행렬 초기화
        int x, y;
        for (int i = 0; i < nE; i++) {
            st = new StringTokenizer(br.readLine());
            x = Integer.parseInt(st.nextToken());
            y = Integer.parseInt(st.nextToken());
            graph.put(x, y);
        }

        graph.dfs(startV);

        int[] visitOrderArr = graph.getVisitOrderArr();

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= nV; i++) {
            sb.append(visitOrderArr[i]).append("\n");
        }

        System.out.println(sb);
    }

}

class DfsGraph {

    private int nV;
    private int visitOrder;
    private boolean[][] dfsGraph; // 모든 간선의 cost = 1이므로.
    private boolean[] visitedArr;
    private int[] visitOrderArr;

    public DfsGraph(int nV) {
        this.nV = nV;
        visitOrder = 1;
        dfsGraph = new boolean[nV+1][nV+1];
        visitedArr = new boolean[nV+1];
        visitOrderArr = new int[nV+1];
    }

    public void put(int x, int y) { dfsGraph[x][y] = dfsGraph[y][x] = true; }

    public int[] getVisitOrderArr() { return visitOrderArr; }

    public void dfs(int currentVector) {
        visitedArr[currentVector] = true;
        visitOrderArr[currentVector] = visitOrder++;

        for (int i = 1; i <= nV; i++) {
            if (dfsGraph[currentVector][i] == true && visitedArr[i] == false) dfs(i);
        }
    }
}
