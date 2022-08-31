package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_11047 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coinTypes = new int[n];
        for (int i = 0; i < n; i++) {
            coinTypes[i] = Integer.parseInt(br.readLine());
        }

        int cnt = 0;

        while (--n >= 0) {
            int currentCnt = k/coinTypes[n]; // 몫
            cnt += currentCnt;
            k -= currentCnt * coinTypes[n];
        }
        System.out.println(cnt);
    }
}
