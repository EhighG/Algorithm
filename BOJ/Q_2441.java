package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2441 {

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = N;
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (n > 0) {
                sb.append(" ".repeat(N-n)).append("*".repeat(n));
                sb.append('\n');
            } else {
                System.out.println(sb);
                return;
            }
            n--;
        }
    }
}