package algo_code.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public abstract class SegmentTree {

    private static int n;
    private static int[] arr;
    private static int[] tree;

    private static int init(int node, int start, int end) {
        /*
        리프 노드까지 재귀.
        리프 노드면, return cur = arr[node];
        아니면, return init(lChild, start, mid) + init(rChild, mid+1, end);
         */
        if (start == end)
            return tree[node] = arr[start]; // node != arr에서의 index
        int mid = (start + end) >> 1;
        int lChild = node << 1;

        return tree[node] = init(lChild, start, mid) + init(lChild + 1, mid + 1, end);
    }

    private static int sum(int node, int start, int end, int left, int right) {
        /*
        범위 밖이면, return 0
        해당 구간 전체를 포함하면, 범위값 전체 리턴 (return tree[node];)
        아니면 좁혀서 재귀
         */
        if (right < start || end < left) // 범위 밖
            return 0;
        if (left <= start && end <= right) // 해당구간 전체 포함
            return tree[node];
        // else : 재귀
        int mid = (start + end) >> 1;
        int lChild = node << 1;

        return sum(lChild, start, mid, left, right) + sum(lChild + 1, mid + 1, end, left, right);
    }

    private static void update(int node, int start, int end, int index, int diff) {
        /*
        old와 new 의 차이값은 처음부터 계산해서 가지고 들어옴
        특정 값 하나를 바꾸는 것이므로, 리프 노드(start==end)까지 들어감
        거치면서, 해당 tree[node]의 값을 diff만큼 바꾼다.
        범위 밖 체크는 포함! 해당 index가 node의 관리구간 안에 있는지 없는지
         */
        if (index < start || end < index)
            return;
        // update
        tree[node] += diff;
        // if leaf node == return
        if (start == end) {
            arr[index] = tree[node]; // 편의상 원본 값 update까지 한번에
            return;
        }
        // else : 재귀
        int mid = (start + end) >> 1;
        int lChild = node << 1;

        update(lChild, start, mid, index, diff);
        update(lChild + 1, mid + 1, end, index, diff);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        tree = new int[n << 2];

        Arrays.fill(arr, 1);
        init(1, 0, n-1); // 이진트리 형태에서 자식노드를 편하게 찾기 위해 root = 1

        StringTokenizer st;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            if (op == 0) { // get sum
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                System.out.println(sum(1, 0, n - 1, l - 1, r - 1));
            } else if (op == 1) {// update
                int idx = Integer.parseInt(st.nextToken());
                int newVal = Integer.parseInt(st.nextToken());
                update(1, 0, n-1, idx - 1, newVal - arr[idx-1]);
            } else if (op == 2) {
                break;
            } else if (op == 3) { // 디버깅용; arr, tree 출력
                System.out.println("arr = " + Arrays.toString(arr));
                System.out.println("tree = " + Arrays.toString(tree));
            }
        }
    }
}
