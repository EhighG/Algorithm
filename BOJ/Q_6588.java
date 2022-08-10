package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_6588 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int input = Integer.parseInt(br.readLine());

        // 체 구현
        boolean isPrime[] = new boolean[1_000_001]; // 숫자 1~100만 까지
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= 1000; i++) {
            if (!isPrime[i]) continue; // 이미 계산된 수는 pass
            for (int j=i*i; j <= 1_000_000; j += i) {
                isPrime[j] = false;
            }
        }

        int a;
        while (input != 0) {
            String result = "";
            a = 3;
            while(!(isPrime[a]&&isPrime[input-a])) {
                a += 2;
                if(a >= (input-a)) result += "Goldbach's conjecture is wrong.\n";
            }
//            sb.append(input).append(" = ").append(a).append(" + ").append(input - a).append("\n");
            result += input + " = " + a + " + " + (input-a) + "\n";
            sb.append(result);
            input = Integer.parseInt(br.readLine());
        }
        System.out.println(sb);
    }
}