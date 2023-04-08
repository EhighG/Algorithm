package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_1912 {

    static int[] dp;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//        nums = Arrays.stream(br.readLine().split(" "))
//                .mapToInt(Integer::parseInt)
//                .toArray();
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[n]; // dp = curMax
        dp[0] = nums[0];

        System.out.println(solve(nums));
    }



    private static int solve(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(0, dp[i-1]) + nums[i];
            if (dp[i] > max) max = dp[i];
        }
        return max;
    }
}
