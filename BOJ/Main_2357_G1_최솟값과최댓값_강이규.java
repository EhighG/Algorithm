package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2357_G1_최솟값과최댓값_강이규 {

    static int n, m;
    static int[] input;
    static int[] tree; // len = n<<3 (n<<2 * 2)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        input = new int[n];
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }

        tree = new int[n<<3];
        init(1, 0, n-1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;

            int[] values = get(1, 0, n-1, left, right);

            sb.append(values[0]).append(" ").append(values[1]).append("\n");
        }
        System.out.println(sb);
    }

    private static int[] init(int node, int start, int end) { // 노드 = [min, max]
        if (start == end) {
            tree[node] = tree[node+1] = input[start];
            return new int[]{tree[node], tree[node+1]};
        }
        int mid = (start+end)/2;
        int nextLeft = node*2+1;
        int nextRight = nextLeft + 2;

        int[] leftVal = init(nextLeft, start, mid);
        int[] rightVal = init(nextRight, mid+1, end);

        tree[node] = Math.min(leftVal[0], rightVal[0]);
        tree[node+1] = Math.max(leftVal[1], rightVal[1]);

        return new int[]{tree[node], tree[node+1]};
    }

    /**
     *
     * @return {minValue, maxValue};
     */
    private static int[] get(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return new int[]{Integer.MAX_VALUE, -1};
        if (left <= start && end <= right) return new int[]{tree[node], tree[node+1]}; // 항상 좌측 인덱스로 들어온다.

        int nextLeft = (node<<1) + 1;
        int nextRight = nextLeft + 2;
        int mid = (start+end)>>1;

        int[] leftVal = get(nextLeft, start, mid, left, right);
        int[] rightVal = get (nextRight, mid+1, end, left, right);

        return new int[]{Math.min(leftVal[0], rightVal[0]), Math.max(leftVal[1], rightVal[1])};
    }
}
