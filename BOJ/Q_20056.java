package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_20056 {
    static class FireBall {
        int r;
        int c;
        int m;
        int s;
        int d;

        public FireBall() {}

        public FireBall(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int N;
    static int M;
    static int K;
    static int[][] moves = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static Queue<FireBall>[][] map;
    static int[][] qSize;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받기
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new ArrayDeque[N][N];
        qSize = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = new ArrayDeque<>();
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r, c, m, s, d;
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            s = Integer.parseInt(st.nextToken());
            d = Integer.parseInt(st.nextToken());

            map[r-1][c-1].offer(new FireBall(r-1, c-1, m, s, d));
        }

        doLogic();
        // 결과 출력
        int totalWeight = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (FireBall ball : map[i][j]) {
                    totalWeight += ball.m;
                }
            }
        }
        System.out.println(totalWeight);
    }

    private static void doLogic() {
        for (int k = 0; k < K; k++) {
            move();
            updateFireBalls();
        }
    }

    private static void move() {
        // 큐 사이즈 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                qSize[i][j] = map[i][j].size();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int size = qSize[i][j];
                if (size < 1) continue;

                Queue<FireBall> q = map[i][j];

                while (size-- > 0) {
                    FireBall ball = q.poll();

                    int[] move = moves[ball.d];
                    int nr = ball.r + move[0] * ball.s;
                    int nc = ball.c + move[1] * ball.s;

                    // check range
                    if (nr < 0) nr = N-1 - (-nr - 1) % N;
                    else if (nr > N-1) nr %= N;
                    if (nc < 0) nc = N-1 - (-nc - 1) % N;
                    else if (nc > N-1) nc %= N;

                    map[nr][nc].add(ball);
                    ball.r = nr;
                    ball.c = nc;
                }
            }
        }
    }

    private static void updateFireBalls() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                // combine
                int size = map[i][j].size();
                if (size < 2) continue;
                int totalWeight = 0;
                int totalSpeed = 0;
                boolean allIsOdd = true;
                boolean allIsEven = true;
                Queue<FireBall> cur = map[i][j];

                for (int k = 0; k < size; k++) {
                    FireBall ball = cur.poll();
                    totalWeight += ball.m;
                    totalSpeed += ball.s;
                    int tmp = ball.d % 2;
                    if (tmp != 0) allIsEven = false;
                    else allIsOdd = false;
                }

                // divide
                int newWeight = totalWeight / 5;
                if (newWeight < 1) continue;
                int newSpeed = totalSpeed / size;

                int base = (allIsOdd || allIsEven) ? 0 : 1;
                for (int d = 0; d < 7; d += 2) {
                    cur.add(new FireBall(i, j, newWeight, newSpeed, d+base));
                }
            }
        }
    }
}
