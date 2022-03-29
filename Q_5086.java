package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Q_5086 {

	public static void main(String[] args) throws IOException {
		// 배수와 약수
		BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int a,b;
		
		while(true) {
			st = new StringTokenizer(bReader.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			if (a+b==0) return; // a=0, b=0 일 때
			
			if(b%a == 0) System.out.println("factor");
			else if (a%b == 0) System.out.println("multiple");
			else System.out.println("neither");
		}
		
	}

}
