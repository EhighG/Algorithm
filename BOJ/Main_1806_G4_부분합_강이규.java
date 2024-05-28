package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1806_G4_부분합_강이규 {

    static int N, S;
    static long[] arr;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve());
    }

    private static long solve() {
        long minLen = 100_001;
        int l = 0, r = 1;
        while (l < r) {
            if (arr[r] - arr[l] >= S) {
                int len = r - l;
                minLen = Math.min(len, minLen);
                l++;
            } else {
                if (++r > N)
                    break;
            }
        }
        return minLen != 100_001 ? minLen : 0;
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        arr = new long[N+1];
        st = new StringTokenizer(br.readLine());


        for (int i = 1; i <= N; i++) {
            int cur = Integer.parseInt(st.nextToken());
            if (cur >= S) {
                System.out.println(1);
                System.exit(0);
            }
            arr[i] = arr[i-1] + cur;
        }
    }
}
