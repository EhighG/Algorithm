package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2_1010 {

    static int N;
    static int[] trees;
    static int maxHeight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            trees = new int[N];
            maxHeight = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
            }

            int oddCnt = 0;
            int evenCnt = 0;
            int res = 0;
            for (int tree : trees) {
                int gap = maxHeight - tree;
                oddCnt += gap % 2;
                evenCnt += gap / 2;
            }

            if (evenCnt > oddCnt) {
                while (Math.abs(evenCnt - oddCnt) > 1) {
                    evenCnt--;
                    oddCnt += 2;
                }
            }

            if (oddCnt > evenCnt) res += oddCnt * 2 - 1;
            else res += evenCnt * 2;

            sb.append("#").append(t).append(" ").append(res).append("\n");
        }
        System.out.println(sb);
    }
}