package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_1929 {

	public static void main(String[] args) throws IOException {
		// 범위 내의 소수 찾기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		int i,j;
		int bigger = Math.max(3,  m); // line 19,21,27 => for문 안의 if(i==1), if(i==2)를 없애기 위해 사용.
		
		if(m < 3) sb.append("2\n");
		
		/* if n이 n/2로 나눠진다면, 2에서 이미 걸러졌다.
		 * n/3도 마찬가지.
		 *  --> 이러한 작은 수들이 n의 약수가 아닐 경우, n이 가질 수 있는 가장 큰 약수는 sqrt(n)이다.(이보다 큰 수가 있다면 그 전 단계에서 걸러진다.)
		 */
		Loop1 : for (i=bigger;i<=n;i++) {
			for(j=2;j<=Math.sqrt(i);j++) {
				if (i%j == 0) {
					continue Loop1; 
				}
			}
				sb.append(i+"\n"); 
		}
		System.out.print(sb.toString());
	}

}
