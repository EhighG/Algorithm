package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Q_11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] requiredTimes = new int[n];
        for (int i = 0; i < n; i++) {
            requiredTimes[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(requiredTimes);

        int totalTimeRequired = 0;
        int timeRequired = 0;
        for (int i = 0; i < n; i++) {
            timeRequired += requiredTimes[i];
            totalTimeRequired += timeRequired;
        }

        System.out.println(totalTimeRequired);
    }
}
