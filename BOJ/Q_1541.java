package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1541 {

    public static void main(String[] args) throws IOException {
        /*
        1. 입력받은 문자열 분리(연산자, 피연산자)
        2. -가 하나만 나와도 그 뒤로 모두 -로 만들기 가능.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer values = new StringTokenizer(input, "+-");
        StringTokenizer operators = new StringTokenizer(input, "0123456789");


        int n = input.length();
        int minSum = 0;
        boolean canBeMinus = false;

        while (operators.hasMoreTokens()) {
            int value = Integer.parseInt(values.nextToken());
            String operator = operators.nextToken();

            minSum += (canBeMinus) ? -value : value;
            if (!canBeMinus && operator.equals("-")) canBeMinus = true;
        }

        int value = Integer.parseInt(values.nextToken());
        minSum += (canBeMinus) ? -value : value;
        System.out.println(minSum);

    }
}
