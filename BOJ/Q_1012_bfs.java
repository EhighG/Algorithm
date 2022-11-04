package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1012_bfs {

    static int width, height;
    static int cabNum; // 배추 수
    static int[][] map;
    static boolean[][] visited;
    static int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상,하,좌,우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            cabNum = Integer.parseInt(st.nextToken());

            map = new int[height][width];
            visited = new boolean[height][width];

            int rNum, cNum;
            for (int i = 0; i < cabNum; i++) {
                st = new StringTokenizer(br.readLine());
                cNum = Integer.parseInt(st.nextToken());
                rNum = Integer.parseInt(st.nextToken());
                map[rNum][cNum] = 1;
            }

            int worm = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        worm++;
                        bfs(i,j);
                    }
                }
            }
            sb.append(worm).append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int r, int c) {
        Queue<int[]> nextPositions = new LinkedList<>();

        visited[r][c] = true;
        nextPositions.offer(new int[] {r, c});

        while (!nextPositions.isEmpty()) {
            int[] current = nextPositions.poll();
            r = current[0];
            c = current[1];

            int newR, newC;
            for (int i = 0; i < 4; i++) {
                newR = r + move[i][0];
                newC = c + move[i][1];

                if (( 0 <= newR && newR < height) && (0 <= newC && newC < width)) {
                    if (map[newR][newC] == 1 && !visited[newR][newC]) {
                        visited[newR][newC] = true;
                        nextPositions.offer(new int[] {newR, newC}); // 기록하기
                    }
                }
            }
        }

    }
}
