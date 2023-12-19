package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Q_2234 {
    
    static int n, m;
    static int[][] map;
//    static boolean[][] visited;
    static int[][] visited;
    static int[] adjust;
    static int cnt = 0;
    static int[][] moves = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}}; // 서 북 동 남
    static int roomSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[m][n];
        visited = new int[m][n];
        adjust = new int[n*m];

        List<Integer> rooms = new ArrayList<>(50);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int[] row : map) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == 0) {
                    roomSize = 0;
                    System.out.println("dfs start, in " + i + ", " + j);
                    dfs(i, j);
                    rooms.add(roomSize);
                }
            }
        }

        System.out.println(rooms);
        Collections.sort(rooms, Collections.reverseOrder());

        StringBuilder sb = new StringBuilder();
        sb.append(rooms.size()).append("\n");
        sb.append(rooms.get(0)).append("\n");
        sb.append(rooms.get(0)+rooms.get(1)).append("\n");

        System.out.println(sb);
    }

    private static void dfs(int r, int c) {
        System.out.println("r, c = " + r + ", " + c);
        visited[r][c] = cnt;
        roomSize++;
        for (int i = 0; i < 4; i++) {
            System.out.println("r, c, i = " + r + ", " + c + ", " + i);
//            System.out.println(i + " loop");
            if ((map[r][c]&(1<<(i))) != 0) { // 성 테두리는 벽.
                System.out.println(i + " 쪽에 벽");
                continue;
            }
            System.out.print(i + " 벽 없음");
            // 해당 방향에 벽이 없다면
            int nr = r + moves[i][0];
            int nc = c + moves[i][1];
            if (visited[nr][nc] > 0) {
                if (visited[nr][nc] != cnt) {}
                System.out.println(" but visited");
                continue;
            } else {
                System.out.println();
            }
            dfs(nr, nc);
        }
    }

}
