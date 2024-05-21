package BOJ;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main_1644_G3_소수의연속합_강이규 {

    static int N;
    static boolean[] isPrime; // 0, 1은 쓰지 않음
    static int[] primes;

    public static void main(String[] args) throws IOException {
        init();
        if (N <= 2) {
            System.out.println(N - 1);
            return;
        }
        findPrimes();
        System.out.println(solve());
    }

    private static int solve() {
        int cnt = 0;
        int l = 0, r = 0, sum = primes[0];
        int len = primes.length;
        while (true) {
            if (sum < N) {
                r++;
                if (r >= len) break;
                sum += primes[r];
            } else {
                if (sum == N) {
                    cnt++;
                }
                sum -= primes[l];
                l++;
                if (l > r) break;
            }
        }
        return cnt;
    }

    private static void init() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        isPrime = new boolean[N+1];
        Arrays.fill(isPrime, true);
    }

    private static void findPrimes() {
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!isPrime[i])
                continue;
            for (int j = i*2; j <= N; j += i) {
                isPrime[j] = false;
            }
        }
        primes = IntStream.range(2, N + 1)
                .filter(i -> isPrime[i])
                .toArray();
    }
}
