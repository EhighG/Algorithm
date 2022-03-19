package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_11653 {

	public static void main(String[] args) throws IOException {
		// 소인수분해
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 숫자가 1이면 종료
		if(n == 1) return;
		
		String result = "";
		int value = n;
		
		int i = 2;
		while (i <= n) {
			if(value % i == 0) { // 약수가 나오면
				value /= i; // 나누고,
				result += i + "\n"; // 약수를 결과값에 추가
			} else i++; // 약수가 아니면 ++
		}
		
		System.out.print(result);
		
	}

}
