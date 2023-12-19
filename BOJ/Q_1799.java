package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_1799 {

    static int N;
    static int DiagsLen;
    static int LIMIT;
    static boolean[][] unAvailable; // -1: 못놓는칸, 0: 사용가능, 1: visited
    // 대각선 단위 visited
    static boolean[] leftDiags;
    static boolean[] rightDiags;

    static int MAX = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        LIMIT = 2*N;
        DiagsLen = 2*N;
        unAvailable = new boolean[N][N];
        // 대각선 : 1-based
        leftDiags = new boolean[DiagsLen];
        rightDiags = new boolean[DiagsLen];

        String line;
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            for (int j = 0; j < N; j++) {
                unAvailable[i][j] = line.charAt(j*2) == '0';
            }
        }
        recur(0);
        System.out.println(MAX);
    }

    static void recur(int depth) {
        // basis
        MAX = Math.max(MAX, depth);
        if (depth == LIMIT) {
            System.out.println(LIMIT);
            System.exit(0);
        }
        for (int i = 1; i < DiagsLen; i++) {
            if (leftDiags[i]) continue;
            int sr = Math.max(i-N, 0);
            int sc = Math.min(N-1, i-1);
            int start = calRdIdx(sr, sc);

            int er = Math.min(N-1, i-1);
            int ec = Math.max(i-N, 0);
            int end = calRdIdx(er, ec);
            for (int j = start; j <= end; j += 2) {
                if (rightDiags[j]) continue;
                // visit
                leftDiags[i] = true;
                rightDiags[j] = true;
                recur(depth+1);
                // 복구
                leftDiags[i] = false;
                rightDiags[j] = false;
            }
        }

    }

    static int calRdIdx(int r, int c) {
        return N - c + r;
    }

}
