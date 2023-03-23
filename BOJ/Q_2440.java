package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2440 {

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        StringBuilder sb = new StringBuilder();

        while (true) {
            if (n > 0) {
                for (int i = 0; i < n; i++) {
                    sb.append("*");
                }
                sb.append("\n");
            } else {
                System.out.println(sb);
                return;
            }
            n--;
        }
    }
}