package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_4948 {

	public static void main(String[] args) throws IOException {
		// n < x <= 2n 을 만족하는 소수 x의 개수 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n, cnt, i, j;
		
		while(true) {
			n = Integer.parseInt(br.readLine());
			if(n==0) break;
			cnt = 0;
			
			Loop1 : for(i=n+1;i<=2*n;i++) {
				for(j=2;j<=Math.sqrt(i);j++) {
					if (i % j == 0) {
						continue Loop1;
					}
				}
				cnt++;
			}
			System.out.println(cnt);
		}

	}

}
