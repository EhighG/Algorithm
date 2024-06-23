package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14891_G5_톱니바퀴_강이규 {

    static final int N = 4;
    static int M;
    static final char LEFT = 'l';
    static final char RIGHT = 'r';
    static Cog[] cogs;

    public static void main(String[] args) throws IOException {
        solve();
    }
    
    private static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        cogs = new Cog[N];
        for (int i = 0; i < N; i++) {
            cogs[i] = new Cog(br.readLine());
        }

        // roll
        M = Integer.parseInt(br.readLine());
        while (M-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());
            roll(idx, d);
        }
        printRes();
    }

    private static void printRes() {
        int res = 0;
        int score = 1;
        for (Cog cog : cogs) {
            res += cog.status[cog.tPtr] == 1 ? score : 0;
            score <<= 1;
        }
        System.out.println(res);
    }

    private static void roll(int idx, int direction) {
        int d = direction * -1; // 편한 ptr계산을 위함
        // cur
        Cog s = cogs[idx];
        int preL = s.status[s.lPtr];
        int preR = s.status[s.rPtr];
        s.roll(d);
        // left
        int i = idx;
        while (--i >= 0) {
            Cog cur = cogs[i];
            if (!cur.checkRollNeeded(preL, RIGHT))
                break;
            d *= -1;
            preL = cur.status[cur.lPtr];
            cur.roll(d);
        }
        // right
        d = direction * -1;
        i = idx;
        while (++i < N) {
            Cog cur = cogs[i];
            if (!cur.checkRollNeeded(preR, LEFT))
                break;
            d *= -1;
            preR = cur.status[cur.rPtr];
            cur.roll(d);
        }
    }

    static class Cog {
        int lPtr, rPtr, tPtr;
        int[] status;

        public Cog(String status) {
            this.lPtr = 6;
            this.rPtr = 2;
            this.tPtr = 0;
            this.status = new int[8];
            for (int i = 0; i < 8; i++) {
                this.status[i] = status.charAt(i) - '0';
            }
        }

        boolean checkRollNeeded(int adj, char side) {
            int targetIdx = side == 'l' ? lPtr : rPtr;
            int target = status[targetIdx];
            return target != adj;
        }

        void roll(int d) {
            lPtr += d;
            if (lPtr < 0) lPtr += 8;
            else lPtr %= 8;
            rPtr += d;
            if (rPtr < 0) rPtr += 8;
            else rPtr %= 8;
            tPtr += d;
            if (tPtr < 0) tPtr += 8;
            else tPtr %= 8;
        }
    }
}
