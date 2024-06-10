package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17143_G1_낚시왕_강이규 {

    static int R, C, M;
    static Shark[][] map;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, -1, 0, 1};
    static int res = 0;

    public static void main(String[] args) throws IOException {
        init();
        // 메인 로직
        for (int c = 0; c < C; c++) {
            // 상어 잡기
            for (int r = 0; r < R; r++) {
                if (map[r][c] != null) {
                    res += map[r][c].z;
                    map[r][c] = null;
                    break;
                }
            }
            // 상어 이동 - 1. 큐에 저장
            Queue<Shark> q = new ArrayDeque<>();
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] != null) {
                        q.offer(new Shark(i, j, map[i][j].s, map[i][j].d, map[i][j].z));
                        map[i][j] = null;
                    }
                }
            }
//            // 상어 이동 - 2. map 초기화
//            map = new Shark[R][C];

            // 상어 이동 - 3. 새 map에 넣고 이동
            while (!q.isEmpty()) {
                Shark s = q.poll();

                moveShark(s);
                // 위치 업데이트 & 잡아먹는 동작
                if (map[s.r][s.c] != null && map[s.r][s.c].z >= s.z)
                    continue;
                map[s.r][s.c] = s;
            }
        }
        System.out.println(res);
    }

    private static void moveShark(Shark s) {
        int speed = s.s;
        if (s.d == 0 || s.d == 2) {
            speed %= (R - 1) * 2; // speed = ((R-1) * 2) % speed
        } else {
            speed %= (C - 1) * 2;
        }

        for (int i = 0; i < speed; i++) {
            int nr = s.r + dr[s.d];
            int nc = s.c + dc[s.d];

            if (inRange(nr, nc)) {
                s.r = nr;
                s.c = nc;
                continue;
            }
            // 현재 끝에 있을 때
            s.r -= dr[s.d];
            s.c -= dc[s.d];
            s.d = (s.d + 2) % 4;
        }
    }

    private static boolean inRange(int r, int c) {
        return (0 <= r && r < R) && (0 <= c && c < C);
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new Shark[R][C];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            if (d == 1) {
                d = 0;
            } else if (d == 4) {
                d = 1;
            }
            map[r-1][c-1] = new Shark(r-1, c-1, s, d, z);
        }
    }

    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }
}
