package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Q_7576 {

    static int[][] tomatos;
    static int width, height;
    static int[][] moves = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상,하,좌,우
    static LinkedList<int[]> starts = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // 시작점이 여러 개인 bfs
        // 모두 방문 처리되면 끝
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        boolean finished = true; // 이미 다 익은 경우 방지

        tomatos = new int[height][width];

        int current;
        for (int i = 0; i < height; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < width; j++) {
                current = Integer.parseInt(st.nextToken());
                tomatos[i][j] = current;
                if (current == 0) finished = false;
                else if (current == 1) starts.add(new int[] {i,j});
            }
        }

        if (starts.size() == 0) System.out.println(-1);
        else if (finished) System.out.println(0);
        else {
            int days = bfs();
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (tomatos[i][j] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
            System.out.println(days);
        }


    }

    private static int bfs() { // return min_days
        ArrayDeque<int[]> deq = new ArrayDeque<>();
        ArrayDeque<int[]> innerDeq = new ArrayDeque<>();
        int days = -1;
        innerDeq.addAll(starts);

        do {
            days++;
            deq.clear();
            while(!innerDeq.isEmpty()) {
                int[] current = innerDeq.poll();
                for (int[] move : moves) {
                    int newR = current[0] + move[0];
                    int newC = current[1] + move[1];

                    if ((0 <= newR && newR < height) && (0 <= newC && newC < width)) { // 범위 안에 들고
                        if (tomatos[newR][newC] == 0) { // 1이었다면 처음부터 starts로 들어왔음.
                            deq.add(new int[]{newR,newC});
                            tomatos[newR][newC]++; // 0 -> 1
                        }
                    }
                }
            }
            innerDeq.addAll(deq);
        } while (!deq.isEmpty()); // 조건을 (tomatos가 모두 익으면) 으로 하면 좋겠지만, 복잡함. 그래서 이렇게 하면,
        // 원래 답보다 하루가 더 돌게 됨.(마지막날에 익는 토마토가 deq에 남아있으므로.) 따라서 days 초기값을 -1
        return days;
    }
}
