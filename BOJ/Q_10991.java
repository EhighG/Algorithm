package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10991 {

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());

        StringBuilder sb = new StringBuilder();
        for (int line = 1; line <= N; line++) {
            sb.append(" ".repeat(N-line));

            String stars = "* ".repeat(line);
            sb.append(stars.substring(0, stars.length()-1)).append("\n");
        }
        System.out.println(sb);
    }
}
