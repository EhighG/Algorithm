package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_9095 {
    static Integer[] dp = new Integer[12];

    public static void main(String[] args) throws IOException {
        /*
        num(n) = num(n-3) + num(n-2) + num(n-1)
               = (맨 앞이) 3인 조합의 수 + 2 조합수 + 1 조합수
        - 4 이상의 숫자는 조합 수 카운팅에 포함되지 않음(조합은 1~3으로만 이뤄져야 하므로)
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

//        int n = max(inputs);

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(findNum(n)).append("\n");
        }
        System.out.println(sb);

    }

    private static int findNum(int n) {
        if (dp[n] != null) return dp[n];
        else {
            return dp[n] = findNum(n-1) + findNum(n-2) + findNum(n-3);
        }
    }

//    private static int max(int[] arr) {
//        int max = -1;
//        for (int curr : arr) {
//            if (curr > max) max = curr;
//        }
//        return max;
//    }
}
