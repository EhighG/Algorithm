package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Q_2239 {

    static int[][] map;
    static Set<Integer>[] rows;
    static Set<Integer>[] cols;
    static Set<Integer>[] sectors;
    static List<int[]> blanks;
    static int blanksCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new int[9][9];
        blanks = new ArrayList<>();
        rows = new HashSet[10];
        cols = new HashSet[10];
        sectors = new HashSet[10];

        for (int i = 0; i < 10; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            sectors[i] = new HashSet<>();
        }

        // map 입력받기
        for (int i = 0; i < 9; i++) {
            String line = br.readLine();
            for (int j = 0; j < 9; j++) {
                int cur = line.charAt(j) - '0';
                map[i][j] = cur;
                if (map[i][j] < 1) { // 빈칸
                    blanks.add(new int[]{i, j});
                    blanksCnt++;
                } else { // 숫자칸
                    rows[i].add(cur);
                    cols[j].add(cur);
                    sectors[3*(i/3) + j/3].add(cur);
                }
            }
        }
        // 로직 실행
        dfs(0);
    }

    private static void dfs(int cnt) { // cnt = 현재 채운 칸 수. & blanks 인덱스
        if (cnt == blanksCnt) { // 다 채우면
            StringBuilder sb = new StringBuilder();
            for (int[] row : map) {
                for (int col : row) {
                    sb.append(col);
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }

        // next
        int[] next = blanks.get(cnt);
        int nr = next[0];
        int nc = next[1];

        for (int i = 1; i < 10; i++) {
            int sectNum = 3*(nr/3) + nc/3;
            if (rows[nr].contains(i)
            || cols[nc].contains(i)
            || sectors[sectNum].contains(i)) continue;

            // 채우기
            map[nr][nc] = i;
            rows[nr].add(i);
            cols[nc].add(i);
            sectors[sectNum].add(i);
            dfs(cnt+1);

            // 복구
            map[nr][nc] = 0;
            rows[nr].remove(i);
            cols[nc].remove(i);
            sectors[sectNum].remove(i);
        }
    }
}
