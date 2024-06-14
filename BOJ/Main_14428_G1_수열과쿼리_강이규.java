package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_14428_G1_수열과쿼리_강이규 {
    /*
    tree엔, 해당 구간의 최솟값의 인덱스를 저장한다.
     */
    static int N;
    static int[] arr;
    static int[] tree;

    private static int make(int node, int start, int end) {
        if (start == end)
            return tree[node] = start;

        int mid = (start + end) >> 1;
        int lChild = node << 1;

        int lMinIdx = make(lChild, start, mid);
        int rMinIdx = make(lChild + 1, mid + 1, end);

        return tree[node] = arr[lMinIdx] <= arr[rMinIdx] ? lMinIdx : rMinIdx;
    }

    private static int getMin(int node, int start, int end, int left, int right) {
        if (right < start || end < left)
            return 0;
        if (left <= start && end <= right)
            return tree[node];

        int mid = (start + end) >> 1;
        int lChild = node << 1;

        int lMinIdx = getMin(lChild, start, mid, left, right);
        int rMinIdx = getMin(lChild + 1, mid + 1, end, left, right);
        return arr[lMinIdx] <= arr[rMinIdx] ? lMinIdx : rMinIdx;
    }

    private static int update(int node, int start, int end, int idx, int val) {
        if (idx < start || end < idx)
            return tree[node];

        if (start == end) {
            tree[node] = idx;
            arr[idx] = val;
            return idx;
        }
        int mid = (start + end) >> 1;
        int lChild = node << 1;

        // 자식 노드 먼저 업데이트
        int lMinIdx = update(lChild, start, mid, idx, val);
        int rMinIdx = update(lChild + 1, mid + 1, end, idx, val);
        // 중간 노드들도 갱신
        return tree[node] = arr[lMinIdx] <= arr[rMinIdx] ? lMinIdx : rMinIdx; // 값이 같으면, 인덱스가 작은 것을 반환한다.

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        tree = new int[N << 2]; // 400,000

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        make(1, 1, N);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (M-- > 0) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 1) { // update
                int idx = Integer.parseInt(st.nextToken());
                int val = Integer.parseInt(st.nextToken());
                update(1, 1, N, idx, val);
            } else { // getMin
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                sb.append(getMin(1, 1, N, left, right)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
