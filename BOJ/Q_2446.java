package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2446 {

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = N;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 2 * N - 1; i++) {
            int absN = Math.abs(n--);
            sb.append(" ".repeat(N-absN))
                    .append("*".repeat(2*absN - 1))
                    .append("\n");
        }
    }
}
