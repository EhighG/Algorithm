package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15824_G2_너봄에는캡사이신이맛있단다_강이규 {
    /*
     * 1. 가능한 모든 최소-최대값 조합 : i = 1 ~ N인 경우에 대해, (i가 최소값인 조합 + i가 최대값인 조합)을 모두 더한 것
     *   1에서 구한 조합들에는 중복이 발생한다. 배열이 a, b, c일 때,
     *     i = a이고, i가 최소값인 조합을 구할 때 c - a가 한번 나오고,
     *     i - c이고, i가 최대값인 조합을 구할 때 c - a가 또 나온다.
     *   그러나 각 경우에 대해, i = a일 땐 -a만 계산하고, i = c일 땐 +c만 계산해서 상관 없다.
     * 2. i가 최대값인 조합의 수 = 1 ~ i-1번째까지의 원소를 포함하거나, 포함하지 않은 경우의 수
     *   = 2^(i-1)
     *   반대쪽도 마찬가지이다. i가 최소값인 경우의 수 = 2^(n - i)
     *   정확히는, 위 식에는 i 앞이나 뒤 원소가 모두 선택되지 않은 경우 (i만 있는 경우) 를 포함하므로 빼줘야 하지만,
     *   양쪽 다 뺴줘야 하는 것이므로 생략해도 된다.
     *   즉, (2^(i-1) - 1) * arr[i] - (2^(n-i) - 1) * arr[i]
     *     = 2^(i-1) * arr[i] - 2^(n-i) * arr[i]
     */

    static int N;
    static int[] score;
    static final int MOD = 1_000_000_007;
    static long[] pow;

    public static void main(String[] args) throws IOException {
        init();
        Arrays.sort(score);
        System.out.println(solve());
    }

    private static long solve() {
        long res = 0;
        for (int i = 1; i <= N; i++) {
            res += (pow[i-1] - pow[N-i]) * score[i];
            res %= MOD;
        }
        return res;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        score = new int[N + 1];
        pow = new long[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            score[i] = Integer.parseInt(st.nextToken());
        }

        pow[0] = 1;
        for (int i = 1; i <= N; i++) {
            pow[i] = pow[i-1] * 2 % MOD;
        }
    }
}
