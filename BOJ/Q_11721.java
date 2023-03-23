package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11721 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line = br.readLine();

        int length = line.length();
        int idx = 0;

        while(idx != length) {
            int newIdx = Math.min(idx+10, length);
            sb.append(line.substring(idx, newIdx)).append("\n");

            idx = newIdx;
        }
        System.out.println(sb);
    }
}
