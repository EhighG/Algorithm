package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1697 {
    static HashMap<Integer, Integer> prePos = new HashMap<Integer, Integer>();
    static boolean[] visited = new boolean[100001];
    public static void main(String[] args) throws IOException {
        /*
        복습 : bfs는 같은 depth의 모든 노드들을 방문한 후 다음 depth로 넘어가므로,
        특정 노드를 처음 방문했을때의 거리 = 그 노드까지의 최소 거리이다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        bfs(start, end); // prePos 완성됨.

        int minSec = 0;
        int current = end;
        while(current != start) {
            current = prePos.get(current);
            minSec++;
        }

        System.out.println(minSec);
    }

    public static void bfs(int start, int end) {
        Queue<Integer> queue = new LinkedList<Integer>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int curPos = queue.poll();
            for (int moveOption : new int[]{curPos+1, curPos-1, curPos*2}) {
                if (0 <= moveOption && moveOption <= 100000 && !visited[moveOption]) { // 범위 안에 들고, 방문 안 했으면
                    visited[moveOption] = true;
                    prePos.put(moveOption, curPos);
                    if (moveOption == end) return;
                    queue.offer(moveOption);
                }
            }
        }
    }
}
