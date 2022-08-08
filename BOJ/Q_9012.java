package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_9012 {

	public static void main(String[] args) throws IOException {
		// 괄호 문자열 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int check;
		int T = Integer.parseInt(br.readLine());
		
		Loop1 : for(int i=0; i<T; i++) {
			check = 0;
			char[] input = br.readLine().toCharArray();
			
			for(char j:input) {
				if (j=='(') check++;
				else check--;
				
				if(check < 0) { // 중간에 )가 더 많아질 때
					System.out.println("NO");
					continue Loop1;
				}
			}
			if(check != 0) System.out.println("NO"); // 안 닫힌 괄호가 있을 때
			else System.out.println("YES");
		}
		
	}

}
