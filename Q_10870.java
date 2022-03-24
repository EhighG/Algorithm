package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_10870 {
	public static void main(String[] args) throws IOException {
		// 피보나치 수열
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(fibonacci(n));
		

	}
	static int fibonacci(int n) { // static멤버와 인스턴스 멤버 고려 필요
		if(n <= 1) return n; // 첫번째, 두번째 수는 0과 1
		return fibonacci(n-1)+fibonacci(n-2); // n번째 수 = n-1번째 수 + n-2번째 수 이므로.
	}

}
