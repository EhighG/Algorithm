package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Q_7569 {
    // 토마토 - 3차원
    static List<int[]> startpoints = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = parseInt(st.nextToken());
        int y = parseInt(st.nextToken());
        int z = parseInt(st.nextToken());

        int[][][] boxs = new int[z][y][x];

        String line;

        for (int i = 0; i < z; i++) {
            for (int j = 0; j < y; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < x; k++) {
                    int tmtStatus = parseInt(st.nextToken());

                    boxs[i][j][k] = tmtStatus; // 반복문은 가장 안쪽부터 돌게 되므로, 배열 지정 순서는 z, y, x
                    if (tmtStatus == 1) startpoints.add(new int[]{i,j,k});
                }
            }
        }

        System.out.println(bfs(boxs));

//        // 출력 확인
//        System.out.println("z = " + boxs.length);
//        System.out.println("y = " + boxs[0].length);
//
//        StringBuilder sb = new StringBuilder();
//        for (int[][] box : boxs) { // z
//            for (int[] row : box) { // y
//                for (int tmt : row) { // x
//                    sb.append(tmt).append(" ");
////                    System.out.print(tmt + " ");
//                }
////                System.out.println();
//                sb.append("\n");
//            }
////            System.out.println();
//            sb.append("\n");
//        }
//
//        System.out.println(sb);
    }

    private static int bfs(int[][][] boxs) { // boxs = [z][y][x]
        int days = 0;
        int z = boxs.length, y = boxs[0].length, x = boxs[0][0].length;

        int[][] moves = {{0,1,0}, {0,-1,0}, {0,0,-1}, {0,0,1}, {-1,0,0}, {1,0,0}};// 앞,뒤,좌,우,위,아래
        Queue<int[]> queue = new LinkedList<>(startpoints);

        while (true) {
            Queue<int[]> dailyQueue = new LinkedList<>(queue);
            queue.clear();

            while (!dailyQueue.isEmpty()) {
                int[] currentTmt = dailyQueue.poll(); // z, y, x
//                System.out.println("current = " + currentTmt[2] + " " + currentTmt[1] + " " + currentTmt[0]);

                for (int[] move : moves) {
                    int newX = currentTmt[2] + move[2], newY = currentTmt[1] + move[1], newZ = currentTmt[0] + move[0];

                    if (!isInRange(newX, x) || !isInRange(newY, y) || !isInRange(newZ, z)) {
//                        System.out.println("filtered = " + newX + " " + newY + " " + newZ);
                        continue;
                    }
                    if (boxs[newZ][newY][newX] != 0) continue;

                    boxs[newZ][newY][newX] = 1;
                    queue.add(new int[]{newZ,newY,newX});

                }
            }
            if (queue.isEmpty()) break; // 마지막에 반복은 한번 더 하지만, days++까지 가지 않음.
            days++;

        }

//        // (테스트) 출력
//        for (int[][] box : boxs) {
//            for (int[] row : box) {
//                for (int tmt : row) {
//                    System.out.print(tmt + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }

        // 체크
        for (int[][] box : boxs) {
            for (int[] row : box) {
                for (int tmt : row) {
                    if (tmt == 0) return -1;
                }
            }
        }

        return days;
    }

    private static boolean isInRange(int newN, int n) {
        return (0 <= newN && newN < n);
    }
}
