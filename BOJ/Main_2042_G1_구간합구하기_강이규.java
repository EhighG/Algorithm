package BOJ;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Segment Tree
 * 길이 : 원소의 개수 이상인 가장 작은 2의 제곱수 * 2
 * 리프노드에 데이터 / 중간노드까진 구간값
 *
 */
public class Main_2042_G1_구간합구하기_강이규 {

    static long arr[];
    static long tree[]; // sgtree

    /**
     * 트리 build
     * @param node 노드번호
     * @param start (해당 노드의) 관리 범위-시작
     * @param end 관리 범위-끝
     * @return data : 리프노드 = 원소, 중간노드 = 구간값
     */
    static long init(int node, int start, int end) {
        if (start == end) { // 리프노드
            return tree[node] = arr[start];
        }
        int mid = (start+end)>>1;
        int left = node<<1;
        // return left + right;
        return tree[node] = init(left, start, mid) + init(left+1, mid+1, end);
    }

    /**
     *
     * @param node
     * @param start
     * @param end
     * @param left 계산할 범위-시작
     * @param right 계산할 범위-끝
     * @return 범위 밖 : 0 / 범위 내 : 단말노드 -> 원소값, 중간노드 -> 구간값
     */
    static long sum(int node, int start, int end, int left, long right) {
        if (right < start || end < left) return 0; // 범위 밖

        if (left <= start && end <= right) { // 단말노드인 경우를 포함해서, 구하려는 구간이 현재 구간을 포함할 때
            return tree[node];
        }

        int mid = (start+end)>>1;
        int next = node<<1;

        return sum(next, start, mid, left, right) + sum(next+1, mid+1, end, left, right);
    }

    static void update(int node, int start, int end, int index, long diff) {
        if (index < start || end < index) return;
        tree[node] += diff;
        if (start == end) {
            arr[index] = tree[node];
            return;
        }

        int mid = (start+end)>>1;
        int next = node<<1;


        update(next, start, mid, index, diff);
        update(next + 1, mid+1, end, index, diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // 구분자를 안 주는 경우, 미리 정해둔 후보군을 다 돌려보기 때문에 조금 더 느리다.

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new long[n];
        tree = new long[n<<2];

        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        init(1, 0, n-1);

        for (int i = 0, end = m+k; i < end; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (command==1) { // update
                update(1, 0, n-1, a-1, b-arr[a-1]);
            } else {
                bw.write(sum(1, 0, n-1, a-1, b-1) + "\n");
            }
        }
        br.close();
        bw.close();
    }
}
