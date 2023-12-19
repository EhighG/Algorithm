package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_5639 {

    static int[] arr = new int[10001];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        // 트리 만들기
        arr[1] = Integer.parseInt(line);

        while ((line = br.readLine()) != null) {
            int input = Integer.parseInt(br.readLine());

            int idx = 1;
            while (idx < 10001 && arr[idx] != 0) {
                idx *= 2;
                if (arr[idx] < input) idx++;
            }
            arr[idx] = input;
        }

        // 후위순회
        reverseOrder(1);
        System.out.println(sb);
    }

    static void reverseOrder(int idx) {
        // return
        if (idx > 10000 || arr[idx] == 0) return;
        int cur = arr[idx];
        // left
        idx *= 2;
        reverseOrder(idx);
        // right
        idx++;
        reverseOrder(idx);
        // cur
        sb.append(cur).append("\n");
    }
}
