package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1082_G3_방번호_2_강이규 {

    static int N, M;
    static int[] cost;
    static int[] res;
    static int minC;
    static int minNum;
    static int subMinC;
    static int subMinNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(br.readLine());

        minC = subMinC = 51;
        for (int i = 0; i < N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
            if (cost[i] < minC) {
                subMinC = minC;
                subMinNum = minNum;
                minC = cost[i];
                minNum = i;
            } else if (cost[i] < subMinC) {
                subMinC = cost[i];
                subMinNum = i;
            }
        }
        res = new int[M / minC];
        int remain = M - minC * res.length;

        Arrays.fill(res, minNum);
        if (minNum == 0) {
            if (subMinC - minC <= remain) {
                res[0] = subMinNum;
                remain -= subMinC - minC;
                System.out.println("remain = " + remain);
                System.out.println("Arrays.toString(res) = " + Arrays.toString(res));
            } else {
                System.out.println(0);
                System.exit(0);
            }
        }

        int len = res.length;
        Index: for (int i = 0; i < len; i++) {
            for (int j = N-1; j >= 0; j--) {
                if (i == 0 && j == 0) continue;
                int changeCost = cost[j] - cost[i];
                if (changeCost <= remain) {
                    res[i] = j;
                    remain -= changeCost;
                    System.out.println("remain = " + remain);
                    System.out.println("Arrays.toString(res) = " + Arrays.toString(res));
                    continue Index;
                }
                if (remain < subMinC - minC)
                    break Index;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : res) {
            sb.append(i);
        }
        System.out.println(sb);
    }
}
