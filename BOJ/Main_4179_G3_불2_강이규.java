package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_4179_G3_불2_강이규 {

    static int R, C;
    static char[][] map;
    static List<Pos> fires;
    static Pos jh;
    static String IMP = "IMPOSSIBLE";
    // 방향 : 상 좌 하 우
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        init();
        int res = bfs();
        System.out.println(res > 0 ? res : IMP);
//        while (true) {
//        }
    }

    private static int bfs() {
        int time = 0;
        Queue<Pos> jq = new ArrayDeque<>();
        Queue<Pos> fq = new ArrayDeque<>();
        boolean[][] jVisited = new boolean[R][C];
        boolean[][] fVisited = new boolean[R][C];

        jq.offer(jh);
        jVisited[jh.r][jh.c] = true;
        for (Pos fire : fires) {
            fq.offer(fire);
            fVisited[fire.r][fire.c] = true;
        }
        while (!jq.isEmpty()) {
            time++;
            // fire
            Queue<Pos> tmpFq = new ArrayDeque<>(fq);
            fq.clear();
            while (!tmpFq.isEmpty()) {
                Pos curF = tmpFq.poll();
                // 불 먼저 이동
                for (int d = 0; d < 4; d++) {
                    int nr = curF.r + dr[d];
                    int nc = curF.c + dc[d];
                    if (!inRange(nr, nc) || map[nr][nc] == '#' || fVisited[nr][nc]) {
                        continue;
                    }
                    fq.offer(new Pos(nr, nc));
                    fVisited[nr][nc] = true;
                    map[nr][nc] = 'F';
                }
            }
            // 지훈
            Queue<Pos> tmpJq = new ArrayDeque<>(jq);
            jq.clear();
            while (!tmpJq.isEmpty()) {
                Pos curJ = tmpJq.poll();
                for (int d = 0; d < 4; d++) {
                    int nr = curJ.r + dr[d];
                    int nc = curJ.c + dc[d];
                    if (!inRange(nr, nc)) {
                        return time;
                    }
                    if (map[nr][nc] != '.' || jVisited[nr][nc]) {
                        continue;
                    }
                    jq.offer(new Pos(nr, nc));
                    jVisited[nr][nc] = true;
                }
            }
        }
        return -1;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        fires = new ArrayList<>();
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
                if (map[i][j] == 'J') {
                    jh = new Pos(i, j);
                } else if (map[i][j] == 'F') {
                    fires.add(new Pos(i, j));
                }
            }
        }
    }

    private static boolean inRange(int r, int c) {
        return (0 <= r && r < R) && (0 <= c && c < C);
    }


    static class Pos {
        int r, c;

        public Pos(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
