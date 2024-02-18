package BOJ;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15684_G3_사다리조작_강이규 {

    static int N, M, H;
    static boolean[][] ladder;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i <= 3; i++) {
            bt(1, 0, i);
        }
        System.out.println(-1);
    }

    private static void bt(int r, int cnt, int max) {
        if (cnt == max) {
            if (check()) {
                System.out.println(max);
                System.exit(0);
            }
        }

        for (int i = r; i < H; i++) {
            for (int j = 1; j < M; j++) {
                if (!(ladder[i][j-1] || ladder[i][j] || ladder[i][j+1])) {
                    ladder[i][j] = true;
                    bt(r, cnt+1, max);
                    ladder[i][j] = false;
                }
            }
        }
    }

    private static boolean check() {
        for (int c = 1; c <= M; c++) {
            int cur = c;
            for (int r = 1; r <= H; r++) {
                if (ladder[r][cur]) cur++;
            }
            if (cur != c) return false;
        }
        return true;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        ladder = new boolean[31][11];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            ladder[r][c] = true;
        }
    }
}
