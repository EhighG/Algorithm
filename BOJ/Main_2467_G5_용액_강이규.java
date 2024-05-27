package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2467_G5_용액_강이규 {

    static int N;
    static int[] arr;
    static long min;
    static int minL;
    static int minR;

    public static void main(String[] args) throws IOException {
        init();
        findMin();
        System.out.println(minL + " " + minR);
    }

    private static void findMin() {
        int l = 0, r = N-1;
        long min = 2_000_000_001L;
        while (l < r) {
            long sub = arr[l] + arr[r];
            long abs = Math.abs(sub);
            if (abs < min) {
                min = abs;
                minL = arr[l];
                minR = arr[r];
            }

            if (sub > 0)
                r--;
            else if (sub < 0)
                l++;
            else
                break;
        }
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }
}
