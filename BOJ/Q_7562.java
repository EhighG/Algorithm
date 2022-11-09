package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Q_7562 {

    static int mapSize;
    static int[][][] prePos;
    static boolean[][] visited;
    static int[][] moves = {{-2,1}, {-1,2}, {1,2}, {2,1}, {2,-1}, {1,-2}, {-1,-2}, {-2,-1}}; // 시계방향으로, 이동 가능한 선택지

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(T --> 0) {
            // 입력받기
            mapSize = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] start = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())}; // 연관 : 타입 추론, var
            st = new StringTokenizer(br.readLine());
            int[] end = new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};

            // 배열 초기화
            prePos = new int[mapSize][mapSize][2];
            visited = new boolean[mapSize][mapSize];

            bfs(start, end); // prePos 완성됨.

            int dist = 0;
            int[] current = {end[0], end[1]};
            while (!(current[0] == start[0] && current[1] == start[1])) { // start에 도착할 때까지
                current = prePos[current[0]][current[1]];
                dist++;
            }
            sb.append(dist).append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int[] start, int[] dest) {
//        Queue<int[]> queue = new LinkedList<>();
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        visited[start[0]][start[1]] = true;
        queue.offer(start);

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();

            for (int i = 0; i < moves.length; i++) {
                int newR = curPos[0] + moves[i][0];
                int newC = curPos[1] + moves[i][1];

                // 범위 안에 들고, 방문 안 했으면
                if ((0 <= newR && newR < mapSize) && (0 <= newC && newC < mapSize) && !visited[newR][newC]) {
                    visited[newR][newC] = true;
                    prePos[newR][newC] = curPos;

                    if (dest[0] == newR && dest[1] == newC) { // 목적지를 방문했다면
                        return;
                    }
                    queue.offer(new int[]{newR,newC});
                }
            }
        }
    }
}
