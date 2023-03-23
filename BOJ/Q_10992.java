package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10992 {

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder();

        for (int line = 1; line <= N; line++) {
            int strLength = line*2 - 1;

            sb.append(" ".repeat(N-line));

            if (line != 1 && line != N) {
                sb.append("*")
                        .append(" ".repeat(strLength-2))
                        .append("*");
            }
            else if (line == N) {
                sb.append("*".repeat(strLength));
            }
            else {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
