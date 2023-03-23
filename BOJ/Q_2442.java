package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2442 {

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = N;

        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            sb.append(" ".repeat(n)).append("*".repeat((N-n)*2-1)).append("\n");
        }
        System.out.println(sb);
    }
}
