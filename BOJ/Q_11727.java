package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;

public class Q_11727 {

//    static Integer dp[]; // 가지수 % 10007이 들어갈 배열
//
//    public static void main(String[] args) throws IOException {
//        /*
//        num(n) = num(n-1) + 2 x num(n-2)
//         */
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        dp = new Integer[1001];
//        dp[1] = 1;
//        dp[2] = 3;
//
//        System.out.println(doTiling(n));
//    }
//
//    private static int doTiling(int x) {
//        if (dp[x] != null || x <= 2) {
//            return dp[x];
//        }
//        else {
//            return dp[x] = (doTiling(x-1) + 2 * doTiling(x-2)) % 10007;
//        }
//    }

    // 방식 2 : null 검사 없어서 더 빠름. / ? 시간 차이 없음
    static int dp[] = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        dp[1] = 1;
        dp[2] = 3;

        System.out.println(doTiling(n));
    }

    static int doTiling(int x) {
        int curr = 2;
        while (++curr <= x) {
            dp[curr] = (dp[curr-1] + 2 * dp[curr-2]) % 10007;
        }
        return dp[x];
    }
}
