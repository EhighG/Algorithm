package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_11053 {

    static int[] nums;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        nums = new int[N+1];
        dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;

        System.out.println(findSequence(N, nums[nums.length-1]));
        for (int i : dp) {
            System.out.print(i + " ");
        }
    }

    private static int findSequence(int n, int first) {
        if (n == 1) return 1;
        if (first > nums[n-1]) { // 가능할 때 : (1)이어서.
            int newFirst = nums[n-1];

        } else { // 불가능할 때 : (2)패스하거나, (3) 초기화하거나.

        }
        return 0;
    }
}
