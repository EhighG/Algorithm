package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1275_G1_커피숍2_강이규 {

    static int N, Q;
    static long[] arr;
    static long[] tree;

    static long make(int node, int start, int end) {
        /*
        리프 노드까지 재귀
         */
        if (start == end) {
            return tree[node] = arr[start];
        }
        int mid = (start + end) >> 1;
        int lChild = node << 1;

        return tree[node] = make(lChild, start, mid) + make(lChild + 1, mid + 1, end);
    }

    static long getSum(int node, int start, int end, int left, int right) {
        /*
        범위 완전 밖이면 return
        범위 안에 완전 포함되면 바로 return tree[node]
        아니면 재귀
         */
        if (right < start || end < left)
            return 0;
        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) >> 1;
        int lChild = node << 1;

        return getSum(lChild, start, mid, left, right) + getSum(lChild + 1, mid + 1, end, left, right);
    }

    static void update(int node, int start, int end, int idx, long diff) {
        /*
        범위 밖이면 return
        아니면, 리프 노드까지 재귀 (값 업데이트 하면서)
         */
        if (idx < start || end < idx)
            return;
        tree[node] += diff;
        if (start == end) {
            arr[idx] = tree[node];
            return;
        }

        int mid = (start + end) >> 1;
        int lChild = node << 1;

        update(lChild, start, mid, idx, diff);
        update(lChild + 1, mid + 1, end, idx, diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        tree = new long[N << 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        make(1, 1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int left, right;
            if (x < y) {
                left = x;
                right = y;
            } else {
                left = y;
                right = x;
            }
            int idx = Integer.parseInt(st.nextToken());
            long diff = Integer.parseInt(st.nextToken()) - arr[idx];

            sb.append(getSum(1, 1, N, left, right)).append("\n");
            update(1, 1, N, idx, diff);
        }
        System.out.print(sb);
    }
}
