package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_13305 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dists = new int[n-1];
        for (int i = 0; i < n-1; i++) {
            dists[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int[] prices = new int[n-1]; // 마지막 도시의 정보는 필요 X
        for (int i = 0; i < n-1; i++) {
            prices[i] = Integer.parseInt(st.nextToken());
        }

        long minPrice = 1_000_000_000;
        int currentDist = 0;
        long minCost = 0;
        for (int i = 0; i < n - 1; i++) {
            if (prices[i] < minPrice) {
                minCost += currentDist*minPrice; // 만약 둘 다 int형이면, 우선 곱셈 결과가 int형으로 저장된 후(초과된 부분이 버려진 후) long으로 형변환됨.
                minPrice = prices[i];
                currentDist = 0;
            }
            currentDist += dists[i];
        }

        minCost += currentDist*minPrice;

        System.out.println(minCost);
    }
}
