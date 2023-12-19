package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_3015_P5_오아시스재결합_강이규 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Pair> s = new Stack<>();
        long res = 0;

        for (int i = 0; i < n; i++) {
            int input = Integer.parseInt(br.readLine());
            Pair cur = new Pair(input, 1);

            while (!s.isEmpty() && s.peek().height <= input) {
                Pair pop = s.pop();
                res += pop.cnt; // cur와 pop (cnt != 1이라면 키가 같은것들 모두) 서로 볼 수 있음

                // 뒤의 요소가 cur를 볼 수 있다면, pop(+ 키가 같은 것)도 볼 수 있음
                if (pop.height == input) cur.cnt += pop.cnt;
            }
            if (!s.isEmpty()) res++; // cur보다 키가 큰 맨 오른쪽 요소도 cur를 볼 수 있음

            s.push(cur);
        }
        System.out.println(res);
    }

    static class Pair {
        int height, cnt;
        Pair(int height, int cnt) {
            this.height = height;
            this.cnt = cnt;
        }
    }
}
