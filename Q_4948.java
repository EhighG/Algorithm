

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Q_4948 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n, cnt;
		boolean[] primeList = new boolean[123456*2+1];
		Arrays.fill(primeList, true);
		primeList[0] = primeList[1] = false;



		for (int i = 2; i < Math.sqrt(primeList.length); i++) {
			for(int j = i*i; j<=primeList.length; j += i) {
				primeList[j] = false;
			}
		}

		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
			cnt = 0;

			for(int i=n+1; i<=2*n; i++) {
				if (primeList[i]) cnt++;
			}
			sb.append(cnt + "\n");
		}
		System.out.println(sb);
	}

}

// // old code

//package Baekjoon;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Q_4948 {
//
//	public static void main(String[] args) throws IOException {
//		// n < x <= 2n 을 만족하는 소수 x의 개수 구하기
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n, cnt, i, j;
//
//		while(true) {
//			n = Integer.parseInt(br.readLine());
//			if(n==0) break;
//			cnt = 0;
//
//			Loop1 : for(i=n+1;i<=2*n;i++) {
//				for(j=2;j<=Math.sqrt(i);j++) {
//					if (i % j == 0) {
//						continue Loop1;
//					}
//				}
//				cnt++;
//			}
//			System.out.println(cnt);
//		}
//
//	}
//
//}
