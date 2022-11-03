package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1012 {

    static int width, height;
    static int cabNum; // 배추 수
    static int[][] map;
    static boolean[][] visited;
    static int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상,하,좌,우

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T --> 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            width = Integer.parseInt(st.nextToken());
            height = Integer.parseInt(st.nextToken());
            cabNum = Integer.parseInt(st.nextToken());

            map = new int[height][width];
            visited = new boolean[height][width];

            int rNum, cNum;
            for (int i = 0; i < cabNum; i++) {
                st = new StringTokenizer(br.readLine());
                cNum = Integer.parseInt(st.nextToken());
                rNum = Integer.parseInt(st.nextToken());
                map[rNum][cNum] = 1;
            }

            int worm = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        worm++;
                        dfs(i, j);
                    }
                }
            }
            sb.append(worm).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int rNum, int cNum) {
        visited[rNum][cNum] = true;

        int newRNum, newCNum;
        for (int i = 0; i < 4; i++) {
            newRNum = rNum + move[i][0];
            newCNum = cNum + move[i][1];

            if ((0 <= newRNum && newRNum < height) && (0 <= newCNum && newCNum < width)) {
                if (map[newRNum][newCNum] == 1 && !visited[newRNum][newCNum]) dfs(newRNum, newCNum);
            }
        }
    }
}
