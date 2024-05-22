package algo_code.graph;

import java.util.Arrays;

/**
 *  서로소 집합 :
 *   특정 원소(a)의  집합이 무엇인지 판별하는 역할
 *
 */
public class DisjointSet {
    static int N;

    //부모를 저장하는 배열
    static int[] parents;

    public static void make() {
        parents = new int [N];
        for (int i = 0; i < N; i++) {
            parents[i] = i;				//자기 자신을 root로 설정 한다.
        }
    }
    public static int find(int v) {
        if(v == parents[v]) {	// root
            return v;
        }
//		return find(parents[v]);
//		path compression
        return parents[v] = find(parents[v]);
    }
    public static boolean union(int a, int b) {
//		parents[b] = a;
//		parents[find(b)] = find(a);
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }
    public static void main(String[] args) {
        N= 6;
        make();
        union(4, 3);
        System.out.println(Arrays.toString(parents));
        union(2, 5);
        System.out.println(Arrays.toString(parents));
        union(5, 4);
        System.out.println(Arrays.toString(parents));
        union(4, 1);
        System.out.println(Arrays.toString(parents));
        System.out.println(find(2));
        System.out.println(find(4));
        System.out.println(Arrays.toString(parents));
        System.out.println(find(3));
        System.out.println(Arrays.toString(parents));
    }
}
