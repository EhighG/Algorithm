package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_4386_G3_별자리만들기_강이규 {

    static int N;
    static int[] parent;
    static Node[] nodes;
    static PriorityQueue<Edge> pq = new PriorityQueue<>();

    private static void make() {
        parent = new int[N+1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
    }

    private static int find(int a) {
        if (parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    private static boolean union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot == bRoot)
            return false;

        parent[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve());
    }

    private static double solve() {
        double res = 0;
        int edgeCnt = 0;

        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (union(e.a, e.b)) {
                res += e.c;
                if (++edgeCnt == N - 1) break;
            }
        }
        return res;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        nodes = new Node[N+1];

        StringTokenizer st;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            nodes[i] = new Node(x, y);
            for (int j = 1; j < i; j++) {
                Node t = nodes[j];
                double distance = Math.sqrt(Math.pow(x - t.x, 2) + Math.pow(y - t.y, 2));
                pq.offer(new Edge(i, j, distance));
            }
        }
        make();
    }

    static class Node {
        double x, y;
        Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int a, b;
        double c;
        Edge(int a, int b, double c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return (this.c - o.c < 0) ? -1 : 1;
        }
    }
}
