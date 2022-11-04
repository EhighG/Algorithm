package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_2178 {
    static int n, m;
    static int[][] map;
    static boolean[][] visited;
    static int[][] moves = {{-1,0},{1,0},{0,-1},{0,1}};

    static int[][][] prePos; // 직전 좌표를 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        prePos = new int[n][m][2];


        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        bfs(); // prePos 완성됨.

        int[] current = {n-1, m-1};
        int dist = 1; // 출발, 도착 칸 수도 포함이므로
        while (!(current[0] == 0 && current[1] == 0)) {
            current = prePos[current[0]][current[1]];
            dist++;
        }

        System.out.println(dist);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<int[]>();
        visited[0][0] = true;
        queue.offer(new int[]{0,0});

        int[] current;
        while (!queue.isEmpty()) {
            current = queue.poll();

            int newR, newC;
            for (int i = 0; i < 4; i++) {
                newR = current[0] + moves[i][0];
                newC = current[1] + moves[i][1];

                if ((0 <= newR && newR < n) && (0 <= newC && newC < m)) {
                    if (map[newR][newC] == 1 & !visited[newR][newC]) {
                        visited[newR][newC] = true;
                        queue.offer(new int[]{newR, newC});
                        prePos[newR][newC] = new int[]{current[0], current[1]}; // 얕은 복사 주의.
                    }
                }
            }
        }
    }
}
