package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_2629_G3_양팔저울_강이규 {

    static int N, K;
    static int[] weights;
    static int half;
    static int[] marbles;
    static Set<Integer> possible;

    public static void main(String[] args) throws IOException {

    }



    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        weights = new int[N];
        st = new StringTokenizer(br.readLine());

        int sum = 0;
        for (int i = 0; i < N; i++) {
            weights[i] = Integer.parseInt(st.nextToken());
            sum += weights[i];
        }
        half =

        K = Integer.parseInt(br.readLine());
        marbles = new int[K];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            marbles[i] = Integer.parseInt(st.nextToken());
        }

        possible = new HashSet<>();
    }
}
