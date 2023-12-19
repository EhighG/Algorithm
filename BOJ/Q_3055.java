package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_3055 {

    static int R, C;
    static char[][] map;
    static boolean[][] visited;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        int[] start = new int[2];
        List<int[]> waters = new ArrayList<>(20);

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                char cur = line.charAt(j);
                map[i][j] = cur;
                if (cur == '*') waters.add(new int[] {i, j});
                else if (cur == 'S') {
                    start[0] = i;
                    start[1] = j;
                }
            }
        }
        int res = bfs(start, waters);
        System.out.println((res != -1) ? res : "KAKTUS");
    }

    private static int bfs(int[] dochiStart, List<int[]> waterStarts) {
        Queue<int[]> dochiQ = new ArrayDeque<>();
        Queue<int[]> waterQ = new ArrayDeque<>();

        for (int[] waterPos : waterStarts) {
            waterQ.offer(waterPos);
        }
        dochiQ.offer(dochiStart);
        visited[dochiStart[0]][dochiStart[1]] = true;

        int minute = 1;
        while (!dochiQ.isEmpty()) {

            // water
            int waterSize = waterQ.size();
            while (waterSize-- > 0) {
                int[] cur = waterQ.poll();
                for (int[] move : moves) {
                    int nr = cur[0] + move[0];
                    int nc = cur[1] + move[1];

                    if (!inRange(nr, nc) || map[nr][nc] != '.') continue;
                    // visited
                    map[nr][nc] = '*';
                    waterQ.offer(new int[] {nr, nc});
                }
            }

            int nextSize = dochiQ.size();

            while (nextSize-- > 0) {
                int[] cur = dochiQ.poll();

                for (int[] move : moves) {
                    int nr = cur[0] + move[0];
                    int nc = cur[1] + move[1];

                    if (!inRange(nr, nc)) continue;
                    if (map[nr][nc] == 'D') return minute; // 도착
                    if (map[nr][nc] != '.') continue;
                    if (visited[nr][nc]) continue;

                    visited[nr][nc] = true;
                    dochiQ.offer(new int[] {nr, nc});
                }
            }
            minute++;
        }
        return -1;
    }

    private static boolean inRange(int r, int c) {
        return (0 <= r && r < R) && (0 <= c && c < C);
    }
}