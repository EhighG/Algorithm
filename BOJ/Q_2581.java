package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Q_2581 {

	public static void main(String[] args) throws IOException {
		// M이상 N이하 소수 min, sum 구하기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int m = Integer.parseInt(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		int i,j;
		int min = -1;
		int sum = 0; 
		int startPoint = Math.max(2, m);
		
		Loop1 : for(i = startPoint; i <= n; i++) { // 1은 소수가 아니므로 고려할 필요가 없다.
		 for(j=1; j<i; j++) {
			 if (i%j == 0 && j != 1) { // 1이 아닌, 나눠지는 수가 발견될 시
				 continue Loop1; // 해당 숫자(i)는 소수가 아니므로 Pass.
			 }
		 }
		if (min == -1) min = i; // 처음 발견된 소수라면, min에 저장
		sum += i;
		}
		
		if(sum==0) {
			System.out.println(-1);
		} else {
			System.out.println(sum+"\n"+min);
		}
	}
}