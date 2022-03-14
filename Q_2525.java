package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Q_2525 {

	public static void main(String[] args) throws IOException{
		// Setting oven timer
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 현재 시각
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		// 소요 시간
		int timeRequired = Integer.parseInt(br.readLine());
		
		while (timeRequired != 0) {
			if (timeRequired+minute >= 60) { // hour도 변경해줘야 할 때
				if (hour == 23) hour = 0;
				else hour++;
				
				// hour++ 된 후
				timeRequired -= (60 - minute);
				minute = 0;
			} else {
				minute += timeRequired;
				timeRequired = 0;
			}
		}
		System.out.printf("%d %d\n", hour, minute);

	}

}
