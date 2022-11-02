package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_2667 {

    static boolean[][] visited;
    static int[][] map;
    static int n;
    static int danji = 0;
    static int[] danjiSize;
    static int[][] move = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // 상,하,좌,우
    public static void main(String[] args) throws IOException {

        // 입력 -> 2차원 배열
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        danjiSize = new int[n*n/2 + 1];

        for (int i = 0; i < n; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = input[j] - '0';
            }
        }

        // dfs 시작 지점(새 단지) 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    danji++;
                    dfs(i, j);
                }
            }
        }

        // 결과 출력
        int[] result = Arrays.copyOf(danjiSize, danji);
        Arrays.sort(result);

        StringBuilder sb = new StringBuilder();

        sb.append(danji).append("\n");
        for (int i : result) {
            sb.append(i).append("\n");
        }

        System.out.println(sb);
    }

    public static void dfs(int i, int j) {
        danjiSize[danji-1]++;
        visited[i][j] = true;

        for (int k = 0; k < 4; k++) {
            int newI = i + move[k][0];
            int newJ = j + move[k][1];

            if ((0 <= newI && newI < n) && (0 <= newJ && newJ < n)) { // 새 좌표(세로,가로)가 범위 안에 들고
                if (map[newI][newJ] == 1 && !visited[newI][newJ]) {// 1이고, 방문 안 했으면
                    dfs(newI, newJ);
                }
            }
        }
    }
}
