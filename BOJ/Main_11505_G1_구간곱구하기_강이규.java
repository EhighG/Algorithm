package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11505_G1_구간곱구하기_강이규 {

    static int n, m, k;
    static int[] input;
    static int[] tree;
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        input = new int[n];
        tree = new int[n<<2];

        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        init(1, 0, n-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0, cnt = m+k; i < cnt; i++) {
            st = new StringTokenizer(br.readLine());
            int cmd, b, c;
            cmd = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (cmd == 1) {
                update(1, 0, n-1, b-1, c);
            } else {
                sb.append(mul(1, 0, n-1, b-1, c-1)).append("\n");
            }
        }
        System.out.println(sb);

    }

    private static int init(int node, int start, int end) {
        if (start == end) {
            return tree[node] = input[start]; // 입력의 모든 수는 100만 이하
        }
        int mid = (start+end)>>1;
        int left = node<<1;

        return tree[node] = (int)((long)init(left, start, mid)*init(left+1, mid+1, end) % MOD);
    }

    private static int mul(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return 1;
        if (left <= start && end <= right) return tree[node]; // 단일 요소는 다 mod처리 된 상태
        int mid = (start+end)>>1;
        int next = node<<1;

        return (int)((long)mul(next, start, mid, left, right) * mul(next+1, mid+1, end, left, right) % MOD);
    }

    private static void update(int node, int start, int end, int idx, int changeTo) {
        if (idx < start || end < idx) {
            return;
        }
        if (start == end) {
            input[start] = changeTo;
            tree[node] = input[start];
        } else {
            int mid = (start+end)>>1;
            int next = node<<1;
            update(next, start, mid, idx, changeTo);
            update(next+1, mid+1, end, idx, changeTo);
            tree[node] = (int)((long)tree[next] * tree[next + 1] % MOD);
        }
    }
}
