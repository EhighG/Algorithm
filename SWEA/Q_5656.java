package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Q_5656 {

    static int N, W, H;
    static int[][] mapOrigin; // (H+1)*w / map[0] = top idx
    static int[][] map;
    static Stack<Integer>[] stacks;
    static int[] selected;
    static int minResult;
    static int[][] moves = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            mapOrigin = new int[H+1][W];
            map = new int[H+1][W];
            selected = new int[N];
            stacks = new Stack[W];
            for (int c = 0; c < W; c++) {
                stacks[c] = new Stack<>();
            }
            minResult = 181; // maxH * maxW + 1

            for (int i = 1; i <= H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    int cur = Integer.parseInt(st.nextToken());

                    if (mapOrigin[0][j] < 1 && cur != 0) mapOrigin[0][j] = H - i + 1; // top idx update
                    mapOrigin[i][j] = cur;
                }
            }

            permutation(0);

            sb.append("#").append(t).append(" ").append(minResult).append("\n");
        }
        System.out.print(sb);
    }

    private static void permutation(int depth) {
        if (depth == N) {
            // deepcopy
            for (int i = 0; i <= H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = mapOrigin[i][j];
                }
            }
            for (int i : selected) {
                shoot(i);
//                System.out.println("====================== after shooting");
//                printMap();
                updateMap();
//                System.out.println("====================== after updateMap");
//                printMap();
            }
            minResult = Math.min(minResult, countBlocks());
            if (countBlocks() == 22) {
                for (int i = 0; i <= H; i++) {
                    for (int j = 0; j < W; j++) {
                        map[i][j] = mapOrigin[i][j];
                    }
                }
                for (int i : selected) {
                    System.out.println();
                    System.out.println("cur = " + i);
                    System.out.println();

                    System.out.println("================= before shooting");
                    printMap();
                    shoot(i);
                    System.out.println("================= after shooting");
                    printMap();
                    updateMap();
                    System.out.println("================= after update");
                    printMap();
                }
            }
            return;
        }

        for (int i = 0; i < W; i++) {
            selected[depth] = i;
            permutation(depth+1);
        }
    }

    /**
     * for debug
     */
    private static void printMap() {
        for (int i = 0; i <= H; i++) {
            for (int j = 0; j < W; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void shoot(int c) {
        int r = Math.min(H - map[0][c] + 1, H);
        int power = map[r][c];

        bomb(r, c, 0, power); // 첫 방향은 상관없다.
    }

    /**
     * 재귀호출될 메소드
     * @param r
     * @param c
     */
    private static void bomb(int r, int c, int d, int cnt) {
        if (cnt == 0 || !inRange(r, c)) return;

        int cur = map[r][c];
        map[r][c] = 0;

        if (cur < 2) bomb(r+moves[d][0], c+moves[d][1], d, cnt-1);
        else {
            for (int i = 0; i < 4; i++) {
                int[] move = moves[i];
                int newCnt = i != d ? cnt : Math.max(cnt-1, cur-1);
                bomb(r+move[0], c+move[1], i, newCnt);
            }
        }
    }

    private static void updateMap() {
        int[][] newMap = new int[H+1][W];

        // 넣기
        for (int i = 1; i <= H; i++) {
            for (int j = 0; j < W; j++) {
                int cur = map[i][j];
                if (cur != 0) stacks[j].add(cur);
            }
        }

        // 빼기
        for (int i = 0; i < W; i++) {
            int size = stacks[i].size();
            for (int j = 0; j < size; j++) {
                int cur = stacks[i].pop();
                newMap[H - newMap[0][i]++][i] = cur;
            }
        }
        map = newMap;
    }

    private static int countBlocks() {
        int result = 0;
        for (int topIdx : map[0]) {
            result += topIdx;
        }
        return result;
    }

    private static boolean inRange(int r, int c) {
        return (1 <= r && r <= H) && (0 <= c && c < W);
    }
}